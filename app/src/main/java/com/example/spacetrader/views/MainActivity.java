package com.example.spacetrader.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.spacetrader.R;
import com.example.spacetrader.entity.Player;

public class MainActivity extends AppCompatActivity {

    protected static Player player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent messageIntent = new Intent(this, IntroScreenActivity.class);
        startActivity(messageIntent);

    }

    public static void createPlayer(String name, int[] skillDistribution, String difficulty) {
        player = new Player(name, skillDistribution, difficulty);
        Log.i("Name: ", player.getName());
        Log.i("Credits: ", Integer.toString(player.getCredits()));
        Log.i("Difficulty: ", player.getDifficulty());
        Log.i("Location: ", player.getLocation());
        Log.i("Spaceship: ", player.getSpaceship());
        Log.i("Weapon: ", player.getWeapon());
        Log.i("Pilot: ", Integer.toString(player.getSkillDistribution()[0]));
        Log.i("Fighter: ", Integer.toString(player.getSkillDistribution()[1]));
        Log.i("Trader: ", Integer.toString(player.getSkillDistribution()[2]));
        Log.i("Engineer: ", Integer.toString(player.getSkillDistribution()[3]));
    }
}
