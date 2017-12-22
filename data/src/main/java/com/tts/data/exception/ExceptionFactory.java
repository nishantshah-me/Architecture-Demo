package com.tts.data.exception;

/**
 * Created by Nishant on 16-Nov-17.
 */

public class ExceptionFactory {

    public static Exception create(int code) {
        switch (code) {
            case 401:
                return new UnauthorizedException();
            case 422:
                return new UserNotFoundException();
            case 417:
                return new AccountLinkInProgress();
            default:
                return new UnknowException();

        }
    }
}
