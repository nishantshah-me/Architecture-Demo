package com.tts.presentation.views.login;

import android.content.Context;


import com.tts.data.entity.CustomerEntity;
import com.tts.data.repository.CustomerDataRepository;
import com.tts.data.repository.datasource.CloudDataSource;
import com.tts.domain.Customer;
import com.tts.domain.interactor.DefaultConsumer;
import com.tts.domain.interactor.DefaultObserver;
import com.tts.domain.interactor.LoginUseCase;
import com.tts.presentation.App;
import com.tts.presentation.exception.ErrorMessageFactory;
import com.tts.presentation.mapper.ModelDataMapper;
import com.tts.presentation.util.ValidationUtil;
import com.tts.user.arch.R;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;

/**
 * Created by webwerks1 on 11/7/17.
 */

public class LoginPresenter implements LoginContract.Presenter {

    LoginUseCase useCase;
    ModelDataMapper modelDataMapper;
    @Inject
    CloudDataSource cloudDataSource;

    private Disposable networkCall;
    private LoginContract.View mView;

    <T extends Context & LoginContract.View> LoginPresenter(T mView) {
        this.mView = mView;
        ((App) mView.getApplicationContext()).getNetworkComponent().inject(this);
        useCase=new LoginUseCase(new CustomerDataRepository(cloudDataSource));
    }

    @Override
    public void start() {

    }

    @Override
    public void destroy() {
        //Prevent memory leaks.
        mView = null;
        //Stop observing as view no longer exist.
        if (networkCall != null) {
            networkCall.dispose();
        }
    }

    @Override
    public void doLogin(String email, String password) {
        if (ValidationUtil.invalidUsername(email)) {
            mView.showUserNameError(mView.context().getString(R.string.error_message_username));
            return;
        }
        if (ValidationUtil.invalidPassword(password)) {
            mView.showPasswordError(mView.context().getString(R.string.error_message_password));
            return;
        }

        mView.showLoading();
        useCase.execute(new UserDetailsObserver(), LoginUseCase.Params.forUser(email,password));
    }

    private final class UserDetailsObserver extends DefaultObserver<Customer> {

        @Override public void onComplete() {
            mView.hideLoading();
        }

        @Override public void onError(Throwable e) {
           mView.hideLoading();
           mView.showErrorMessage(ErrorMessageFactory.create((Context) mView,e));
           mView.showRetry("Retry");
        }

        @Override public void onNext(Customer user) {
           mView.navigateToHome();
        }
    }

}
