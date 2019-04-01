package com.example.spacetrader.entity;

import android.media.Image;

import com.example.spacetrader.model.MarketPlace;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public static Player player;
    public static Planet currentPlanet;
    public static List<Planet> planets;
    public static MarketPlace marketPlace;

    public static void createPlayer(String name, int[] skillDistribution, String difficulty) {
        player = new Player(name, skillDistribution, difficulty);
        marketPlace = new MarketPlace(player, currentPlanet.getTechLevel());
        // TODO: select planet from universe screen

    }

    public static void generateUniverse() {
        planets = new ArrayList<>();
        planets.add(new Planet("Aegon", 10, 130));
        planets.add(new Planet("Aldea", 55, 35));
        planets.add(new Planet("Brax", 25, 75));
        planets.add(new Planet("Castor", 65, 110));
        planets.add(new Planet("Daenerys", 50, 70));
        planets.add(new Planet("Davlos", 35, 85));
        planets.add(new Planet("Fourmi", 55, 135));
        planets.add(new Planet("Kafka", 75, 45));
        planets.add(new Planet("Rhaegon", 20, 40));
        planets.add(new Planet("Zuul", 8, 15));
        currentPlanet = planets.get(3);
    }

    public static int calculateDistance(Planet planet) {
        return (int) Math.sqrt(Math.pow(planet.getX() - currentPlanet.getX(), 2) + Math.pow(planet.getY() - currentPlanet.getY(), 2));
    }

    public static int calculateFuelPrice(Planet planet) {
        return (int) (calculateDistance(planet) * 3.5);
    }

    public static void travel(Planet planet) {
        int currentFuel = player.getSpaceship().getFuel();
        player.getSpaceship().setFuel(currentFuel - calculateFuelPrice(planet));
        currentPlanet = planet;
    }



}
