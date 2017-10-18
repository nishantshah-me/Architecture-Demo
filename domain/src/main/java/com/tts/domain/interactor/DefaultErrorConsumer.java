package com.tts.domain.interactor;


import io.reactivex.functions.Consumer;

/**
 * Created by user on 03-Aug-17.
 */

public class DefaultErrorConsumer implements Consumer<Throwable> {

    @Override
    public void accept(Throwable throwable) throws Exception {
        //Send failure event to base activity.
        //EventBus.getDefault().post(throwable);
    }
}
