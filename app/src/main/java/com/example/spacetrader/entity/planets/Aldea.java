package com.example.spacetrader.entity.planets;

import android.util.Log;

public class Aldea {
    public final String NAME = "Aldea";
    public final int X_COORDINATE = 55;
    public final int Y_COORDINATE = 35;
    public int TECH_LEVEL;
    public int RESOURCE_LEVEL;

    public Aldea() {
        this.TECH_LEVEL = (int) (Math.random() * ((7 - 0) + 1));
        this.RESOURCE_LEVEL = (int) (Math.random() * ((12 - 0) + 1));
        Log.d(NAME, this.toString());
    }

    public String toString() {
        return "Name: " + NAME + ", POS: (" + X_COORDINATE + ", " + Y_COORDINATE + "), "
                + "Tech: " + TECH_LEVEL + ", Resources: " + RESOURCE_LEVEL;
    }
}