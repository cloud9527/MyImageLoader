package com.example.imageloader;

import android.graphics.Bitmap;

public interface BitmapCallBack {
    void onBitmapLoaded(Bitmap bitmap);

    void onBitmapFailed(Exception e);
}
