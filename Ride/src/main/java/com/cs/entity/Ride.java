package com.cs.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Ride implements Serializable {
    private String id;
    private String route;
    private String currentLocation;
    private String creatorUserId;
    // 1.not start;2.in processing;3.end;4.flag;
    private String status;

    private String banner;
    private List<User> userList = new ArrayList<User>();
    private Date begindate = new Date();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public String getCreatorUserId() {
        return creatorUserId;
    }

    public void setCreatorUserId(String creatorUserId) {
        this.creatorUserId = creatorUserId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public Date getBegindate() {
        return begindate;
    }

    public void setBegindate(Date begindate) {
        this.begindate = begindate;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    @Override
    public String toString() {
        return "Ride{" +
                "id='" + id + '\'' +
                ", route='" + route + '\'' +
                ", currentLocation='" + currentLocation + '\'' +
                ", creatorUserId='" + creatorUserId + '\'' +
                ", status='" + status + '\'' +
                ", userList=" + userList +
                ", begindate=" + begindate +
                '}';
    }
}
