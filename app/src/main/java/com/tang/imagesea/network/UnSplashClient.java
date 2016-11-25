package com.tang.imagesea.network;

import com.tang.imagesea.utils.AuthorizationUtils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by tangsir on 2016/11/24.
 */

public class UnSplashClient {
    private static UnSplashServices splashApiInterface;

    public static UnSplashServices getServer() {
        if (splashApiInterface == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(AuthorizationUtils.UnSplashURI)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            splashApiInterface = retrofit.create(UnSplashServices.class);
        }
        return splashApiInterface;
    }
}
