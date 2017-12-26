package com.tts.data.database;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import com.commonsware.cwac.saferoom.SafeHelperFactory;
import com.tts.data.BuildConfig;
import com.tts.data.database.dao.SessionDao;
import com.tts.data.database.tables.SessionTable;

/**
 * View the database at - https://github.com/amitshekhariitbhu/Android-Debug-Database#using-android-debug-database-library-in-your-application
 */

@Database(entities = {SessionTable.class}, version = 1, exportSchema = false)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {

    public static final String DB_NAME = "tts_db";
    private static AppDatabase INSTANCE;

    public abstract SessionDao getSessionDao();




    public static AppDatabase getInMemoryDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.inMemoryDatabaseBuilder(context.getApplicationContext(),
                AppDatabase.class).build();
        }
        return INSTANCE;
    }

    public static AppDatabase getAppDatabase(Context context) {
        if (INSTANCE == null) {
            SafeHelperFactory factory = new SafeHelperFactory(new char[]{'d','p','U','a','r','K','f','d','N','2','l','N','c','M','J','2','f','P','t','E','/','='});
            Builder<AppDatabase> dbBuilder = Room.databaseBuilder(context.getApplicationContext(),
                AppDatabase.class, DB_NAME)
                .fallbackToDestructiveMigration();

            //Only encrypt database for production app
            if (BuildConfig.BUILD_TYPE.equalsIgnoreCase("release")) {
                dbBuilder.openHelperFactory(factory);
            }

            INSTANCE = dbBuilder.build();
        }
        return INSTANCE;
    }
}
