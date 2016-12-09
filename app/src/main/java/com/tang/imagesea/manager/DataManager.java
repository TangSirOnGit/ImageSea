package com.tang.imagesea.manager;

import com.tang.imagesea.model.PhotoBean;
import com.tang.imagesea.model.PhotoDetailBean;

import java.util.List;

/**
 * Created by tangsir on 2016/11/24.
 */

public class DataManager {

    public static List<PhotoBean> getPhotos(int page, int pageSize, String photoType, String orderBy){
        List<PhotoBean> photos =
                DataCacheUtils.getInstance().getPhotosFromCache(photoType, orderBy, page, pageSize);
        if (photos==null){
            return DataWorker.getPhotos(page, pageSize, photoType,orderBy);
        }else{
            return photos;
        }

    }

    public static void preLoadPhotos(int page, int pageSize, String photoType,String orderBy){
        List<PhotoBean> photos =
                DataCacheUtils.getInstance().getPhotosFromCache(photoType, orderBy,page, pageSize);
        if (photos==null){
            DataWorker.getPhotos(page, pageSize, photoType, orderBy);
        }
    }

    public static PhotoDetailBean getPhotoDetail(String id){
        return  DataWorker.getPhotoDetail(id);
    }
}
