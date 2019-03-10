package com.example.spacetrader.entity.planets;

import android.util.Log;

public class Castor {
    public final String NAME = "Castor";
    public final int X_COORDINATE = 65;
    public final int Y_COORDINATE = 110;
    public int TECH_LEVEL;
    public int RESOURCE_LEVEL;

    public Castor() {
        this.TECH_LEVEL = (int) (Math.random() * ((7 - 0) + 1));
        this.RESOURCE_LEVEL = (int) (Math.random() * ((12 - 0) + 1));
        Log.d(NAME, this.toString());
    }

    public String toString() {
        return "Name: " + NAME + ", POS: (" + X_COORDINATE + ", " + Y_COORDINATE + "), "
                + "Tech: " + TECH_LEVEL + ", Resources: " + RESOURCE_LEVEL;
    }
}
