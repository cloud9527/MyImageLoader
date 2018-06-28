package com.example.imageloader;

public interface ILoaderStrategy {
    void loadImage(LoaderOptions options);

    void clearMemoryCache();

    void clearDiskCache();
}
