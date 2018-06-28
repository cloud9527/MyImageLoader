package com.example.imageloader;

import android.net.Uri;

import java.io.File;

public class ImageLoader {
    private ILoaderStrategy mILoaderStrategy;

    private ImageLoader() {
    }

    private static class ImageLoaderHolder {
        private static final ImageLoader INSTANCE = new ImageLoader();
    }

    public static ImageLoader getInstance() {
        return ImageLoaderHolder.INSTANCE;
    }
    //提供实时替换图片加载框架的接口
    public void setImageLoader(ILoaderStrategy loader) {
        if (loader != null) {
            mILoaderStrategy = loader;
        }
    }
    public void setILoaderStrategy(ILoaderStrategy loaderStrategy) {
        if (loaderStrategy != null) {
            mILoaderStrategy = loaderStrategy;
        }
    }


    public LoaderOptions load(String path) {
        return new LoaderOptions(path);
    }

    public LoaderOptions load(int drawable) {
        return new LoaderOptions(drawable);
    }

    public LoaderOptions load(File file) {
        return new LoaderOptions(file);
    }

    public LoaderOptions load(Uri uri) {
        return new LoaderOptions(uri);
    }


    public void loadOptions(LoaderOptions options) {
        mILoaderStrategy.loadImage(options);
    }

    public void clearMemoryCache() {
        mILoaderStrategy.clearMemoryCache();
    }

    public void clearDiskCache() {
        mILoaderStrategy.clearDiskCache();
    }
}
