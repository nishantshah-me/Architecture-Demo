package com.tts.presentation.inject.component;

import android.app.Activity;


import com.tts.presentation.inject.PerActivity;
import com.tts.presentation.inject.module.ActivityModule;

import dagger.Component;

/**
 * Created by user on 04-Aug-17.
 */
@PerActivity
@Component(modules = ActivityModule.class)
public interface ActivityComponent {

    //Exposed to sub-graphs.
    Activity activity();

}
