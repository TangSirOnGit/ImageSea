package com.tang.imagesea.manager;

import android.support.v4.util.LruCache;

import com.tang.imagesea.model.PhotoBean;

import java.util.List;

/**
 * Created by tangsir on 2016/12/9.
 */
public class DataCacheUtils {
    private static DataCacheUtils ourInstance = new DataCacheUtils();

    public static DataCacheUtils getInstance() {
        return ourInstance;
    }

    private final int PHOTO_CACHE_SIZE = 30;
    private final String KEY_STRING_CONNECTOR = "_";
    private LruCache<String, List<PhotoBean>> mPhotosDataCache = null;

    private DataCacheUtils() {
        mPhotosDataCache = new LruCache<>(
                PHOTO_CACHE_SIZE);
    }

    public void addPhotosToCache(String photoTYpe, int pageIndex,
                                       int pageSize, List<PhotoBean> value) {

        mPhotosDataCache.put(photoTYpe + KEY_STRING_CONNECTOR + pageIndex
                + KEY_STRING_CONNECTOR + pageSize, value);
    }

    public List<PhotoBean> getPhotosFromCache(String photoType, int pageIndex,
                                           int pageSize) {
        return mPhotosDataCache.get(photoType + KEY_STRING_CONNECTOR
                + pageIndex + KEY_STRING_CONNECTOR + pageSize);
    }
}
