package com.example.spacetrader.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.spacetrader.R;
import com.example.spacetrader.entity.Game;
import com.example.spacetrader.model.Item;

import com.example.spacetrader.entity.Player;

import java.util.ArrayList;

public class MarketplaceActivity extends AppCompatActivity {
    private Spinner shipGoodsSpinner;
    private Spinner marketGoodsSpinner;

    private ArrayList<String> shipGoods;
    private ArrayList<String> marketGoods;

    private TextView errorMessage;
    private TextView location;

    protected static Player player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.marketplace_screen);
        shipGoods = new ArrayList<>();
        marketGoods = new ArrayList<>();
        player = Game.player;
        Log.d(null, player.getName());
        shipGoodsSpinner = findViewById(R.id.shipGoodsSpinner);
        marketGoodsSpinner = findViewById(R.id.marketGoodsSpinner);

        errorMessage = findViewById(R.id.errorMessageText);
        location = findViewById(R.id.location);
        location.setText("Location: " + player.getLocation());

        final Button sellButton = findViewById(R.id.sellButton);
        final Button buyButton = findViewById(R.id.buyButton);

        for (Item item : player.getSpaceship().getCargo()) {
            shipGoods.add(item.getName());
        }
        for (Item item : Game.marketPlace.getMarketItems()) {
            marketGoods.add(item.getName());
        }

        ArrayAdapter<String> shipGoodsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, shipGoods);
        shipGoodsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> marketGoodsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, marketGoods);
        shipGoodsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        shipGoodsSpinner.setAdapter(shipGoodsAdapter);
        marketGoodsSpinner.setAdapter(marketGoodsAdapter);


        sellButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //sell button implementation
            }
        });

        buyButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //buy button implementation
            }
        });
    }


}
