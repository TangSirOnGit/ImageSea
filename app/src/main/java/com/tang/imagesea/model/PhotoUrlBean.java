package com.tang.imagesea.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by tangsir on 2016/11/24.
 */
public class PhotoUrlBean implements Parcelable {
    /**
     * raw : https://images.unsplash.com/photo-1440780336166-b19530cff5ec
     * full : https://images.unsplash.com/photo-1440780336166-b19530cff5ec?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&s=854db164d8ebdc6b00d3e16cebecaace
     * regular : https://images.unsplash.com/photo-1440780336166-b19530cff5ec?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max&s=06ccbc27e1ac0d059980c1bddaa5ee35
     * small : https://images.unsplash.com/photo-1440780336166-b19530cff5ec?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=400&fit=max&s=46c5c45798e176ee2c016728628f4e08
     * thumb : https://images.unsplash.com/photo-1440780336166-b19530cff5ec?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=200&fit=max&s=de0717fbf6b974b3b62fe20162bf8b71
     */
    private String raw;
    private String full;
    private String regular;
    private String small;
    private String thumb;

    public String getRaw() {
        return raw;
    }

    public void setRaw(String raw) {
        this.raw = raw;
    }

    public String getFull() {
        return full;
    }

    public void setFull(String full) {
        this.full = full;
    }

    public String getRegular() {
        return regular;
    }

    public void setRegular(String regular) {
        this.regular = regular;
    }

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.raw);
        dest.writeString(this.full);
        dest.writeString(this.regular);
        dest.writeString(this.small);
        dest.writeString(this.thumb);
    }

    public PhotoUrlBean() {
    }

    protected PhotoUrlBean(Parcel in) {
        this.raw = in.readString();
        this.full = in.readString();
        this.regular = in.readString();
        this.small = in.readString();
        this.thumb = in.readString();
    }

    public static final Parcelable.Creator<PhotoUrlBean> CREATOR = new Parcelable.Creator<PhotoUrlBean>() {
        @Override
        public PhotoUrlBean createFromParcel(Parcel source) {
            return new PhotoUrlBean(source);
        }

        @Override
        public PhotoUrlBean[] newArray(int size) {
            return new PhotoUrlBean[size];
        }
    };
}
