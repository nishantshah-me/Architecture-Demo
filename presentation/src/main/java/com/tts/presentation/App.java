package com.tts.presentation;

import android.app.Application;

import com.facebook.stetho.Stetho;

import com.tts.data.di.modules.DataModule;
import com.tts.presentation.di.component.ApplicationComponent;


import com.tts.presentation.di.component.DaggerApplicationComponent;
import com.tts.presentation.di.module.AppModule;


public class App extends Application {

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
        initInjector();
    }

    private void initInjector() {
        AppModule appModule=new AppModule(this);
       mApplicationComponent= DaggerApplicationComponent.builder()
                .appModule(appModule)
                .dataModule(new DataModule())
                .build();

    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }
}
