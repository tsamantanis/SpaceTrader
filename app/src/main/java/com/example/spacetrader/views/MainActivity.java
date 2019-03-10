package com.example.spacetrader.views;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.support.v7.app.AppCompatActivity;


import com.example.spacetrader.R;
import com.example.spacetrader.entity.Player;
import com.example.spacetrader.entity.planets.Aegon;
import com.example.spacetrader.entity.planets.Aldea;
import com.example.spacetrader.entity.planets.Brax;
import com.example.spacetrader.entity.planets.Castor;
import com.example.spacetrader.entity.planets.Daenerys;
import com.example.spacetrader.entity.planets.Davlos;
import com.example.spacetrader.entity.planets.Fourmi;
import com.example.spacetrader.entity.planets.Kafka;
import com.example.spacetrader.entity.planets.Rhaegon;
import com.example.spacetrader.entity.planets.Zuul;

public class MainActivity extends AppCompatActivity {

    protected static Player player;

    // Solar systems
    protected static Aegon aegon;
    protected static Aldea aldea;
    protected static Brax brax;
    protected static Castor castor;
    protected static Daenerys daenerys;
    protected static Davlos davlos;
    protected static Fourmi fourmi;
    protected static Kafka kafka;
    protected static Rhaegon rhaegon;
    protected static Zuul zuul;

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

    public static void generateUniverse() {
        aegon = new Aegon();
        aldea = new Aldea();
        brax = new Brax();
        castor = new Castor();
        daenerys = new Daenerys();
        davlos = new Davlos();
        fourmi = new Fourmi();
        kafka = new Kafka();
        rhaegon = new Rhaegon();
        zuul = new Zuul();
    }
}
