package com.example.spacetrader.views;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.spacetrader.R;
import com.example.spacetrader.entity.Game;
import com.example.spacetrader.entity.Spaceship;
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
    private TextView fuelRemaining;
    private TextView cargoHolds;

    private TextView shipGoodsPrice;
    private TextView marketGoodsPrice;

    private TextView credits;
    private TextView cargoSpace;

    protected static Player player;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.marketplace_screen);
        shipGoods = new ArrayList<>();
        marketGoods = new ArrayList<>();
        player = Game.player;
        shipGoodsSpinner = findViewById(R.id.shipGoodsSpinner);
        marketGoodsSpinner = findViewById(R.id.marketGoodsSpinner);

        shipGoodsPrice = findViewById(R.id.shipGoodPriceText);
        marketGoodsPrice = findViewById(R.id.marketGoodPriceText);

        credits = findViewById(R.id.creditsRemainingText);
        cargoSpace = findViewById(R.id.cargoSpaceRemainingText);

        credits.setText(Integer.toString(player.getCredits()));
        cargoSpace.setText(Integer.toString(player.getSpaceship().getCargo().size())+"/"+Integer.toString(player.getSpaceship().getCargoSpace()));

        errorMessage = findViewById(R.id.errorMessageText);
        location = findViewById(R.id.locationText);
        location.setText("Location: " + player.getCurrentPlanet().getName());
        fuelRemaining = findViewById(R.id.fuelRemainingText);
        fuelRemaining.setText("Fuel Remaining: " + player.getSpaceship().getFuel());


        final Button sellButton = findViewById(R.id.sellButton);
        final Button buyButton = findViewById(R.id.buyButton);

        for (Item item : player.getSpaceship().getCargo()) {
            shipGoods.add(item.getName());
        }
        for (Item item : Game.marketPlace.getMarketItems()) {
            marketGoods.add(item.getName());
        }

        final ArrayAdapter<String> shipGoodsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, shipGoods);
        shipGoodsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        final ArrayAdapter<String> marketGoodsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, marketGoods);
        shipGoodsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        shipGoodsSpinner.setAdapter(shipGoodsAdapter);
        marketGoodsSpinner.setAdapter(marketGoodsAdapter);

        shipGoodsSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String shipGoods = (String) shipGoodsSpinner.getSelectedItem();
                for (Item item : player.getSpaceship().getCargo()) {
                    if(shipGoods.equals(item.getName())) {
                        shipGoodsPrice.setText(Integer.toString(item.getPrice()));
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                shipGoodsPrice.setText(Integer.toString(0));
            }

        });

        marketGoodsSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String marketGoods = (String) marketGoodsSpinner.getSelectedItem();
                for (Item item : Game.marketPlace.getMarketItems()) {
                    if (marketGoods.equals(item.getName())) {
                        marketGoodsPrice.setText(Integer.toString(item.getPrice()));
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                marketGoodsPrice.setText(Integer.toString(0));
            }

        });


        sellButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String shipGood = (String) shipGoodsSpinner.getSelectedItem();
                Item item = null;
                for (Item item2 : player.getSpaceship().getCargo()) {
                    if (shipGood.equals(item2.getName())) {
                        item = item2;
                    }
                }
                if(Game.marketPlace.sellItem(item)) {
                    credits.setText(Integer.toString(player.getCredits()));
                    cargoSpace.setText(Integer.toString(player.getSpaceship().getCargo().size()) + "/" + Integer.toString(player.getSpaceship().getCargoSpace()));

                    marketGoods.add(item.getName());
                    marketGoodsAdapter.notifyDataSetChanged();

                    shipGoods.remove(item.getName());
                    shipGoodsAdapter.notifyDataSetChanged();

                    if (shipGoodsSpinner.getSelectedItemPosition() != 0) {
                        shipGoodsSpinner.setSelection(0, true);
                    } else {
                        shipGoodsSpinner.setSelection(1, true);
                    }

                    String shipGoods = (String) shipGoodsSpinner.getSelectedItem();
                    for (Item item2 : player.getSpaceship().getCargo()) {
                        if (shipGoods == null) {
                            shipGoodsPrice.setText(Integer.toString(0));
                        } else if (shipGoods.equals(item2.getName())) {
                            shipGoodsPrice.setText(Integer.toString(item2.getPrice()));
                        }
                    }
                }
            }
        });

        buyButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String marketGood = (String) marketGoodsSpinner.getSelectedItem();
                Item item2 = null;
                for (Item item : Game.marketPlace.getMarketItems()) {
                    if (marketGood.equals(item.getName())) {
                        item2 = item;
                    }
                }
                if (Game.marketPlace.buyItem(item2)) {
                    credits.setText(Integer.toString(player.getCredits()));
                    cargoSpace.setText(Integer.toString(player.getSpaceship().getCargo().size()) + "/" + Integer.toString(player.getSpaceship().getCargoSpace()));

                    marketGoods.remove(item2.getName());
                    marketGoodsAdapter.notifyDataSetChanged();

                    if(marketGoodsSpinner.getSelectedItemPosition() != 0) {
                        marketGoodsSpinner.setSelection(0, true);
                    } else {
                        marketGoodsSpinner.setSelection(1, true);
                    }
                    String marketGoods = (String) marketGoodsSpinner.getSelectedItem();
                    for (Item item3 : Game.marketPlace.getMarketItems()) {
                        if(marketGoods == null) {
                            marketGoodsPrice.setText(Integer.toString(0));
                        } else if (marketGoods.equals(item3.getName())) {
                            marketGoodsPrice.setText(Integer.toString(item3.getPrice()));
                        }
                    }
                    shipGoods.add(item2.getName());
                    shipGoodsAdapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(getApplicationContext(),"Not Enough Credits!",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
