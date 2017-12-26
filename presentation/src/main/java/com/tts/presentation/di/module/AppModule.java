package com.tts.presentation.di.module;

import android.app.Application;
import android.content.Context;


import com.tts.domain.executor.PostExecutionThread;
import com.tts.presentation.di.UIThread;
import com.tts.presentation.navigation.Navigator;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by webwerks1 on 11/7/17.
 */


@Module
public class AppModule {

    private final Application mApplication;

    public AppModule(Application mApplication) {
        this.mApplication = mApplication;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return mApplication.getApplicationContext();
    }

    @Provides
    @Singleton
    Navigator provideNavigator(){
        return new Navigator();
    }

    @Provides
    @Singleton
    PostExecutionThread providePostExecutionThread(UIThread uiThread) {
        return uiThread;
    }


}
