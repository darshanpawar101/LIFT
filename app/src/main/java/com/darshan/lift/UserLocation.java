package com.darshan.lift;

import com.google.firebase.firestore.GeoPoint;
import com.google.firebase.firestore.auth.User;

public class UserLocation {
    private GeoPoint StartLocation;
    private GeoPoint EndLocation;
    private User user;
    private Boolean IsRider;

    public UserLocation(GeoPoint startLocation, GeoPoint endLocation, User user, Boolean isRider) {
        StartLocation = startLocation;
        EndLocation = endLocation;
        this.user = user;
        IsRider = isRider;
    }

    public UserLocation() {

    }

    public GeoPoint getStartLocation() {
        return StartLocation;
    }

    public void setStartLocation(GeoPoint startLocation) {
        StartLocation = startLocation;
    }

    public GeoPoint getEndLocation() {
        return EndLocation;
    }

    public void setEndLocation(GeoPoint endLocation) {
        EndLocation = endLocation;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Boolean getRider() {
        return IsRider;
    }

    public void setRider(Boolean rider) {
        IsRider = rider;
    }

    @Override
    public String toString() {
        return "UserLocation{" +
                "StartLocation=" + StartLocation +
                ", EndLocation=" + EndLocation +
                ", user=" + user +
                ", IsRider=" + IsRider +
                '}';
    }
}




/*
import com.google.firebase.firestore.GeoPoint;
import com.google.firebase.firestore.auth.User;

public class UserLocation {
    private GeoPoint StartLocation;
    private GeoPoint EndLocation;
    private User user;

    public GeoPoint getStartLocation() {
        return StartLocation;
    }

    public void setStartLocation(GeoPoint startLocation) {
        StartLocation = startLocation;
    }

    public GeoPoint getEndLocation() {
        return EndLocation;
    }

    public void setEndLocation(GeoPoint endLocation) {
        EndLocation = endLocation;
    }

    @Override
    public String toString() {
        return "UserLocation{" +
                "StartLocation=" + StartLocation +
                ", EndLocation=" + EndLocation +
                ", user=" + user +
                '}';
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserLocation(GeoPoint startLocation, GeoPoint endLocation, User user) {
        StartLocation = startLocation;
        EndLocation = endLocation;
        this.user = user;
    }

    public UserLocation() {
    }
}*/
/*
import com.google.firebase.firestore.GeoPoint;
import com.google.firebase.firestore.auth.User;

public class UserLocation {
    private GeoPoint StartLocation;
    private User user;

    public UserLocation(GeoPoint StartLocation, User user) {
        this.StartLocation = StartLocation;
        this.user = user;
    }

    public UserLocation() {
    }

    public GeoPoint getGeo_point() {
        return StartLocation;
    }

    public void setGeo_point(GeoPoint StartLocation) {
        this.StartLocation = StartLocation;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserLocation{" +
                "StartLocation=" + StartLocation +
                ", user=" + user +
                '}';
    }
}*/
