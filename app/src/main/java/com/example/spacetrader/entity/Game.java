package com.example.spacetrader.entity;

import com.example.spacetrader.model.MarketPlace;

public class Game {
    public static Player player;

    public static MarketPlace marketPlace;

    public static void createPlayer(String name, int[] skillDistribution, String difficulty) {
        player = new Player(name, skillDistribution, difficulty);
        marketPlace = new MarketPlace(player);
    }

}
