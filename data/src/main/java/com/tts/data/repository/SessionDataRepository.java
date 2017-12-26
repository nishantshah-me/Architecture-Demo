package com.tts.data.repository;

import com.tts.data.database.dao.SessionDao;
import com.tts.data.mapper.SessionDataMapper;
import com.tts.data.net.RestApi;
import com.tts.domain.Session;
import com.tts.domain.repository.SessionRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 * Created by user on 18-Oct-17.
 */
@Singleton
public class SessionDataRepository implements SessionRepository {

    private final RestApi restApi;
    private final SessionDao sessionDao;
    private final SessionDataMapper mapper;

    @Inject
    public SessionDataRepository(RestApi restApi, SessionDao sessionDao, SessionDataMapper mapper) {
        this.restApi = restApi;
        this.sessionDao = sessionDao;
        this.mapper = mapper;
    }


    @Override
    public Observable<Session> createSession(String emailId, String password) {
        return restApi.createSession(emailId, password).map(mapper::map);
    }
}
