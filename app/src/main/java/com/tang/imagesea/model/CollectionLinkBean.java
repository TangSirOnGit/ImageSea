package com.tang.imagesea.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by tangsir on 2016/11/24.
 */
public class CollectionLinkBean implements Parcelable {
    private String self;
    private String html;
    private String photos;
    private String related;

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }

    public String getRelated() {
        return related;
    }

    public void setRelated(String related) {
        this.related = related;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.self);
        dest.writeString(this.html);
        dest.writeString(this.photos);
        dest.writeString(this.related);
    }

    public CollectionLinkBean() {
    }

    protected CollectionLinkBean(Parcel in) {
        this.self = in.readString();
        this.html = in.readString();
        this.photos = in.readString();
        this.related = in.readString();
    }

    public static final Parcelable.Creator<CollectionLinkBean> CREATOR = new Parcelable.Creator<CollectionLinkBean>() {
        @Override
        public CollectionLinkBean createFromParcel(Parcel source) {
            return new CollectionLinkBean(source);
        }

        @Override
        public CollectionLinkBean[] newArray(int size) {
            return new CollectionLinkBean[size];
        }
    };
}
