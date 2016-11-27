package com.tang.imagesea.network;

import android.content.Context;

import com.tang.imagesea.utils.LogUtils;
import com.tang.imagesea.utils.NetWorkUtils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by tangsir on 2016/11/27.
 */

public class HttpCacheInterceptor implements Interceptor {
    private Context mContext;
    public HttpCacheInterceptor(Context context){
        mContext = context;
    }
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        Response originalResponse = chain.proceed(request);
        if (NetWorkUtils.isNetworkConnected(mContext)) {
            int maxAge = 1;
            LogUtils.showLog("intercept, netWorkConnected");
            return originalResponse.newBuilder()
                    .header("Cache-Control", "public, max-age=" + maxAge)
                    .removeHeader("Pragma")     // 清除头信息
                    .build();
        } else {
            LogUtils.showLog("intercept, netWork not Connected");
            int maxStale = 60 * 60 * 24;
            return originalResponse.newBuilder()
                    .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                    .removeHeader("Pragma")
                    .build();
        }
    }
}
