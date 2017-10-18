package com.tts.presentation.views;

/**
 * Created by webwerks1 on 18/7/17.
 */

public interface LoadDataView {

    void loadData();
    /**
     * Show a retry view in case of an error when retrieving data.
     */
    void showRetry(String message);

    /**
     * Hide a retry view shown if there was an error when retrieving data.
     */
    void hideRetry();
}
