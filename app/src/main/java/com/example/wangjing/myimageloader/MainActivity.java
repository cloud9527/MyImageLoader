package com.example.wangjing.myimageloader;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.example.imageloader.ImageLoader;

/**
 * @author wangjing
 */
public class MainActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //使用方式
        ImageView imageView = findViewById(R.id.imageview);
        String url = "http://hgdxb.cuepa.cn/newspic/347775/s_eab67697df3adc3a6d1dac5ab0fcb160447922.jpg";
        ImageLoader.getInstance()
                .load(url)
                .with(this)
                .placeholder(R.drawable.test)
                .error(R.drawable.test)
                .into(imageView);

    }
}
