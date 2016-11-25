package com.tang.imagesea.model;

import java.util.List;

/**
 * Created by tangsir on 2016/11/24.
 */

public class PhotoBean {

    /**
     * id : IQgciTJYSo8
     * created_at : 2015-08-28T12:48:44-04:00
     * width : 4264
     * height : 2822
     * color : #3E1F27
     * downloads : 2902
     * likes : 22
     * liked_by_user : false
     * exif : {"make":"Canon","model":"Canon EOS 1100D","exposure_time":"15","aperture":"8.918863","focal_length":"18","iso":100}
     * location : {"title":"Marina Barrage, Singapore","name":"Marina Barrage","city":null,"country":"Singapore","position":{"latitude":1.281332,"longitude":103.872557}}
     * current_user_collections : []
     * urls : {"raw":"https://images.unsplash.com/photo-1440780336166-b19530cff5ec","full":"https://images.unsplash.com/photo-1440780336166-b19530cff5ec?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&s=854db164d8ebdc6b00d3e16cebecaace","regular":"https://images.unsplash.com/photo-1440780336166-b19530cff5ec?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max&s=06ccbc27e1ac0d059980c1bddaa5ee35","small":"https://images.unsplash.com/photo-1440780336166-b19530cff5ec?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=400&fit=max&s=46c5c45798e176ee2c016728628f4e08","thumb":"https://images.unsplash.com/photo-1440780336166-b19530cff5ec?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=200&fit=max&s=de0717fbf6b974b3b62fe20162bf8b71"}
     * categories : [{"id":2,"title":"Buildings","photo_count":22904,"links":{"self":"https://api.unsplash.com/categories/2","photos":"https://api.unsplash.com/categories/2/photos"}}]
     * links : {"self":"https://api.unsplash.com/photos/IQgciTJYSo8","html":"http://unsplash.com/photos/IQgciTJYSo8","download":"http://unsplash.com/photos/IQgciTJYSo8/download","download_location":"https://api.unsplash.com/photos/IQgciTJYSo8/download"}
     * user : {"id":"pxPwOOjqegI","username":"shubhankars19","name":"Shubhankar Sharma","first_name":"Shubhankar","last_name":"Sharma","portfolio_url":"http://500px.com/shubhankars19","bio":"Hobbyist photographer. ","location":"Singapore","total_likes":6,"total_photos":22,"total_collections":0,"profile_image":{"small":"https://images.unsplash.com/profile-1470371865055-c78771230b0d?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=32&w=32&s=3c383ade986fbb12f46457dd65eedeb2","medium":"https://images.unsplash.com/profile-1470371865055-c78771230b0d?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=64&w=64&s=4a7d4201df25be32b8e00e89d89a303b","large":"https://images.unsplash.com/profile-1470371865055-c78771230b0d?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=128&w=128&s=21b521dd1b708586466349621a7912bd"},"links":{"self":"https://api.unsplash.com/users/shubhankars19","html":"http://unsplash.com/@shubhankars19","photos":"https://api.unsplash.com/users/shubhankars19/photos","likes":"https://api.unsplash.com/users/shubhankars19/likes","portfolio":"https://api.unsplash.com/users/shubhankars19/portfolio","following":"https://api.unsplash.com/users/shubhankars19/following","followers":"https://api.unsplash.com/users/shubhankars19/followers"}}
     */

    private String id;
    private String created_at;
    private int width;
    private int height;
    private String color;
    private int downloads;
    private int likes;
    private boolean liked_by_user;


    private PhotoUrlBean urls;


    private PhotoLinkBean links;

    private UserBean user;
    private List<CollectionBean> current_user_collections;
    /**
     * id : 2
     * title : Buildings
     * photo_count : 22904
     * links : {"self":"https://api.unsplash.com/categories/2","photos":"https://api.unsplash.com/categories/2/photos"}
     */

    private List<CategoryBean> categories;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getDownloads() {
        return downloads;
    }

    public void setDownloads(int downloads) {
        this.downloads = downloads;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public boolean isLiked_by_user() {
        return liked_by_user;
    }

    public void setLiked_by_user(boolean liked_by_user) {
        this.liked_by_user = liked_by_user;
    }

    public PhotoUrlBean getUrls() {
        return urls;
    }

    public void setUrls(PhotoUrlBean urls) {
        this.urls = urls;
    }

    public PhotoLinkBean getLinks() {
        return links;
    }

    public void setLinks(PhotoLinkBean links) {
        this.links = links;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public List<CollectionBean> getCurrent_user_collections() {
        return current_user_collections;
    }

    public void setCurrent_user_collections(List<CollectionBean> current_user_collections) {
        this.current_user_collections = current_user_collections;
    }

    public List<CategoryBean> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryBean> categories) {
        this.categories = categories;
    }

}
