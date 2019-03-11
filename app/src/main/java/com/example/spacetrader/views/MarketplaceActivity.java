package com.example.spacetrader.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.spacetrader.R;
import com.example.spacetrader.model.Item;

public class MarketplaceActivity extends AppCompatActivity {
    private Spinner shipGoodsSpinner;
    private Spinner marketGoodsSpinner;

    private Item[] shipGoods;
    private Item[] marketGoods;

    private TextView errorMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.marketplace_screen);


        shipGoodsSpinner = findViewById(R.id.shipGoodsSpinner);
        marketGoodsSpinner = findViewById(R.id.marketGoodsSpinner);

        errorMessage = findViewById(R.id.errorMessageText);

        final Button sellButton = findViewById(R.id.sellButton);
        final Button buyButton = findViewById(R.id.buyButton);

        shipGoods = new Item[10]; //add in the ship goods here later
        marketGoods = new Item[10]; //add in the market goods here later

        ArrayAdapter<Item> shipGoodsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, shipGoods);
        shipGoodsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<Item> marketGoodsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, marketGoods);
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
