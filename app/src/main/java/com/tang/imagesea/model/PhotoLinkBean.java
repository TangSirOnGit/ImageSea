package com.tang.imagesea.model;

/**
 * Created by tangsir on 2016/11/24.
 */

public class PhotoLinkBean extends BaseLink{
    /**
     * self : https://api.unsplash.com/photos/IQgciTJYSo8
     * html : http://unsplash.com/photos/IQgciTJYSo8
     * download : http://unsplash.com/photos/IQgciTJYSo8/download
     * download_location : https://api.unsplash.com/photos/IQgciTJYSo8/download
     */
    private String download;
    private String download_location;

    public String getDownload() {
        return download;
    }

    public void setDownload(String download) {
        this.download = download;
    }

    public String getDownload_location() {
        return download_location;
    }

    public void setDownload_location(String download_location) {
        this.download_location = download_location;
    }
}
