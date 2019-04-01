package com.example.spacetrader.entity;

import android.util.Log;

public class Planet {
    private final String NAME;
    private final int X_COORDINATE;
    private final int Y_COORDINATE;
    private final int TECH_LEVEL;
    private final int RESOURCE_LEVEL;

    public Planet(String name, int x, int y) {
        this.NAME = name;
        this.X_COORDINATE = x;
        this.Y_COORDINATE = y;
        this.TECH_LEVEL = (int) (Math.random() * 8);
        this.RESOURCE_LEVEL = (int) (Math.random() * 13);
        Log.d(NAME, this.toString());
    }

    public String getName() {
        return NAME;
    }

    public int getX() {
        return X_COORDINATE;
    }

    public int getY() {
        return Y_COORDINATE;
    }

    public int getTechLevel() {
        return TECH_LEVEL;
    }

    public int getResourceLevel() {
        return RESOURCE_LEVEL;
    }

    public String toString() {
        return "Name: " + NAME + ", POS: (" + X_COORDINATE + ", " + Y_COORDINATE + "), "
                + "Tech: " + TECH_LEVEL + ", Resources: " + RESOURCE_LEVEL;
    }
}
