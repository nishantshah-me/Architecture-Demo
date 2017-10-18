package com.tts.presentation.views.splash;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tts.presentation.presenter.BasePresenter;
import com.tts.presentation.views.BaseActivity;
import com.tts.user.arch.R;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        navigator.navigateToLogin(this);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_main;
    }

    @Override
    protected BasePresenter getPresenter() {
        return null;
    }
}
