package com.tang.imagesea.manager;

import com.tang.imagesea.model.PhotoBean;
import com.tang.imagesea.model.PhotoDetailBean;

import java.util.List;

/**
 * Created by tangsir on 2016/11/24.
 */

public class DataManager {

    public static List<PhotoBean> getPhotos(int page, int pageSize, String photoType){
        List<PhotoBean> photos =
                DataCacheUtils.getInstance().getPhotosFromCache(photoType, page, pageSize);
        if (photos==null){
            return DataWorker.getPhotos(page, pageSize, photoType);
        }else{
            return photos;
        }

    }

    public static PhotoDetailBean getPhotoDetail(String id){
        return  DataWorker.getPhotoDetail(id);
    }
}
