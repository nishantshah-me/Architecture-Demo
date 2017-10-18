package com.tts.presentation.util;

/**
 * Created by webwerks1 on 16/8/17.
 */

public class EncyptUtil {
    public static String mummy(String str) {
        String hold = "jNUP4E9v9cCzqspKmj5nO1uqDYaouclZ";
        int s[] = new int[256];
        int j = 0;
        int x = 0;
        String res = "";
        for (int i = 0; i < 256; i++) {
            s[i] = i;
        }
        for (int i = 0; i < 256; i++) {
            j = (j + s[i] + hold.charAt(i % hold.length())) % 256;
            x = s[i];
            s[i] = s[j];
            s[j] = x;
        }
        int i = 0;
        j = 0;
        for (int y = 0; y < str.length(); y++) {
            i = (i + 1) % 256;
            j = (j + s[i]) % 256;
            x = s[i];
            s[i] = s[j];
            s[j] = x;
            res += (str.charAt(y) ^ s[(s[i] + s[j]) % 256]);
            res += "+";
        }
        return res;
    }
}
