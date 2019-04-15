package com.example.spacetrader;

import com.example.spacetrader.entity.Game;
import com.example.spacetrader.entity.Planet;
import com.example.spacetrader.entity.Player;
import com.example.spacetrader.model.Item;
import com.example.spacetrader.model.MarketPlace;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    private MarketPlace marketPlace;
    private Player player;

    @Before
    public void setup() {
        int[] skill = {4, 4, 4, 4};
        player = new Player("Player", skill, "Beginner");
        marketPlace = new MarketPlace(player, 6);
        player.setCurrentPlanet(new Planet("Castor", 65, 110));
    }

    //Sukhmai
    //This junit tests the buying of a null item
    @Test
    public void buyNullItem() {
        assertFalse(marketPlace.buyItem(null));
    }

    //Sukhmai
    //This junit tests buying an item you don't have enough credits for
    @Test
    public void buyNotEnoughCredits() {
        player.setCredits(0);
        assertFalse(marketPlace.buyItem(marketPlace.getMarketItems().get(0)));
    }

    //Sukhmai
    //This junit tests buying an item you don't have space in your ship for
    @Test
    public void buyNotEnoughSpace() {
        for (int i = 0; i < 3; i++) {
            player.getSpaceship().addCargo(marketPlace.getMarketItems().get(i));
        }
        assertFalse(marketPlace.buyItem(marketPlace.getMarketItems().get(0)));
    }

    //Sukhmai
    //This junit tests if buyItem works normally
    @Test
    public void buyItemNormally() {
        assertTrue(marketPlace.buyItem(marketPlace.getMarketItems().get(0)));
    }

    //Sukhmai
    //This junit tests removing an item not in the marketPlace
    @Test
    public void buyNonexistantItem() {
        Item item = new Item("Zooks", 0, 0, 2, 30, 3,
                4, "No Zooks", "Lots of Zooks", "Zookland", 5, 5);
        assertFalse(marketPlace.buyItem(item));
    }

    @Test //Mark
    public void testSellNullItem() {
        assertFalse(marketPlace.sellItem(null));
    }
    @Test //Mark
    public void testSellItemUpdateCredits() {
        Item water = new Item("Water", 0, 0, 2, 30, 3,
                4, "Drought", "Lots of Water", "Desert", 30, 50);
        player.setCredits(0);
        assertTrue(marketPlace.sellItem(water));

        assertEquals(player.getCredits(), water.getPrice());
    }
    @Test //Mark
    public void testMarketPlaceUpdatedAfterSell() {
        Item water = new Item("Water", 0, 0, 2, 30, 3,
                4, "Drought", "Lots of Water", "Desert", 30, 50);
        marketPlace.sellItem(water);

        ArrayList<Item> items = marketPlace.getMarketItems();
        assertTrue(items.contains(water));
    }
    @Test //Mark
    public void testSpaceshipUpdatedAfterSell() {
        List<Item> spaceship = player.getSpaceship().getCargo();
        Item water = new Item("Water", 0, 0, 2, 30, 3,
                4, "Drought", "Lots of Water", "Desert", 30, 50);
        spaceship.add(water);
        marketPlace.sellItem(water);
        assertTrue(spaceship.size() == 0);
    }

    @Test //Sophia
    public void testCalculatePriceNonexistentItem() {
        Item j = new Item();
        assertTrue(0 == j.calculatePrice());
    }
    @Test //Sophia
    public void testCalculatePrice() {
        int v = 1;
        int b = 2;
        int t = 4;
        int m = 3;
        int i = 5;
        Item j = new Item("j", m, 2, t, b, i, v, "j", "j", "j", 1, 2);
        assertTrue("Calculated Price Out of Expected Range", 6.45 < j.calculatePrice()
                && 8.1 > j.calculatePrice());
    }

    @Test //Suddy
    public void testPlanetChangeOnTravel() {
        Planet aegon = new Planet("Aegon", 10, 130);
        Planet oldPlanet = player.getCurrentPlanet();
        player.travel(aegon); // travel to Aegon
        assertNotEquals(oldPlanet, player.getCurrentPlanet()); // verify planet changed
        assertEquals(aegon, player.getCurrentPlanet()); // verify new planet is correct
    }

    @Test //Suddy
    public void testFuelChangeOnTravel() {
        Planet dany = new Planet("Daenerys", 50, 70);
        int oldFuelAmount = player.getSpaceship().getFuel();
        player.travel(dany); // travel to Daenerys
        assertEquals(dany, player.getCurrentPlanet()); // verify planet is correct
        assertNotEquals(player.getSpaceship().getFuel(), oldFuelAmount); // verify fuel has changed
    }


}