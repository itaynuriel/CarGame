package com.example.hw1.Utilities;

import android.os.Bundle;

import androidx.recyclerview.widget.RecyclerView;

public class Score implements Comparable {

    private int score;
    private boolean onLocation;
    private double latitude, longitude;

    public Score() {
    }
    public Score(int score, boolean onLocation, double latitude, double longitude) {
        this.score = score;
        this.onLocation = onLocation;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getScore() {
        return score;
    }

    public Score setScore(int score) {
        this.score = score;
        return this;
    }


    public boolean isOnLocation() {
        return onLocation;
    }

    public Score setOnLocation(boolean onLocation) {
        this.onLocation = onLocation;
        return this;
    }

    public double getLatitude() {
        return latitude;
    }

    public Score setLatitude(double latitude) {
        this.latitude = latitude;
        return this;
    }

    public double getLongitude() {
        return longitude;
    }

    public Score setLongitude(double longitude) {
        this.longitude = longitude;
        return this;
    }

    @Override
    public int compareTo(Object o) {
        try {
            Score s1 = (Score) o;
            return s1.getScore() - score;
        } catch (Exception ex) {
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Score { " +
                "score:" + score +
                ", onLocation:" + onLocation +
                ", latitude:" + latitude +
                ", longitude:" + longitude +
                "} ";
    }
}