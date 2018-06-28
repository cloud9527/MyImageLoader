package com.example.imageloader;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.DrawableRes;
import android.support.v4.app.Fragment;
import android.view.View;

import java.io.File;

/**
 * 图片框架的配置信息
 */
public class LoaderOptions {
    /**
     * 加载4种不同的图片来源 公共使用
     */
    public String url;
    public File file;
    public int drawableResId;
    public Uri uri;

    /**
     * targetView展示图片 公共使用
     */
    public View targetView;

    /**
     * 预加载占位图和图片加载错误占位图，分别是int 和drawable 两种
     */
    public int placeholderResId;
    public int errorResId;
    public Drawable placeholderDrawable;
    public Drawable errorDrawable;



    public boolean isCenterCrop;
    public boolean isCenterInside;
    /**
     * 是否缓存到本地
     */
    public boolean skipLocalCache;
    public boolean skipNetCache;

    public Bitmap.Config mConfig = Bitmap.Config.RGB_565;
    public int targetWidth;
    public int targetHeight;
    //圆角角度
    public float bitmapAngle;
    /**
     * 旋转角度.注意:picasso针对三星等本地图片，默认旋转回0度，即正常位置。此时不需要自己rotate
     */
    public float degrees;

    public BitmapCallBack callBack;



    public Activity mActivity;
    public Fragment mFragment;
    public Context mContext;
    /**
     * Glide 默认加载动画  默认是true 加载动画的
     */
    public boolean loadingAnimate = true;

    public LoaderOptions(String url) {
        this.url = url;
    }

    public LoaderOptions(File file) {
        this.file = file;
    }

    public LoaderOptions(int drawableResId) {
        this.drawableResId = drawableResId;
    }

    public LoaderOptions(Uri uri) {
        this.uri = uri;
    }

    public void into(View targetView) {
        this.targetView = targetView;
        ImageLoader.getInstance().loadOptions(this);
    }

    public void bitmap(BitmapCallBack callBack) {
        this.callBack = callBack;
        ImageLoader.getInstance().loadOptions(this);
    }

    public LoaderOptions placeholder(@DrawableRes int placeholderResId) {
        this.placeholderResId = placeholderResId;
        return this;
    }

    public LoaderOptions placeholder(Drawable placeholder) {
        this.placeholderDrawable = placeholder;
        return this;
    }

    public LoaderOptions error(@DrawableRes int errorResId) {
        this.errorResId = errorResId;
        return this;
    }

    public LoaderOptions centerCrop() {
        isCenterCrop = true;
        return this;
    }

    public LoaderOptions centerInside() {
        isCenterInside = true;
        return this;
    }

    public LoaderOptions config(Bitmap.Config config) {
        this.mConfig = config;
        return this;
    }

    public LoaderOptions resize(int targetWidth, int targetHeight) {
        this.targetWidth = targetWidth;
        this.targetHeight = targetHeight;
        return this;
    }

    /**
     * 圆角
     *
     * @param bitmapAngle 度数
     * @return
     */
    public LoaderOptions angle(float bitmapAngle) {
        this.bitmapAngle = bitmapAngle;
        return this;
    }

    public LoaderOptions skipLocalCache(boolean skipLocalCache) {
        this.skipLocalCache = skipLocalCache;
        return this;
    }

    public LoaderOptions skipNetCache(boolean skipNetCache) {
        this.skipNetCache = skipNetCache;
        return this;
    }

    public LoaderOptions rotate(float degrees) {
        this.degrees = degrees;
        return this;
    }

    public LoaderOptions isLoadingAnimate(boolean loadingAnimate) {
        this.loadingAnimate = loadingAnimate;
        return this;
    }

    public LoaderOptions with(Activity activity) {
        this.mActivity = activity;
        return this;
    }

    public LoaderOptions with(Fragment fragment) {
        this.mFragment = fragment;
        return this;
    }

    public LoaderOptions with(Context context) {
        this.mContext = context;
        return this;
    }


}
