package com.tts.presentation.di.component;



import android.content.Context;

import com.tts.data.di.modules.DataModule;

import com.tts.data.net.RestApi;
import com.tts.domain.executor.PostExecutionThread;
import com.tts.domain.repository.SessionRepository;
import com.tts.presentation.App;
import com.tts.presentation.di.module.AppModule;
import com.tts.presentation.navigation.Navigator;

import javax.inject.Singleton;

import dagger.Component;


@Singleton // Constraints this component to one-per-application or unscoped bindings.
@Component(modules = {AppModule.class, DataModule.class})
public interface ApplicationComponent {

    void inject(App component);

    //Expose to sub-graph
    Context context();

    Navigator navigator();
    PostExecutionThread postExecutionThread();

    RestApi restApi();

    SessionRepository sessionRepository();
}