package com.tts.presentation.views.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.design.widget.Snackbar;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.UnderlineSpan;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.tts.presentation.App;
import com.tts.presentation.di.component.ActivityComponent;


import com.tts.presentation.di.component.DaggerActivityComponent;
import com.tts.presentation.di.module.ActivityModule;
import com.tts.presentation.views.BaseActivity;
import com.tts.user.arch.R;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import dagger.Provides;

/**
 * Created by webwerks1 on 11/7/17.
 */

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.View {

    @BindView(R.id.btnLogin)
    Button btnLogin;
    @BindView(R.id.etEmail)
    EditText email;
    @BindView(R.id.etPassword)
    EditText password;

    private Snackbar snackbar;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        injectPresenter();
    }

    private void injectPresenter() {
        ActivityComponent component = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .applicationComponent(((App)getApplication()).getApplicationComponent())
                .build();
        component.inject(this);
        mPresenter.setView(this);
    }

    public static Intent getCallingIntent(Context context) {
        return new Intent(context, LoginActivity.class);
    }

    @OnClick(R.id.btnSignUp)
    void onSignUpClicked() {
        navigator.navigateToLogin(this);
        finish();
    }


    @OnClick(R.id.btnLogin)
    void onLoginClicked() {
        loadData();
    }



    @Override
    public void loadData() {
        mPresenter.doLogin(email.getText().toString(), password.getText().toString());
    }

    @Override
    public void showRetry(String message) {
        snackbar = Snackbar
                .make(container, message, Snackbar.LENGTH_LONG)
                .setAction("RETRY", view -> loadData());
        snackbar.show();
    }

    @Override
    public void hideRetry() {
        if (snackbar != null) {
            snackbar.dismiss();
        }
    }

    @Override
    public void showUserNameError(String error) {
        email.setError(error);
    }

    @Override
    public void showPasswordError(String error) {
        password.setError(error);
    }

    @Override
    public void navigateToHome() {
        navigator.navigateToHome(this);
    }

    @Override
    public void navigateToTerms() {
        navigator.navigateToLogin(this);
    }

}
