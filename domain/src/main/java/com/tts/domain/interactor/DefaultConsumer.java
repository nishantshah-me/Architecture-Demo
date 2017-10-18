package com.tts.domain.interactor;


import com.tts.domain.exception.TTSException;

import io.reactivex.functions.Consumer;

/**
 * Created by Nishant Shah on 02-Aug-17.
 *
 * @param <T> the type parameter.
 *
 *  It is default consumer, listens all responses, before it gets deliver to presenter.
 *
 */
public abstract class DefaultConsumer<T> implements Consumer<T> {

    @Override
    public void accept(T t) throws Exception {
       /* if(t.success) {
            onNext(t);
        }else{
            onError(new TTSException(t.message));
        }*/

        onComplete();
    }


    /**
     *
     */
    public abstract void onNext(T t);

    /**
     * On complete.
     */
    public void onComplete(){
        // no-op by default.
    }

    /**
     * On error.
     *
     * @param throwable the throwable
     */
    public void onError(Throwable throwable){
        // no-op by default.
    }


}
