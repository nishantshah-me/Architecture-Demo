package com.tts.presentation;

import android.app.Application;

import com.tts.data.repository.datasource.CloudDataSource;
import com.tts.presentation.inject.component.ApplicationComponent;
import com.tts.presentation.inject.component.DaggerApplicationComponent;
import com.tts.presentation.inject.component.DaggerNetworkComponent;
import com.tts.presentation.inject.component.NetworkComponent;
import com.tts.presentation.inject.module.AppModule;
import com.tts.presentation.inject.module.NetworkModule;

/**
 * Created by user on 18-Oct-17.
 */

public class App extends Application {

    private NetworkComponent mNetworkComponent;
    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initInjector();
    }

    private void initInjector() {
        AppModule appModule=new AppModule(this);
        mApplicationComponent= DaggerApplicationComponent.builder()
                .appModule(appModule)
                .build();
        mNetworkComponent = DaggerNetworkComponent.builder()
                .appModule(appModule)
                .networkModule(new NetworkModule(CloudDataSource.BASE_URL))
                .build();
    }

    public NetworkComponent getNetworkComponent() {
        return mNetworkComponent;
    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }
}
