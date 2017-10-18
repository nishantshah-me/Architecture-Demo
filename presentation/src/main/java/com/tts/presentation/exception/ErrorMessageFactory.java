package com.tts.presentation.exception;

import android.content.Context;

import com.tts.data.exception.NetworkConnectionException;
import com.tts.data.exception.UserNotFoundException;
import com.tts.user.arch.R;

/**
 * Created by user on 18-Oct-17.
 */

public class ErrorMessageFactory {

    public static String create(Context context, Throwable exception) {
        String message = context.getString(R.string.exception_message_generic);

        if (exception instanceof NetworkConnectionException) {
            message = context.getString(R.string.exception_message_no_connection);
        } else if (exception instanceof UserNotFoundException) {
            message = context.getString(R.string.exception_message_user_not_found);
        }

        return message;
    }
}
