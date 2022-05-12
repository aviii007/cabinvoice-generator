package com.bridgelabz;

public class Ride {
    public RideCategory category;
    public double distance;
    public int time;

    public Ride(double distance, int time) {
        this.distance = distance;
        this.time = time;
    }

    public Ride(RideCategory category, double distance, int time) {
        this.distance = distance;
        this.time = time;
        this.category = category;
    }
}