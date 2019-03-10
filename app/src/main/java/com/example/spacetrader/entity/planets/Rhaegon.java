package com.example.spacetrader.entity.planets;

import android.util.Log;

public class Rhaegon {
    public final String NAME = "Rhaegon";
    public final int X_COORDINATE = 20;
    public final int Y_COORDINATE = 40;
    public int TECH_LEVEL;
    public int RESOURCE_LEVEL;

    public Rhaegon() {
        this.TECH_LEVEL = (int) (Math.random() * ((7 - 0) + 1));
        this.RESOURCE_LEVEL = (int) (Math.random() * ((12 - 0) + 1));
        Log.d(NAME, this.toString());
    }

    public String toString() {
        return "Name: " + NAME + ", POS: (" + X_COORDINATE + ", " + Y_COORDINATE + "), "
                + "Tech: " + TECH_LEVEL + ", Resources: " + RESOURCE_LEVEL;
    }
}
