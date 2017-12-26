package com.tts.data.di.modules;

import android.content.Context;


import com.tts.data.database.dao.SessionDao;
import com.tts.data.mapper.SessionDataMapper;
import com.tts.data.net.RestApi;
import com.tts.data.net.RestApiImpl;
import com.tts.data.repository.SessionDataRepository;
import com.tts.domain.repository.SessionRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


/**
 * Provides network dependencies
 */
@Module
public class NetModule {


    @Singleton
    @Provides
    RestApi providesSessionDao(Context context) {
        return new RestApiImpl(context);
    }

    //-------------------------Session----------------------------
    @Singleton
    @Provides
    SessionRepository sessionRepository(RestApi restApi, SessionDao sessionDao, SessionDataMapper mapper){
        return new SessionDataRepository(restApi,sessionDao,mapper);
    }


}
