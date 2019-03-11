package com.example.spacetrader.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.spacetrader.R;
import com.example.spacetrader.entity.Player;
import com.example.spacetrader.model.Item;

public class UniverseScreenActivity extends AppCompatActivity {
    //private Planet[] planetList;
    private Spinner planetSpinner;

    private TextView location;

    protected static Player player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universe_screen);

        planetSpinner = findViewById(R.id.planetSpinner);

        location = findViewById(R.id.locationText);
        location.setText("Location: " + player.getLocation());

        final Button travelButton = findViewById(R.id.travelButton);

//        ArrayAdapter<Item> planetsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, shipGoods);
//        shipGoodsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                //replace w/ everything for planets
    }




}
