package com.tts.presentation.util;

import android.text.TextUtils;

/**
 * Created by user on 03-Aug-17.
 */

public class ValidationUtil {

    private ValidationUtil(){
        //Object not required.
    }

    public static boolean invalidEmail(String value){
        return invalidValue(value) || !android.util.Patterns.EMAIL_ADDRESS.matcher(value).matches();
    }
    public static boolean invalidUsername(String value){
        return invalidValue(value);
    }
    public static boolean invalidPassword(String value){
        return invalidValue(value);
    }

    public static boolean invalidValue(String value){
        return TextUtils.isEmpty(value);
    }
}
