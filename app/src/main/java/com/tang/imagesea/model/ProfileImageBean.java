package com.tang.imagesea.model;

/**
 * Created by tangsir on 2016/11/24.
 */
public class ProfileImageBean {
    /**
     * small : https://images.unsplash.com/profile-1470371865055-c78771230b0d?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=32&w=32&s=3c383ade986fbb12f46457dd65eedeb2
     * medium : https://images.unsplash.com/profile-1470371865055-c78771230b0d?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=64&w=64&s=4a7d4201df25be32b8e00e89d89a303b
     * large : https://images.unsplash.com/profile-1470371865055-c78771230b0d?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=128&w=128&s=21b521dd1b708586466349621a7912bd
     */
    private String small;
    private String medium;
    private String large;

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }
}
