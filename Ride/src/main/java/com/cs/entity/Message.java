package com.cs.entity;

import java.io.Serializable;

/**
 * @Author:Yanlong Wang
 * @Date:4/23/2018_7:03 AM
 * @Description:
 */
public class Message implements Serializable {
    private String rideid;
    private String route;
    private String currentlocation;
    private String paticipants;
    private String paticipantids;

    public String getRideid() {
        return rideid;
    }

    public void setRideid(String rideid) {
        this.rideid = rideid;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getCurrentlocation() {
        return currentlocation;
    }

    public void setCurrentlocation(String currentlocation) {
        this.currentlocation = currentlocation;
    }

    public String getPaticipants() {
        return paticipants;
    }

    public void setPaticipants(String paticipants) {
        this.paticipants = paticipants;
    }

    public String getPaticipantids() {
        return paticipantids;
    }

    public void setPaticipantids(String paticipantids) {
        this.paticipantids = paticipantids;
    }

    @Override
    public String toString() {
        return "Message{" +
                "rideid='" + rideid + '\'' +
                ", route='" + route + '\'' +
                ", currentlocation='" + currentlocation + '\'' +
                ", paticipants='" + paticipants + '\'' +
                ", paticipantids='" + paticipantids + '\'' +
                '}';
    }
}
