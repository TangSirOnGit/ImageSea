package com.tang.imagesea.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by tangsir on 2016/11/24.
 */
public class LocationBean implements Parcelable {
    /**
     * title : Marina Barrage, Singapore
     * name : Marina Barrage
     * city : null
     * country : Singapore
     * position : {"latitude":1.281332,"longitude":103.872557}
     */
    private String title;
    private String name;
    private String city;
    private String country;

    private PositionBean position;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public PositionBean getPosition() {
        return position;
    }

    public void setPosition(PositionBean position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "{" +
                "title='" + title + '\'' +
                ", name='" + name + '\'' +
                ", city=" + city +
                ", country='" + country + '\'' +
                ", position=" + position +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.name);
        dest.writeString(this.city);
        dest.writeString(this.country);
        dest.writeParcelable(this.position, flags);
    }

    public LocationBean() {
    }

    protected LocationBean(Parcel in) {
        this.title = in.readString();
        this.name = in.readString();
        this.city = in.readString();
        this.country = in.readString();
        this.position = in.readParcelable(PositionBean.class.getClassLoader());
    }

    public static final Creator<LocationBean> CREATOR = new Creator<LocationBean>() {
        @Override
        public LocationBean createFromParcel(Parcel source) {
            return new LocationBean(source);
        }

        @Override
        public LocationBean[] newArray(int size) {
            return new LocationBean[size];
        }
    };
}
