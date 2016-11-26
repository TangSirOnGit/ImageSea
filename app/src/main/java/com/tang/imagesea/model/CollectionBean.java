package com.tang.imagesea.model;

import com.google.gson.annotations.SerializedName;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by tangsir on 2016/11/24.
 */
public class CollectionBean implements Parcelable {
    private int id;
    private String title;
    private String description;
    private String published_at;
    private boolean curated;
    private boolean featured;
    private int total_photos;
    @SerializedName("private")
    private boolean privateX;
    private String share_key;
    /**
     * id : 29ebQh7e78M created_at : 2016-11-16T23:40:18-05:00 width : 5616 height : 3744 color
     * : #F6F8F6 likes : 97 liked_by_user : false user : {"id":"e0DndGdXY0Y","username":"crfan89","name":"Jeff
     * Fan","first_name":"Jeff","last_name":"Fan","portfolio_url":null,"bio":"","location":null,"total_likes":1,"total_photos":1,"total_collections":0,"profile_image":{"small":"https://images.unsplash.com/profile-1479357663788-b91e1132b5db?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=32&w=32&s=e448ef119c6c90459c016fbb6ef96206","medium":"https://images.unsplash.com/profile-1479357663788-b91e1132b5db?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=64&w=64&s=06c3f9923dc68423c054110fdfb27821","large":"https://images.unsplash.com/profile-1479357663788-b91e1132b5db?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=128&w=128&s=735da828e5cc17618b751953dc76bd99"},"links":{"self":"https://api.unsplash.com/users/crfan89","html":"http://unsplash.com/@crfan89","photos":"https://api.unsplash.com/users/crfan89/photos","likes":"https://api.unsplash.com/users/crfan89/likes","portfolio":"https://api.unsplash.com/users/crfan89/portfolio","following":"https://api.unsplash.com/users/crfan89/following","followers":"https://api.unsplash.com/users/crfan89/followers"}}
     * urls : {"raw":"https://images.unsplash.com/photo-1479357492746-2f22f66668fb","full":"https://images.unsplash.com/photo-1479357492746-2f22f66668fb?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&s=9f45242b7d07fa7f44d1702c7b962e66","regular":"https://images.unsplash.com/photo-1479357492746-2f22f66668fb?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max&s=382329cf84b668e3de352b8440c5637c","small":"https://images.unsplash.com/photo-1479357492746-2f22f66668fb?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=400&fit=max&s=f93eb3204adc84eb2733bb8ef7e008b0","thumb":"https://images.unsplash.com/photo-1479357492746-2f22f66668fb?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=200&fit=max&s=9235d078579b87cdf97d247b64b48b13"}
     * categories : [] links : {"self":"https://api.unsplash.com/photos/29ebQh7e78M","html":"http://unsplash.com/photos/29ebQh7e78M","download":"http://unsplash.com/photos/29ebQh7e78M/download","download_location":"https://api.unsplash.com/photos/29ebQh7e78M/download"}
     */

    private CoverPhotoBean cover_photo;
    /**
     * id : cWSW4Im-yxk username : neilbravo name : Neil Nagy first_name : Neil last_name : Nagy
     * portfolio_url : null bio : location : null total_likes : 0 total_photos : 0
     * total_collections : 18 profile_image : {"small":"https://images.unsplash.com/profile-fb-1469805441-f1e8e437bc36.jpg?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=32&w=32&s=0d1b56e9887f8352daee6886c0ac15d7","medium":"https://images.unsplash.com/profile-fb-1469805441-f1e8e437bc36.jpg?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=64&w=64&s=bfab7223cb2d451fdcf2be982e87deae","large":"https://images.unsplash.com/profile-fb-1469805441-f1e8e437bc36.jpg?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=128&w=128&s=bc73c44c0e046e710abe069998512d50"}
     * links : {"self":"https://api.unsplash.com/users/neilbravo","html":"http://unsplash.com/@neilbravo","photos":"https://api.unsplash.com/users/neilbravo/photos","likes":"https://api.unsplash.com/users/neilbravo/likes","portfolio":"https://api.unsplash.com/users/neilbravo/portfolio","following":"https://api.unsplash.com/users/neilbravo/following","followers":"https://api.unsplash.com/users/neilbravo/followers"}
     */

    private UserBean user;
    /**
     * self : https://api.unsplash.com/collections/353540 html : http://unsplash.com/collections/353540/bridges
     * photos : https://api.unsplash.com/collections/353540/photos related :
     * https://api.unsplash.com/collections/353540/related
     */

    private CollectionLinkBean links;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublished_at() {
        return published_at;
    }

    public void setPublished_at(String published_at) {
        this.published_at = published_at;
    }

    public boolean isCurated() {
        return curated;
    }

    public void setCurated(boolean curated) {
        this.curated = curated;
    }

    public boolean isFeatured() {
        return featured;
    }

    public void setFeatured(boolean featured) {
        this.featured = featured;
    }

    public int getTotal_photos() {
        return total_photos;
    }

    public void setTotal_photos(int total_photos) {
        this.total_photos = total_photos;
    }

    public boolean isPrivateX() {
        return privateX;
    }

    public void setPrivateX(boolean privateX) {
        this.privateX = privateX;
    }

    public String getShare_key() {
        return share_key;
    }

    public void setShare_key(String share_key) {
        this.share_key = share_key;
    }

    public CoverPhotoBean getCover_photo() {
        return cover_photo;
    }

    public void setCover_photo(CoverPhotoBean cover_photo) {
        this.cover_photo = cover_photo;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public CollectionLinkBean getLinks() {
        return links;
    }

    public void setLinks(CollectionLinkBean links) {
        this.links = links;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.title);
        dest.writeString(this.description);
        dest.writeString(this.published_at);
        dest.writeByte(this.curated ? (byte) 1 : (byte) 0);
        dest.writeByte(this.featured ? (byte) 1 : (byte) 0);
        dest.writeInt(this.total_photos);
        dest.writeByte(this.privateX ? (byte) 1 : (byte) 0);
        dest.writeString(this.share_key);
        dest.writeParcelable(this.cover_photo, flags);
        dest.writeParcelable(this.user, flags);
        dest.writeParcelable(this.links, flags);
    }

    public CollectionBean() {
    }

    protected CollectionBean(Parcel in) {
        this.id = in.readInt();
        this.title = in.readString();
        this.description = in.readString();
        this.published_at = in.readString();
        this.curated = in.readByte() != 0;
        this.featured = in.readByte() != 0;
        this.total_photos = in.readInt();
        this.privateX = in.readByte() != 0;
        this.share_key = in.readString();
        this.cover_photo = in.readParcelable(CoverPhotoBean.class.getClassLoader());
        this.user = in.readParcelable(UserBean.class.getClassLoader());
        this.links = in.readParcelable(CollectionLinkBean.class.getClassLoader());
    }

    public static final Parcelable.Creator<CollectionBean> CREATOR = new Parcelable.Creator<CollectionBean>() {
        @Override
        public CollectionBean createFromParcel(Parcel source) {
            return new CollectionBean(source);
        }

        @Override
        public CollectionBean[] newArray(int size) {
            return new CollectionBean[size];
        }
    };
}
