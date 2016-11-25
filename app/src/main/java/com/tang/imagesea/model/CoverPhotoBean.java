package com.tang.imagesea.model;

import java.util.List;

/**
 * Created by tangsir on 2016/11/24.
 */
public class CoverPhotoBean {
    private String id;
    private String created_at;
    private int width;
    private int height;
    private String color;
    private int likes;
    private boolean liked_by_user;
    /**
     * id : e0DndGdXY0Y username : crfan89 name : Jeff Fan first_name : Jeff last_name : Fan
     * portfolio_url : null bio : location : null total_likes : 1 total_photos : 1
     * total_collections : 0 profile_image : {"small":"https://images.unsplash.com/profile-1479357663788-b91e1132b5db?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=32&w=32&s=e448ef119c6c90459c016fbb6ef96206","medium":"https://images.unsplash.com/profile-1479357663788-b91e1132b5db?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=64&w=64&s=06c3f9923dc68423c054110fdfb27821","large":"https://images.unsplash.com/profile-1479357663788-b91e1132b5db?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=128&w=128&s=735da828e5cc17618b751953dc76bd99"}
     * links : {"self":"https://api.unsplash.com/users/crfan89","html":"http://unsplash.com/@crfan89","photos":"https://api.unsplash.com/users/crfan89/photos","likes":"https://api.unsplash.com/users/crfan89/likes","portfolio":"https://api.unsplash.com/users/crfan89/portfolio","following":"https://api.unsplash.com/users/crfan89/following","followers":"https://api.unsplash.com/users/crfan89/followers"}
     */

    private UserBean user;
    /**
     * raw : https://images.unsplash.com/photo-1479357492746-2f22f66668fb full :
     * https://images.unsplash.com/photo-1479357492746-2f22f66668fb?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&s=9f45242b7d07fa7f44d1702c7b962e66
     * regular : https://images.unsplash.com/photo-1479357492746-2f22f66668fb?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max&s=382329cf84b668e3de352b8440c5637c
     * small : https://images.unsplash.com/photo-1479357492746-2f22f66668fb?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=400&fit=max&s=f93eb3204adc84eb2733bb8ef7e008b0
     * thumb : https://images.unsplash.com/photo-1479357492746-2f22f66668fb?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=200&fit=max&s=9235d078579b87cdf97d247b64b48b13
     */

    private PhotoUrlBean urls;
    /**
     * self : https://api.unsplash.com/photos/29ebQh7e78M html : http://unsplash.com/photos/29ebQh7e78M
     * download : http://unsplash.com/photos/29ebQh7e78M/download download_location :
     * https://api.unsplash.com/photos/29ebQh7e78M/download
     */

    private PhotoLinkBean links;
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

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
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

    public List<CategoryBean> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryBean> categories) {
        this.categories = categories;
    }


}
