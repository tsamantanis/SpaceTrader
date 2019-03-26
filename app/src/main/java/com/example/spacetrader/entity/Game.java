package com.example.spacetrader.entity;

import com.example.spacetrader.model.MarketPlace;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public static Player player;
    public static String currentPlanet;
    public static List<Planet> planets;
    public static MarketPlace marketPlace;

    public static void createPlayer(String name, int[] skillDistribution, String difficulty) {
        planets = new ArrayList<>();
        player = new Player(name, skillDistribution, difficulty);
        marketPlace = new MarketPlace(player);
        // TODO: select planet from universe screen
        currentPlanet = "Castor";
    }

    public static void generateUniverse() {
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
    }

}
