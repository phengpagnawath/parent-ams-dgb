package com.wath.amsui.retrofit.model;

public class User {
    String id;
    String displayName;
    String profile;

    public User() {
    }

    public User(String id, String displayName, String profile) {
        this.id = id;
        this.displayName = displayName;
        this.profile = profile;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", displayName='" + displayName + '\'' +
                ", profile='" + profile + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }
}
