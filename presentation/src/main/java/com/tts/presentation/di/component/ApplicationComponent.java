package com.tts.presentation.di.component;



import android.content.Context;

import com.tts.data.di.modules.DatabaseModule;
import com.tts.domain.executor.PostExecutionThread;
import com.tts.domain.repository.SessionRepository;
import com.tts.presentation.App;
import com.tts.presentation.di.module.AppModule;
import com.tts.presentation.di.module.NetworkModule;
import com.tts.presentation.navigation.Navigator;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by webwerks1 on 13/7/17.
 */
@Singleton // Constraints this component to one-per-application or unscoped bindings.
@Component(modules = {AppModule.class, DatabaseModule.class, NetworkModule.class})
public interface ApplicationComponent {

    void inject(App component);

    //Expose to sub-graph
    Navigator navigator();
    PostExecutionThread postExecutionThread();
    Context context();
    SessionRepository sessionRepo();
}