package com.example.spacetrader;

import com.example.spacetrader.entity.Player;
import com.example.spacetrader.model.Item;
import com.example.spacetrader.model.MarketPlace;

import org.junit.Before;
import org.junit.Test;

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
}