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


}
