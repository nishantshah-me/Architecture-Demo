package com.tts.data.di.modules;

import android.content.Context;



import com.tts.data.net.RestApi;
import com.tts.data.net.RestApiImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


/**
 * Provides network dependencies
 */
@Module
public class NetModule {


    @Singleton
    @Provides
    RestApi providesSessionDao(Context context) {
        return new RestApiImpl(context);
    }

    //-------------------------Session----------------------------



}
