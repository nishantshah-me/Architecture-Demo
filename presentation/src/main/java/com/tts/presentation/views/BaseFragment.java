package com.tts.presentation.views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.tts.presentation.presenter.BasePresenter;

import butterknife.ButterKnife;

/**
 * Created by webwerks1 on 12/7/17.
 */

public abstract class BaseFragment <T extends BasePresenter> extends Fragment implements BaseView {

    protected T mPresenter;
    public static final String KEY_CONTENT_ID="key_content_id";
    protected String userId;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(getLayout(), container, false);
        ButterKnife.bind(this,rootView);
        mPresenter = getPresenter();
        mPresenter.start();
        return rootView;
    }


    @Override
    public void showErrorMessage(String message) {
        Toast.makeText(getContext(),message,Toast.LENGTH_LONG).show();
    }

    protected abstract T getPresenter();
    protected abstract int getLayout();



}

