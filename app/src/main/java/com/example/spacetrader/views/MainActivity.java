package com.example.spacetrader.views;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.support.v7.app.AppCompatActivity;


import com.example.spacetrader.R;
import com.example.spacetrader.entity.Planet;
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

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent messageIntent = new Intent(this, IntroScreenActivity.class);
        startActivity(messageIntent);
    }
}
