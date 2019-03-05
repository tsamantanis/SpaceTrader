package com.example.spacetrader.entity;

import android.widget.Space;

import com.example.spacetrader.model.Item;

import java.util.ArrayList;

public class Spaceship {

    private String name;

    private int cargoSpace;

    private ArrayList<Item> cargo;

    public Spaceship() {
        name = "Second Hand Gnat";
        cargoSpace = 15;
        cargo = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCargoSpace() {
        return cargoSpace;
    }

    public void setCargoSpace(int cargoSpace) {
        this.cargoSpace = cargoSpace;
    }


    public ArrayList<Item> getCargo() {
        return cargo;
    }

    public void setCargo(ArrayList<Item> cargo) {
        this.cargo = cargo;
    }

    public void addCargo(Item item) {
        cargo.add(item);
    }

    public void removeCargo(Item item) {
        cargo.remove(item);
    }
}
