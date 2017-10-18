package com.tts.presentation.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;

/**
 * Created by webwerks1 on 17/7/17.
 */

public class ImageUtil {

    public static void loadImage(Context context, int drawableId, final View view){
        /*Glide.with(context).load(drawableId).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Bitmap resource) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    view.setBackground(resource);
                }else{
                    view.setBackgroundDrawable(resource);
                }
            }
        });*/
    }
}
