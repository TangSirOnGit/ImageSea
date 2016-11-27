package com.tang.imagesea.network;

import com.tang.imagesea.BuildConfig;
import com.tang.imagesea.model.PhotoBean;
import com.tang.imagesea.model.PhotoDetailBean;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by tangsir on 2016/11/24.
 */

public interface UnSplashServices {
    @Headers({BuildConfig.API_KEY, "Cache-Control: public, max-age=3600"})
    @GET("/photos")
    Call<List<PhotoBean>> getPhotos(
            @Query("page") int page,
            @Query("per_page") int pageSize,
            @Query("order_by") String orderBy);

    @GET("/photos/{id}")
    @Headers(BuildConfig.API_KEY)
    Call<PhotoDetailBean> getPhotoDetail(
            @Path("id") String id);
}
