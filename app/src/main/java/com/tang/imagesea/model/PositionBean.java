package com.tang.imagesea.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by tangsir on 2016/11/24.
 */
public class PositionBean implements Parcelable {
    /**
     * latitude : 1.281332 longitude : 103.872557
     */
    private double latitude;
    private double longitude;

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(this.latitude);
        dest.writeDouble(this.longitude);
    }

    public PositionBean() {
    }

    protected PositionBean(Parcel in) {
        this.latitude = in.readDouble();
        this.longitude = in.readDouble();
    }

    public static final Parcelable.Creator<PositionBean> CREATOR = new Parcelable.Creator<PositionBean>() {
        @Override
        public PositionBean createFromParcel(Parcel source) {
            return new PositionBean(source);
        }

        @Override
        public PositionBean[] newArray(int size) {
            return new PositionBean[size];
        }
    };
}
