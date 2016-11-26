package com.tang.imagesea.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by tangsir on 2016/11/24.
 */
public class CategoryLinkBean implements Parcelable {
    private String self;
    private String photos;

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.self);
        dest.writeString(this.photos);
    }

    public CategoryLinkBean() {
    }

    protected CategoryLinkBean(Parcel in) {
        this.self = in.readString();
        this.photos = in.readString();
    }

    public static final Parcelable.Creator<CategoryLinkBean> CREATOR = new Parcelable.Creator<CategoryLinkBean>() {
        @Override
        public CategoryLinkBean createFromParcel(Parcel source) {
            return new CategoryLinkBean(source);
        }

        @Override
        public CategoryLinkBean[] newArray(int size) {
            return new CategoryLinkBean[size];
        }
    };
}
