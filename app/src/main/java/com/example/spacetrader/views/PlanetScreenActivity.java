package com.example.spacetrader.views;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.spacetrader.R;
import com.example.spacetrader.entity.Game;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import static com.example.spacetrader.entity.Game.player;

public class PlanetScreenActivity extends AppCompatActivity {

    private TextView planetLabel;
    private Button marketplaceButton;
    private TextView fuelRemaining;
    private Button travelButton;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planet_screen);
        planetLabel = findViewById(R.id.textView_currentPlanet);
        if (player.getCurrentPlanet() != null) planetLabel.setText(new StringBuilder().append("Player: ").append(player.getName()));

        fuelRemaining = findViewById(R.id.textView_Fuel);
        fuelRemaining.setText("Fuel Remaining: " + player.getSpaceship().getFuel());

        marketplaceButton = findViewById(R.id.button_marketplace);
        marketplaceButton.setText("Marketplace");

        travelButton = findViewById(R.id.button_travel);
        travelButton.setText("Travel");

        saveButton = findViewById(R.id.saveGameButton);
        final Context context = this.getApplicationContext();
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Game.savePlayer(context);
            }
        });

        final Intent marketplaceIntent = new Intent(this, MarketplaceActivity.class);
        marketplaceButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(marketplaceIntent);
            }
        });

        final Intent universeIntent = new Intent(this, UniverseScreenActivity.class);
        travelButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(universeIntent);
            }
        });
    }
}
