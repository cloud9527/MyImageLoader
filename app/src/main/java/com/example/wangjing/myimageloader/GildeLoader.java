package com.example.wangjing.myimageloader;

import android.widget.ImageView;

import com.bumptech.glide.DrawableTypeRequest;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.example.imageloader.ILoaderStrategy;
import com.example.imageloader.LoaderOptions;

public class GildeLoader implements ILoaderStrategy {

    @Override
    public void loadImage(LoaderOptions options) {

        RequestManager requestManager = null;
        if (options.mActivity != null) {
            requestManager = Glide.with(options.mActivity);
        } else if (options.mFragment != null) {
            requestManager = Glide.with(options.mFragment);
        } else if (options.mContext != null) {
            requestManager = Glide.with(options.mContext);
        }
        if (requestManager == null) {
            throw new NullPointerException("requestManager can not be null");
        }
        DrawableTypeRequest drawableTypeRequest = null;
        if (options.url != null) {
            drawableTypeRequest = requestManager.load(options.url);
        } else if (options.file != null) {
            drawableTypeRequest = requestManager.load(options.file);
        } else if (options.drawableResId != 0) {
            drawableTypeRequest = requestManager.load(options.drawableResId);
        } else if (options.uri != null) {
            drawableTypeRequest = requestManager.load(options.uri);

        }
        if (drawableTypeRequest == null) {
            throw new NullPointerException("drawableTypeRequest can not be null");
        }
        if (!options.loadingAnimate) {
            drawableTypeRequest.dontAnimate();
        }

        if (options.placeholderDrawable != null) {
            drawableTypeRequest.placeholder(options.placeholderDrawable);
        } else if (options.placeholderResId != 0) {
            drawableTypeRequest.placeholder(options.placeholderResId);
        }

        if (options.errorDrawable != null) {
            drawableTypeRequest.error(options.errorDrawable);
        } else if (options.errorResId != 0) {
            drawableTypeRequest.error(options.errorResId);
        }


        if (options.targetView instanceof ImageView) {
            drawableTypeRequest.into((ImageView) options.targetView);
        }
    }

    @Override
    public void clearMemoryCache() {

    }

    @Override
    public void clearDiskCache() {

    }
}
