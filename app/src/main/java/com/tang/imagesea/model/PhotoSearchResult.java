package com.tang.imagesea.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by tangsir on 2016/11/24.
 */

public class PhotoSearchResult implements Parcelable {

    private int total;
    private int total_pages;

    private List<PhotoBean> results;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public List<PhotoBean> getResults() {
        return results;
    }

    public void setResults(List<PhotoBean> results) {
        this.results = results;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.total);
        dest.writeInt(this.total_pages);
        dest.writeTypedList(this.results);
    }

    public PhotoSearchResult() {
    }

    protected PhotoSearchResult(Parcel in) {
        this.total = in.readInt();
        this.total_pages = in.readInt();
        this.results = in.createTypedArrayList(PhotoBean.CREATOR);
    }

    public static final Parcelable.Creator<PhotoSearchResult> CREATOR = new Parcelable.Creator<PhotoSearchResult>() {
        @Override
        public PhotoSearchResult createFromParcel(Parcel source) {
            return new PhotoSearchResult(source);
        }

        @Override
        public PhotoSearchResult[] newArray(int size) {
            return new PhotoSearchResult[size];
        }
    };
}
