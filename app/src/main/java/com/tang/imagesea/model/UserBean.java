package com.tang.imagesea.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by tangsir on 2016/11/24.
 */
public class UserBean implements Parcelable {
    /**
     * id : pxPwOOjqegI
     * username : shubhankars19
     * name : Shubhankar Sharma
     * first_name : Shubhankar
     * last_name : Sharma
     * portfolio_url : http://500px.com/shubhankars19
     * bio : Hobbyist photographer.
     * location : Singapore
     * total_likes : 6
     * total_photos : 22
     * total_collections : 0
     * profile_image : {"small":"https://images.unsplash.com/profile-1470371865055-c78771230b0d?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=32&w=32&s=3c383ade986fbb12f46457dd65eedeb2","medium":"https://images.unsplash.com/profile-1470371865055-c78771230b0d?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=64&w=64&s=4a7d4201df25be32b8e00e89d89a303b","large":"https://images.unsplash.com/profile-1470371865055-c78771230b0d?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=128&w=128&s=21b521dd1b708586466349621a7912bd"}
     * links : {"self":"https://api.unsplash.com/users/shubhankars19","html":"http://unsplash.com/@shubhankars19","photos":"https://api.unsplash.com/users/shubhankars19/photos","likes":"https://api.unsplash.com/users/shubhankars19/likes","portfolio":"https://api.unsplash.com/users/shubhankars19/portfolio","following":"https://api.unsplash.com/users/shubhankars19/following","followers":"https://api.unsplash.com/users/shubhankars19/followers"}
     */
    private String id;
    private String username;
    private String name;
    private String first_name;
    private String last_name;
    private String portfolio_url;
    private String bio;
    private String location;
    private int total_likes;
    private int total_photos;
    private int total_collections;


    private ProfileImageBean profile_image;


    private UserLinkBean links;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPortfolio_url() {
        return portfolio_url;
    }

    public void setPortfolio_url(String portfolio_url) {
        this.portfolio_url = portfolio_url;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getTotal_likes() {
        return total_likes;
    }

    public void setTotal_likes(int total_likes) {
        this.total_likes = total_likes;
    }

    public int getTotal_photos() {
        return total_photos;
    }

    public void setTotal_photos(int total_photos) {
        this.total_photos = total_photos;
    }

    public int getTotal_collections() {
        return total_collections;
    }

    public void setTotal_collections(int total_collections) {
        this.total_collections = total_collections;
    }

    public ProfileImageBean getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(ProfileImageBean profile_image) {
        this.profile_image = profile_image;
    }

    public UserLinkBean getLinks() {
        return links;
    }

    public void setLinks(UserLinkBean links) {
        this.links = links;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.username);
        dest.writeString(this.name);
        dest.writeString(this.first_name);
        dest.writeString(this.last_name);
        dest.writeString(this.portfolio_url);
        dest.writeString(this.bio);
        dest.writeString(this.location);
        dest.writeInt(this.total_likes);
        dest.writeInt(this.total_photos);
        dest.writeInt(this.total_collections);
        dest.writeParcelable(this.profile_image, flags);
        dest.writeParcelable(this.links, flags);
    }

    public UserBean() {
    }

    protected UserBean(Parcel in) {
        this.id = in.readString();
        this.username = in.readString();
        this.name = in.readString();
        this.first_name = in.readString();
        this.last_name = in.readString();
        this.portfolio_url = in.readString();
        this.bio = in.readString();
        this.location = in.readString();
        this.total_likes = in.readInt();
        this.total_photos = in.readInt();
        this.total_collections = in.readInt();
        this.profile_image = in.readParcelable(ProfileImageBean.class.getClassLoader());
        this.links = in.readParcelable(UserLinkBean.class.getClassLoader());
    }

    public static final Parcelable.Creator<UserBean> CREATOR = new Parcelable.Creator<UserBean>() {
        @Override
        public UserBean createFromParcel(Parcel source) {
            return new UserBean(source);
        }

        @Override
        public UserBean[] newArray(int size) {
            return new UserBean[size];
        }
    };
}
