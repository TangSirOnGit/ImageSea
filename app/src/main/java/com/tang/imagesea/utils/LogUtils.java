package com.tang.imagesea.utils;

import org.mym.plog.PLog;
import org.mym.plog.config.PLogConfig;

/**
 * Created by tangsir on 2016/11/24.
 */

public class LogUtils {
    private static boolean showLog = true;
    private static final String TAG = "ImageSea";
    public static void init(){
        PLogConfig config = new PLogConfig.Builder()
                .globalTag(TAG)
                .build();
        PLog.init(config);
    }
    public static void showLog(String msg){
        if (showLog) {
            PLog.v(msg);
        }
    }

    public static void showLog(){
        if (showLog) {
            PLog.empty();
        }
    }

    public static void debug(String msg){
//        PLog.d("DebugTag", "This is a debug log.");
//        PLog.e("This is an error log.");
    }
}
