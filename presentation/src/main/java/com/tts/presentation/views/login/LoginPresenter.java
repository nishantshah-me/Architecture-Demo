package com.tts.presentation.views.login;

import android.content.Context;


import com.tts.domain.Session;
import com.tts.domain.interactor.CreateSessionUseCase;
import com.tts.domain.interactor.DefaultObserver;
import com.tts.presentation.exception.ErrorMessageFactory;
import com.tts.presentation.di.PerActivity;
import com.tts.presentation.mapper.ModelDataMapper;
import com.tts.presentation.util.ValidationUtil;
import com.tts.user.arch.R;

import javax.inject.Inject;

/**
 * Created by webwerks1 on 11/7/17.
 */
@PerActivity
public class LoginPresenter implements LoginContract.Presenter {

    private final CreateSessionUseCase createSessionUseCase;
    private final ModelDataMapper modelDataMapper;

    private LoginContract.View mView;

    @Inject
    public LoginPresenter(CreateSessionUseCase createSessionUseCase, ModelDataMapper modelDataMapper) {
        this.createSessionUseCase = createSessionUseCase;
        this.modelDataMapper = modelDataMapper;
    }


    @Override
    public void start() {

    }

    @Override
    public void destroy() {
        //Prevent memory leaks.
        mView = null;
        //You must dispose rx.
        createSessionUseCase.dispose();
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
        createSessionUseCase.execute(new UserDetailsObserver(), CreateSessionUseCase.Params.forUser(email,password));
    }

    public void setView(LoginContract.View view) {
        mView=view;
    }

    private final class UserDetailsObserver extends DefaultObserver<Session> {

        @Override public void onComplete() {
            mView.hideLoading();
        }

        @Override public void onError(Throwable e) {
           super.onError(e);
           mView.hideLoading();
           mView.showErrorMessage(ErrorMessageFactory.create((Context) mView,e));
           mView.showRetry("Retry");
        }

        @Override public void onNext(Session user) {
           mView.navigateToHome();
        }
    }

}
