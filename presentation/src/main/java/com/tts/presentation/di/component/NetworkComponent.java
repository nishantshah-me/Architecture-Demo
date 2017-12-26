package com.tts.presentation.di.component;


import com.tts.presentation.di.PerActivity;
import com.tts.presentation.di.module.AppModule;
import com.tts.presentation.di.module.NetworkModule;
import com.tts.presentation.views.login.LoginPresenter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by webwerks1 on 11/7/17.
 */

@Singleton
@PerActivity
@Component(modules = {AppModule.class, NetworkModule.class})
public interface NetworkComponent {
    LoginPresenter inject(LoginPresenter loginPresenter);
}
