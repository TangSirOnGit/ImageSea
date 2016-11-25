package com.tang.imagesea.model;

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
}
