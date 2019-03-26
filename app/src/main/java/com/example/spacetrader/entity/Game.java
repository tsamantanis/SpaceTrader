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
        planets.add(new Planet("Aegon"));
        planets.add(new Planet("Aldea"));
        planets.add(new Planet("Brax"));
        planets.add(new Planet("Castor"));
        planets.add(new Planet("Daenerys"));
        planets.add(new Planet("Davlos"));
        planets.add(new Planet("Fourmi"));
        planets.add(new Planet("Kafka"));
        planets.add(new Planet("Rhaegon"));
        planets.add(new Planet("Zuul"));
    }

}
