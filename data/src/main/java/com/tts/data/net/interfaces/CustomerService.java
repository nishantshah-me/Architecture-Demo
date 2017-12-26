package com.tts.data.net.interfaces;



import com.tts.data.entity.SessionEntity;

import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by vincent on 2017/11/02.
 */

public interface CustomerService {

    @POST(value = "/sessions")
    Call<SessionEntity> createSession(@Header("X-SESSION-TOKEN") String sessionToken
            , @Header("X-REQUEST-TOKEN") String requestToken
            , @Query("username") String username,
                @Query("password")String password);

}
