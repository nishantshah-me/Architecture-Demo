package com.tts.presentation.views;

import android.content.Context;

/**
 * Created by webwerks1 on 11/7/17.
 */
public interface BaseView {

    /**
     * Sets background.
     *
     * @param drawableId the drawable id
     */
    void setBackground(int drawableId);

    /**
     * Show error.
     *
     * @param error the error
     */
    void showErrorMessage(String error);

    /**
     * Show a view with a progress bar indicating a loading process.
     */
    void showLoading();

    /**
     * Hide a loading view.
     */
    void hideLoading();

    /**
     * Context context.
     *
     * @return the context
     */
    Context context();
}
