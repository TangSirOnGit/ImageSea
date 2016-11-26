package com.tang.imagesea.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by tangsir on 2016/11/24.
 */
public class CategoryBean implements Parcelable {
    private int id;
    private String title;
    private int photo_count;
    /**
     * self : https://api.unsplash.com/categories/2 photos : https://api.unsplash.com/categories/2/photos
     */

    private CategoryLinkBean links;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPhoto_count() {
        return photo_count;
    }

    public void setPhoto_count(int photo_count) {
        this.photo_count = photo_count;
    }

    public CategoryLinkBean getLinks() {
        return links;
    }

    public void setLinks(CategoryLinkBean links) {
        this.links = links;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.title);
        dest.writeInt(this.photo_count);
        dest.writeParcelable(this.links, flags);
    }

    public CategoryBean() {
    }

    protected CategoryBean(Parcel in) {
        this.id = in.readInt();
        this.title = in.readString();
        this.photo_count = in.readInt();
        this.links = in.readParcelable(CategoryLinkBean.class.getClassLoader());
    }

    public static final Parcelable.Creator<CategoryBean> CREATOR = new Parcelable.Creator<CategoryBean>() {
        @Override
        public CategoryBean createFromParcel(Parcel source) {
            return new CategoryBean(source);
        }

        @Override
        public CategoryBean[] newArray(int size) {
            return new CategoryBean[size];
        }
    };
}
