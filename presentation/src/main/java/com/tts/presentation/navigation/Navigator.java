package com.tts.presentation.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.tts.presentation.views.login.LoginActivity;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Nishant Shah on 13/7/17.
 * Class used to navigate through the application and holds required data.
 */


@Singleton
public class Navigator {

    @Inject
    public Navigator() {
    }

    public void navigateToLogin(Context context) {
        if (context != null) {
            Intent intent = LoginActivity.getCallingIntent(context);
            context.startActivity(intent);
        }
    }

    public void navigateToHome(Context context) {
        //TODO navigate to home.
    }


}
