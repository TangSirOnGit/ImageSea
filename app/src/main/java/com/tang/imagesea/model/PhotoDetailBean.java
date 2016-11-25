package com.tang.imagesea.model;

/**
 * Created by tangsir on 2016/11/24.
 */

public class PhotoDetailBean extends PhotoBean {

    private ExifBean exif;

    private LocationBean location;

    public ExifBean getExif() {
        return exif;
    }

    public void setExif(ExifBean exif) {
        this.exif = exif;
    }

    public LocationBean getLocation() {
        return location;
    }

    public void setLocation(LocationBean location) {
        this.location = location;
    }


}
