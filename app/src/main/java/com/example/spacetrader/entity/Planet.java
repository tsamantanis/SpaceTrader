package com.example.spacetrader.entity;

import android.util.Log;

public class Planet {
    public final String NAME;
    public final int X_COORDINATE = 10;
    public final int Y_COORDINATE = 130;
    public int TECH_LEVEL;
    public int RESOURCE_LEVEL;

    public Planet(String name) {
        this.NAME = name;
        this.TECH_LEVEL = (int) (Math.random() * 8);
        this.RESOURCE_LEVEL = (int) (Math.random() * 13);
        Log.d(NAME, this.toString());
    }

    public String toString() {
        return "Name: " + NAME + ", POS: (" + X_COORDINATE + ", " + Y_COORDINATE + "), "
                + "Tech: " + TECH_LEVEL + ", Resources: " + RESOURCE_LEVEL;
    }
}