package com.tts.domain.repository;



import com.tts.domain.Session;

import io.reactivex.Observable;

/**
 * Created by user on 18-Oct-17.
 */

public interface SessionRepository {

    /**
     * Get an {@link Observable} which will emit a {@link Session}.
     *
     * @param emailId The email id used to retrieve user data.
     * @param password The password used to retrieve user data.
     */
    Observable<Session> createSession(String emailId, String password);
}
