package com.tang.imagesea.model;

/**
 * Created by tangsir on 2016/11/24.
 */
public class LocationBean {
    /**
     * title : Marina Barrage, Singapore
     * name : Marina Barrage
     * city : null
     * country : Singapore
     * position : {"latitude":1.281332,"longitude":103.872557}
     */
    private String title;
    private String name;
    private Object city;
    private String country;

    private PositionBean position;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getCity() {
        return city;
    }

    public void setCity(Object city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public PositionBean getPosition() {
        return position;
    }

    public void setPosition(PositionBean position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "{" +
                "title='" + title + '\'' +
                ", name='" + name + '\'' +
                ", city=" + city +
                ", country='" + country + '\'' +
                ", position=" + position +
                '}';
    }
}
