package com.tts.presentation.views.login;


import com.tts.presentation.presenter.BasePresenter;
import com.tts.presentation.views.BaseView;
import com.tts.presentation.views.LoadDataView;

import java.util.List;

/**
 * Created by webwerks1 on 11/7/17.
 */

public interface LoginContract {
    interface View extends BaseView,LoadDataView {
        void showUserNameError(String error);
        void showPasswordError(String error);
        void navigateToHome();
        void navigateToTerms();
    }
    interface Presenter extends BasePresenter {
        void doLogin(String email, String password);
    }
}
