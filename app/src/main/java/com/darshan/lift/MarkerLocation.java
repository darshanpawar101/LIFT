package com.darshan.lift;

import com.google.firebase.firestore.GeoPoint;

public class MarkerLocation {
    private GeoPoint EndLocation;

    @Override
    public String toString() {
        return "MarkerLocation{" +
                "EndLocation=" + EndLocation +
                '}';
    }

    public GeoPoint getEndLocation() {
        return EndLocation;
    }

    public void setEndLocation(GeoPoint endLocation) {
        EndLocation = endLocation;
    }

    public MarkerLocation(GeoPoint endLocation) {
        EndLocation = endLocation;
    }
    public MarkerLocation() {

    }
}
