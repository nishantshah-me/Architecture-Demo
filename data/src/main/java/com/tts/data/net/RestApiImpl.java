package com.tts.data.net;

import android.app.AuthenticationRequiredException;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.text.TextUtils;


import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.tts.data.R;
import com.tts.data.entity.SessionEntity;
import com.tts.data.exception.NetworkUnavailableException;
import com.tts.data.exception.UserNotFoundException;
import com.tts.data.net.interfaces.CustomerService;

import java.io.InterruptedIOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import okhttp3.CertificatePinner;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Implementation of {@code RestApi} as per CORE
 */
@Singleton
public class RestApiImpl implements RestApi {

    private final Retrofit api;
    private final Context context;
    String endpointUrl = "http://api.example.net";

    @Inject
    public RestApiImpl(@NonNull final Context context) {
        this.context = context;
        api = initRetrofitApi(endpointUrl, context);
    }

    /**
     * Initialise Retrofit
     *
     * @param endpointUrl endpoint Url
     * @param context     Context
     */
    private Retrofit initRetrofitApi(@NonNull final String endpointUrl, @NonNull final Context context) {
        // In tests, we'll log to Stdout
        final HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(message -> System.out.println(String.format("OKHttp: %s", message)));
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        final Interceptor requestDefaultsInterceptor = chain -> {
            Request original = chain.request();
            Request.Builder requestBuilder = original.newBuilder()
                .method(original.method(), original.body());

            if (tokens != null && !TextUtils.isEmpty(tokens.getSessionToken()))
                requestBuilder.addHeader("X-SESSION-TOKEN", tokens.getSessionToken());
            if (tokens != null && !TextUtils.isEmpty(tokens.getRequestToken()))
                requestBuilder.addHeader("X-REQUEST-TOKEN", tokens.getRequestToken());

            //"X-IS-BACKGROUND" boolean isBackground

            return chain.proceed(requestBuilder.build());
        };

        final OkHttpClient okHttp = new OkHttpClient.Builder()
            .readTimeout(20, TimeUnit.SECONDS)
            .connectTimeout(20, TimeUnit.SECONDS)
            .writeTimeout(20,TimeUnit.SECONDS)
            .addInterceptor(requestDefaultsInterceptor)
            .addInterceptor(loggingInterceptor)
            .addNetworkInterceptor(new StethoInterceptor())
            .build();

        final ExecutorService executorService = Executors.newSingleThreadExecutor();

        return new Retrofit.Builder()
            .baseUrl(endpointUrl)
            .client(okHttp)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
            .callbackExecutor(executorService)
            .build();
    }


    /**
     * Clear SessionEntity and Request tokens
     */
    @Override
    public void clearTokens() {
        tokens.clear();
    }

    /**
     * Sets the session tokens for api requests
     * @param sessionToken
     * @param requestToken
     */
    @Override
    public void setTokens(@NonNull String sessionToken, @NonNull String requestToken,@NonNull String customerId) {
        tokens.setSessionToken(sessionToken);
        tokens.setRequestToken(requestToken);
        tokens.setCustomerId(customerId);
    }

    @Override
    public CustomerService customerService() {
        return api.create(CustomerService.class);
    }


    /**
     * Start a customer's session (aka Sign-in or Log-in)
     *
     * @param username            the customer's username (email address)
     * @param password            authenticates the customer
     * @return If successful, the customer's session data
     */
    @Override
    public Observable<Response<SessionEntity>> createSession(String username, String password) {
        return Observable.create(emitter -> {
                if(!isThereInternetConnection()){
                    emitter.onError(new NetworkUnavailableException());
                    return;
                }
                //Synchronous request
                Response<SessionEntity> sessionEntity = customerService().createSession("", "", "username","password").execute();
                if(sessionEntity.isSuccessful()){
                    if(sessionEntity.body()!=null) {
                        //emitting data after transforming.
                        emitter.onNext(sessionEntity);
                        //Calling onComplete.
                        emitter.onComplete();
                    }else{
                        //unknown error
                        emitter.onError(new UnknownError());
                    }

                }else{
                    //4XX error. User not found in this case.
                    emitter.onError(new UserNotFoundException());

                }

            }
        );
    }
    /**
     * Checks if the device has any active internet connection.
     *
     * @return true device with internet connection, otherwise false.
     */
    private boolean isThereInternetConnection() {
        boolean isConnected;

        ConnectivityManager connectivityManager =
            (ConnectivityManager) this.context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        isConnected = (networkInfo != null && networkInfo.isConnectedOrConnecting());

        return isConnected;
    }
}
