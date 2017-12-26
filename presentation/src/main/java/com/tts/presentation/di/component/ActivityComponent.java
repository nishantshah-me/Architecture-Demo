package com.tts.presentation.di.component;

import android.app.Activity;


import com.tts.presentation.di.PerActivity;
import com.tts.presentation.di.module.ActivityModule;
import com.tts.presentation.views.login.LoginActivity;

import dagger.Component;

/**
 * Created by user on 04-Aug-17.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class,modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(LoginActivity loginActivity);

    //Exposed to sub-graphs.
    Activity activity();

}
