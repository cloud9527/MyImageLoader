package com.example.wangjing.myimageloader;

import android.app.Application;

import com.example.imageloader.ImageLoader;


/**
 * Created by JohnsonFan on 2017/12/9.
 */

public class App extends Application {

	public static App gApp;

	@Override
	public void onCreate() {
		super.onCreate();
		gApp = this;
		//初始化图片库
		ImageLoader.getInstance().setImageLoader(new GildeLoader());
	}
}
