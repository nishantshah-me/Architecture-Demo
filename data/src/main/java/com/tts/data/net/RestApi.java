package com.tts.data.net;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;

import com.tts.data.entity.SessionEntity;
import com.tts.data.net.interfaces.CustomerService;

import java.io.IOException;

import io.reactivex.Observable;
import retrofit2.Response;

/**
 * https://api.dev.net/doc/v11
 */

public interface RestApi {

    @VisibleForTesting
    Tokens tokens = new Tokens();

    class Tokens {
        private String customerId = null;
        private String sessionToken = null;
        private String requestToken = null;

        public synchronized void clear() {
            this.sessionToken = null;
            this.requestToken = null;
        }

        public void setTokens(@NonNull final String sessionToken, @NonNull final String requestToken,@NonNull final String customerId) {
            this.sessionToken = sessionToken;
            this.requestToken = requestToken;
            this.customerId=customerId;
        }

        public String getSessionToken() {
            return sessionToken;
        }

        public void setSessionToken(String sessionToken) {
            this.sessionToken = sessionToken;
        }

        public String getRequestToken() {
            return requestToken;
        }

        public void setRequestToken(String requestToken) {
            this.requestToken = requestToken;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }
    }

    /**
     * Clear SessionEntity and Request tokens
     */
    void clearTokens();

    /**
     * Set the Session and Request tokens
     * @param sessionToken
     * @param requestToken
     */
    void setTokens(@NonNull final String sessionToken, @NonNull final String requestToken, @NonNull final String customerId);


    CustomerService customerService();

    //API
    Observable<Response<SessionEntity>> createSession(String username, String password);

}
