package com.tts.data.di.modules;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.commonsware.cwac.saferoom.SafeHelperFactory;
import com.tts.data.BuildConfig;
import com.tts.data.database.AppDatabase;
import com.tts.data.database.dao.SessionDao;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Nishant on 08-Nov-17.
 */
@Module
public class DatabaseModule {

    @Singleton
    @Provides
    AppDatabase providesDatabase(Context context) {
        String DB_NAME = "tts_db";
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


}
