package com.tts.data.mapper;

import com.tts.data.entity.SessionEntity;
import com.tts.domain.Session;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Response;

/**
 * Created by Nishant on 26-Dec-17.
 */
@Singleton
public class SessionDataMapper {

    @Inject
    public SessionDataMapper() {
    }

    public Session map(Response<SessionEntity> sessionEntityResponse) {
        SessionEntity sessionEntity = sessionEntityResponse.body();
        Session session = new Session();
        session.token = sessionEntity.token;
        return session;
    }
}
