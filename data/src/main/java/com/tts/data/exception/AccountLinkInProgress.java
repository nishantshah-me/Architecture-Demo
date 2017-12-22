package com.tts.data.exception;

/**
 * Created by Nishant on 04-Dec-17.
 */

public class AccountLinkInProgress extends Exception {

    private static final String message = "Account link in progress";

    public AccountLinkInProgress() {
        super(AccountLinkInProgress.message);
    }
}
