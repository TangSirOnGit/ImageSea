package com.tang.imagesea;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.tang.imagesea.network.UnSplash;
import com.tang.imagesea.utils.LogUtils;

/**
 * Created by tangsir on 2016/11/28.
 */

public class ImageSeaApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        LogUtils.init();
        UnSplash.getInstance().init(this);
        Fresco.initialize(this);
    }
}