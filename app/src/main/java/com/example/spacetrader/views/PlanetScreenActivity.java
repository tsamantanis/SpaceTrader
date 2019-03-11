package com.example.spacetrader.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.spacetrader.R;
import com.example.spacetrader.entity.Game;

public class PlanetScreenActivity extends AppCompatActivity {

    private TextView planetLabel;
    private Button marketplaceButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planet_screen);
        planetLabel = findViewById(R.id.textView_currentPlanet);
        planetLabel.setText(new StringBuilder().append("Planet ").append(Game.currentPlanet).toString());
        marketplaceButton = findViewById(R.id.button_marketplace);
        marketplaceButton.setText("Marketplace");

        final Intent marketplaceIntent = new Intent(this, MarketplaceActivity.class);
        marketplaceButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(marketplaceIntent);
            }
        });
    }
}
