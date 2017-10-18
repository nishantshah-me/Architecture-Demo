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

import com.tts.presentation.views.BaseActivity;
import com.tts.user.arch.R;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

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
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_login;
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
    protected LoginPresenter getPresenter() {
        return new LoginPresenter(this);
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

    }

    @Override
    public void navigateToTerms() {
        navigator.navigateToLogin(this);
    }

}
