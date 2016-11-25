package com.tang.imagesea.model;

/**
 * Created by tangsir on 2016/11/24.
 */
public class PositionBean {
    /**
     * latitude : 1.281332 longitude : 103.872557
     */
    private double latitude;
    private double longitude;

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
