package com.example.spacetrader.entity;

import com.example.spacetrader.model.Item;

import java.util.ArrayList;
import java.util.List;

public class Spaceship {

    private String name;

    private int cargoSpace;

    private List<Item> cargo;

    private int fuel;

    public Spaceship() {
        name = "Second Hand Gnat";
        cargoSpace = 3;
        cargo = new ArrayList<>();
        fuel = 1000;
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

    public void setFuel(int fuel) { this.fuel = fuel; }

    public int getFuel() { return fuel; }

    public List<Item> getCargo() {
        return cargo;
    }

    public void setCargo(List<Item> cargo) {
        this.cargo = cargo;
    }

    public void addCargo(Item item) {
        cargo.add(item);
    }

    public void removeCargo(Item item) {
        cargo.remove(item);
    }
}
