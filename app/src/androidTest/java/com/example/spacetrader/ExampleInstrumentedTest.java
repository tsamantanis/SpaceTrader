package com.example.spacetrader;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.example.spacetrader.entity.Player;
import com.example.spacetrader.model.Item;
import com.example.spacetrader.model.MarketPlace;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    MarketPlace marketplace;
    Player player;

    @Before
    public void setup() {
        int[] skill = {4,4,4,4};
        player = new Player("Zak", skill , "Beginner");
        player.setCredits(0);
        marketplace = new MarketPlace(player, 10);
    }
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.example.spacetrader", appContext.getPackageName());
    }

    @Test //Mark
    public void testSellItem() {
        Item water = new Item("Water", 0, 0, 2, 30, 3,
                4, "Drought", "Lots of Water", "Desert", 30, 50);
        Item food = new Item("Food", 1, 0, 1, 100, 5,
                5, "CropFail", "Rich Soil", "Poor Soil", 90, 160);
        List<Item> spaceship = player.getSpaceship().getCargo();
        spaceship.add(water);
        spaceship.add(food);
        assertFalse(marketplace.sellItem(null));

        assertTrue(marketplace.sellItem(water));

        assertEquals(player.getCredits(), water.getPrice());
        ArrayList<Item> items = marketplace.getMarketItems();
        assertTrue(items.contains(water));

        int oldCredits = player.getCredits();
        assertTrue(marketplace.sellItem(food));
        assertEquals(player.getCredits(), oldCredits + food.getPrice());
        assertTrue(items.contains(food));

        assertTrue(spaceship.size() == 0);

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
}
