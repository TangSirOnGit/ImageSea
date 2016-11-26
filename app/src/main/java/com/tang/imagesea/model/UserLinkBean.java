package com.tang.imagesea.model;

import android.os.Parcel;

/**
 * Created by tangsir on 2016/11/24.
 */
public class UserLinkBean extends BaseLink{
    /**
     * self : https://api.unsplash.com/users/shubhankars19
     * html : http://unsplash.com/@shubhankars19
     * photos : https://api.unsplash.com/users/shubhankars19/photos
     * likes : https://api.unsplash.com/users/shubhankars19/likes portfolio :
     * https://api.unsplash.com/users/shubhankars19/portfolio following :
     * https://api.unsplash.com/users/shubhankars19/following followers :
     * https://api.unsplash.com/users/shubhankars19/followers
     */
    private String photos;
    private String likes;
    private String portfolio;
    private String following;
    private String followers;

    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(String portfolio) {
        this.portfolio = portfolio;
    }

    public String getFollowing() {
        return following;
    }

    public void setFollowing(String following) {
        this.following = following;
    }

    public String getFollowers() {
        return followers;
    }

    public void setFollowers(String followers) {
        this.followers = followers;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(this.photos);
        dest.writeString(this.likes);
        dest.writeString(this.portfolio);
        dest.writeString(this.following);
        dest.writeString(this.followers);
    }

    public UserLinkBean() {
    }

    protected UserLinkBean(Parcel in) {
        super(in);
        this.photos = in.readString();
        this.likes = in.readString();
        this.portfolio = in.readString();
        this.following = in.readString();
        this.followers = in.readString();
    }

    public static final Creator<UserLinkBean> CREATOR = new Creator<UserLinkBean>() {
        @Override
        public UserLinkBean createFromParcel(Parcel source) {
            return new UserLinkBean(source);
        }

        @Override
        public UserLinkBean[] newArray(int size) {
            return new UserLinkBean[size];
        }
    };
}
