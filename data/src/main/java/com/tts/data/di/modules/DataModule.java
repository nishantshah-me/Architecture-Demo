package com.tts.data.di.modules;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;


import com.commonsware.cwac.saferoom.SafeHelperFactory;
import com.tts.data.BuildConfig;
import com.tts.data.database.AppDatabase;
import com.tts.data.database.dao.SessionDao;
import com.tts.data.mapper.SessionDataMapper;
import com.tts.data.net.RestApi;
import com.tts.data.net.RestApiImpl;
import com.tts.data.repository.SessionDataRepository;
import com.tts.domain.repository.SessionRepository;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DataModule {

    @Provides
    @Singleton
    RestApi provideRestApi(Context context) {
        return new RestApiImpl(context);
    }

    @Singleton
    @Provides
    AppDatabase providesDatabase(Context context) {
        String DB_NAME = "databasename_db";
        RoomDatabase.Builder<AppDatabase> dbBuilder = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, DB_NAME);

        if (BuildConfig.BUILD_TYPE.equals("release")) {
            SafeHelperFactory factory = new SafeHelperFactory(new char[]{'d','p','U','a','r','K','f','d','N','2','l','N','c','M','J','2','f','P','t','E','/','='});
            dbBuilder.openHelperFactory(factory);
        }

        return dbBuilder.build();
    }

    //-------------------------Session----------------------------
    @Singleton
    @Provides
    SessionDao providesSessionDao(AppDatabase database) {
        return database.getSessionDao();
    }

    @Singleton
    @Provides
    SessionDataMapper sessionDataMapper() {
        return new SessionDataMapper();
    }

    @Singleton
    @Provides
    SessionRepository provideSessionRepository(SessionDataRepository sessionDataRepository) {
        return sessionDataRepository;
    }

}
