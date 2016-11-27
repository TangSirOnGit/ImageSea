package com.tang.imagesea.network;

import android.content.Context;

import com.tang.imagesea.utils.AuthorizationUtils;

import java.io.File;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by tangsir on 2016/11/26.
 */
public class UnSplash {
    private static UnSplash ourInstance = new UnSplash();

    public static UnSplash getInstance() {
        return ourInstance;
    }

    private Context context;
    Interceptor REWRITE_CACHE_CONTROL_INTERCEPTOR = null;

    private UnSplash() {
    }

    public void init(Context context){
        this.context = context;
        REWRITE_CACHE_CONTROL_INTERCEPTOR = new HttpCacheInterceptor(context);
    }

    private UnSplashServices splashApiInterface;

    public UnSplashServices getServer() {
        File httpCacheDirectory = new File(context.getCacheDir(), "responses");
        int cacheSize = 10 * 1024 * 1024; // 10 MiB
        Cache cache = new Cache(httpCacheDirectory, cacheSize);
        OkHttpClient client = new OkHttpClient.Builder()
                .addNetworkInterceptor(REWRITE_CACHE_CONTROL_INTERCEPTOR)
                .cache(cache).build();

        if (splashApiInterface == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(AuthorizationUtils.UnSplashURI)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            splashApiInterface = retrofit.create(UnSplashServices.class);
        }
        return splashApiInterface;
    }
}
