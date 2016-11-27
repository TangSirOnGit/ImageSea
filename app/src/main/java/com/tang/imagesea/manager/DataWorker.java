package com.tang.imagesea.manager;

import com.tang.imagesea.model.PhotoBean;
import com.tang.imagesea.model.PhotoDetailBean;
import com.tang.imagesea.network.UnSplash;
import com.tang.imagesea.utils.LogUtils;

import java.util.List;

import retrofit2.Call;

/**
 * Created by tangsir on 2016/11/24.
 */

public class DataWorker {
    static List<PhotoBean> getPhotos(int page, int pageSize, String orderBy){
        LogUtils.showLog("enter DataWorker, getPhotos,page="+page);
        Call<List<PhotoBean>> photosCall =
                UnSplash.getInstance().getServer().getPhotos(page, pageSize, orderBy);
        List<PhotoBean> photos = null;
        try{
            photos = photosCall.execute().body();
        }catch (Exception e){
            e.printStackTrace();
        }
        LogUtils.showLog("DataWorker, getPhotos,page="+page+",photos="+photos);
        return photos;
    }

    public static PhotoDetailBean getPhotoDetail(String id){
        Call<PhotoDetailBean> detailCall = UnSplash.getInstance().getServer().getPhotoDetail(id);
        PhotoDetailBean detail = null;
        try {
            detail = detailCall.execute().body();
        }catch (Exception e){

        }

        return detail;
    }
}
