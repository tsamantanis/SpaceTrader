package com.example.spacetrader.entity;

import com.example.spacetrader.model.MarketPlace;

public class Game {
    private static Player player;

    private MarketPlace marketPlace;

    public static void createPlayer(String name, int[] skillDistribution, String difficulty) {
        player = new Player(name, skillDistribution, difficulty);
    }

    public void createMarketPlace() {
        marketPlace = new MarketPlace(player);
    }

    public MarketPlace getMarketPlace() {
        return marketPlace;
    }

    public void setMarketPlace(MarketPlace marketPlace) {
        this.marketPlace = marketPlace;
    }
}
