package com.example.spacetrader.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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
    }
}
