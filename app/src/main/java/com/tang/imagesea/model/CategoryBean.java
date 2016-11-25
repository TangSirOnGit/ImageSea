package com.tang.imagesea.model;

/**
 * Created by tangsir on 2016/11/24.
 */
public class CategoryBean {
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

}
