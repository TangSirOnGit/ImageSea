package com.tang.imagesea.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by tangsir on 2016/11/24.
 */
public class ProfileImageBean implements Parcelable {
    /**
     * small : https://images.unsplash.com/profile-1470371865055-c78771230b0d?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=32&w=32&s=3c383ade986fbb12f46457dd65eedeb2
     * medium : https://images.unsplash.com/profile-1470371865055-c78771230b0d?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=64&w=64&s=4a7d4201df25be32b8e00e89d89a303b
     * large : https://images.unsplash.com/profile-1470371865055-c78771230b0d?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=128&w=128&s=21b521dd1b708586466349621a7912bd
     */
    private String small;
    private String medium;
    private String large;

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.small);
        dest.writeString(this.medium);
        dest.writeString(this.large);
    }

    public ProfileImageBean() {
    }

    protected ProfileImageBean(Parcel in) {
        this.small = in.readString();
        this.medium = in.readString();
        this.large = in.readString();
    }

    public static final Parcelable.Creator<ProfileImageBean> CREATOR = new Parcelable.Creator<ProfileImageBean>() {
        @Override
        public ProfileImageBean createFromParcel(Parcel source) {
            return new ProfileImageBean(source);
        }

        @Override
        public ProfileImageBean[] newArray(int size) {
            return new ProfileImageBean[size];
        }
    };
}
