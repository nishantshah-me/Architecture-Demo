package com.tts.presentation.views;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.Toast;


import com.tts.presentation.App;
import com.tts.presentation.exception.ErrorMessageFactory;
import com.tts.presentation.navigation.Navigator;
import com.tts.presentation.presenter.BasePresenter;
import com.tts.presentation.util.ImageUtil;
import com.tts.user.arch.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;


/**
 * Created by webwerks1 on 11/7/17.
 */

public class BaseActivity<T extends BasePresenter> extends AppCompatActivity implements BaseView {
    private static final String EXIT_ME = "exit_me";
    @Inject
    protected T mPresenter;

    protected FrameLayout container;
    protected Navigator navigator;
    Toolbar toolbar;
    private View progress;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initInjector();
    }

    private void initInjector() {
        navigator = ((App) getApplication()).getApplicationComponent().navigator();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                FragmentManager fm = getSupportFragmentManager();
                if (fm != null && fm.getBackStackEntryCount() > 0) {
                    fm.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                } else {
                    finish();
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(mPresenter!=null) {
            mPresenter.start();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mPresenter!=null) {
            mPresenter.destroy();
            mPresenter = null;
        }
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(R.layout.activity_base);
        container = findViewById(R.id.container);
        progress = findViewById(R.id.progressBar);
        container.addView(LayoutInflater.from(this).inflate(layoutResID, null));
        ButterKnife.bind(this);
    }

    @Override
    public void setBackground(int drawableId) {
        ImageUtil.loadImage(this, drawableId, container);
    }


    @Override
    public void showErrorMessage(String errorMessage) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {
        progress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progress.setVisibility(View.GONE);
    }

    @Override
    public void setTitle(CharSequence title) {
        toolbar.setTitle(title);
    }

    @Override
    public void setTitle(int titleId) {
        toolbar.setTitle(titleId);
    }

    public Toolbar getToolBar() {
        return toolbar;
    }

    @Override
    public Context context() {
        return this;
    }


}
