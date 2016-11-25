package com.tang.imagesea.manager;

import com.tang.imagesea.model.PhotoBean;
import com.tang.imagesea.model.PhotoDetailBean;

import java.util.List;

/**
 * Created by tangsir on 2016/11/24.
 */

public class DataManager {

    public static List<PhotoBean> getPhotos(int page, int pageSize, String orderBy){
        return DataWorker.getPhotos(page, pageSize, orderBy);
    }

    public static PhotoDetailBean getPhotoDetail(String id){
        return  DataWorker.getPhotoDetail(id);
    }
}
