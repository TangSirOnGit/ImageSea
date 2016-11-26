package com.tang.imagesea.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by tangsir on 2016/11/24.
 */

public class PhotoLinkBean extends BaseLink implements Parcelable {
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.download);
        dest.writeString(this.download_location);
    }

    public PhotoLinkBean() {
    }

    protected PhotoLinkBean(Parcel in) {
        this.download = in.readString();
        this.download_location = in.readString();
    }

    public static final Parcelable.Creator<PhotoLinkBean> CREATOR = new Parcelable.Creator<PhotoLinkBean>() {
        @Override
        public PhotoLinkBean createFromParcel(Parcel source) {
            return new PhotoLinkBean(source);
        }

        @Override
        public PhotoLinkBean[] newArray(int size) {
            return new PhotoLinkBean[size];
        }
    };
}
