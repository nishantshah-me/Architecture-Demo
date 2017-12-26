package com.tts.presentation.views.splash;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tts.presentation.presenter.BasePresenter;
import com.tts.presentation.views.BaseActivity;
import com.tts.user.arch.R;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(() -> {
            navigator.navigateToLogin(SplashActivity.this);
            finish();
        },1500);
    }


}
