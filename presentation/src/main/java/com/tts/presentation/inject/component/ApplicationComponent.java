package com.tts.presentation.inject.component;



import com.tts.presentation.inject.module.AppModule;
import com.tts.presentation.navigation.Navigator;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by webwerks1 on 13/7/17.
 */
@Singleton // Constraints this component to one-per-application or unscoped bindings.
@Component(modules = AppModule.class)
public interface ApplicationComponent {
    Navigator navigator();
}