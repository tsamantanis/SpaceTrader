package com.example.spacetrader.model;

import com.example.spacetrader.entity.Player;
import com.example.spacetrader.entity.Spaceship;

import java.util.ArrayList;

public class MarketPlace {
    private ArrayList<Item> marketItems;

    protected static Player player;
    public MarketPlace(Player player) {
        marketItems = new ArrayList<>();
        marketItems.add(new Item("Water", 0, 0, 2, 30, 3,
                4, "Drought", "Lots of Water", "Desert", 30, 50));
        marketItems.add(new Item("Furs", 0, 0, 0, 250, 10,
                10, "Cold", "Rich Fauna", "Lifeless", 230, 280));
        marketItems.add(new Item("Food", 1, 0, 1, 100, 5,
                5, "CropFail", "Rich Soil", "Poor Soil", 90, 160));
        marketItems.add(new Item("Ore", 2, 2, 3, 350, 20,
                10, "War", "Mineral Rich", "Mineral Poor", 350, 420));
        marketItems.add(new Item("Games", 3, 1, 6, 250, -10,
                5, "Boredom", "Artistic", "Never", 160, 270));
        marketItems.add(new Item("Firearms", 3, 1, 5, 1250, -75,
                100, "War", "Warlike", "Never", 600, 1100));
        marketItems.add(new Item("Medicine", 4, 1, 6, 650, -20,
                10, "Plague", "Lots of Herbs", "Never", 400, 700));
        marketItems.add(new Item("Machines", 4, 3, 5, 900, -30,
                5, "Lack of Workers", "Never", "Never", 600, 800));
        marketItems.add(new Item("Narcotics", 5, 0, 5, 3500, -125,
                150, "Boredom", "Weird Mushrooms", "Never", 2000, 3000));
        marketItems.add(new Item("Robots", 6, 4, 7, 5000, -150,
                100, "Lack of Workers", "Never", "Never", 3500, 5000));
        this.player = player;
    }

    public ArrayList<Item> getMarketItems() {
        return marketItems;
    }

    public void sellItem(Item item) {
        player.setCredits(player.getCredits() + item.getPrice());
        marketItems.add(item);
        player.getSpaceship().removeCargo(item);
    }

    public boolean buyItem(Item item) {

        if (player.getCredits() - item.getPrice() >= 0 && player.getSpaceship().getCargo().size() != player.getSpaceship().getCargoSpace()) {
            player.setCredits(player.getCredits() - item.getPrice());
            player.getSpaceship().addCargo(item);
            marketItems.remove(item);
            return true;
        }
        return false;
    }
}
