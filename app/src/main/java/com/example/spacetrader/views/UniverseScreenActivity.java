package com.example.spacetrader.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.spacetrader.R;
import com.example.spacetrader.entity.Player;
import com.example.spacetrader.model.Item;
import com.example.spacetrader.entity.Game;
import com.example.spacetrader.entity.Planet;
import com.example.spacetrader.entity.Event;
import com.example.spacetrader.model.MarketPlace;

import java.util.ArrayList;
import java.util.List;

import static com.example.spacetrader.entity.Game.currentPlanet;
import static com.example.spacetrader.entity.Game.marketPlace;
import static com.example.spacetrader.entity.Game.player;
import static com.example.spacetrader.entity.Game.travel;

public class UniverseScreenActivity extends AppCompatActivity {
    //private Planet[] planetList;
    private Spinner planetSpinner;

    private TextView location;

    private ArrayList<String> planetNames = new ArrayList<>();

    private TextView distance;
    private TextView fuelCost;

    private Button backButton;

    private static List<Event> events;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universe_screen);

        planetSpinner = findViewById(R.id.planetSpinner);

        location = findViewById(R.id.locationText);
        location.setText("Location: " + Game.currentPlanet.getName());

        distance = findViewById(R.id.distance);
        fuelCost = findViewById(R.id.fuelcost);
        backButton = findViewById(R.id.button_Back);

        final Button travelButton = findViewById(R.id.travelButton);

        events = new ArrayList<>();
        events.add(new Event("Pirate boards your ship", "A pirate boarded your ship and managed to steal an item from your cargo."));
        events.add(new Event("Incoming Asteroid", "An asteroid is heading towards you, so you maneuver and lose some extra fuel"));
        events.add(new Event("Pirate Chase", "A pirate ship is attempting to board your ship. You spend more fuel to evade them"));
        events.add(new Event("Asteroid Belt", "You encounter an asteroid belt. Your ship gets severely damaged causing you to lose cargo and fuel"));

        travelButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int random = (int) (Math.random() * 6);
                Toast.makeText(getApplicationContext(), random + "",Toast.LENGTH_SHORT).show();

                if (random < 4) {
                    if (random == 0) {
                        List<Item> tempCargo = Game.player.getSpaceship().getCargo();
                        tempCargo.remove(0);
                        Game.player.getSpaceship().setCargo(tempCargo);
                    } else if (random == 1) {
                        int tempFuel = Game.player.getSpaceship().getFuel();
                        if (tempFuel > 50) {
                            tempFuel = tempFuel - 50;
                        } else {
                            tempFuel = 0;
                        }                    Game.player.getSpaceship().setFuel(tempFuel);
                    } else if (random == 2) {
                        int tempFuel = Game.player.getSpaceship().getFuel();
                        if (tempFuel > 100) {
                            tempFuel = tempFuel - 100;
                        } else {
                            tempFuel = 0;
                        }
                        Game.player.getSpaceship().setFuel(tempFuel);
                    } else if (random == 3) {
                        int tempFuel = Game.player.getSpaceship().getFuel();
                        if (tempFuel > 50) {
                            tempFuel = tempFuel - 50;
                        } else {
                            tempFuel = 0;
                        }
                        Game.player.getSpaceship().setFuel(tempFuel);
                        List<Item> tempCargo = Game.player.getSpaceship().getCargo();
                        if (tempCargo.size() > 0) {
                            tempCargo.remove(0);
                        }
                        Game.player.getSpaceship().setCargo(tempCargo);
                    }
                    Toast.makeText(getApplicationContext(), events.get(random).getTitle() + "\n" + events.get(random).getDescription(),Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "No encounters",Toast.LENGTH_LONG).show();
                }
                String planetName = (String) planetSpinner.getSelectedItem();
                for (Planet planet : Game.planets) {
                    if(planetName.equals(planet.getName())) {
                        if(Game.player.getSpaceship().getFuel() > Game.calculateFuelPrice(planet)) {
                            if (planet != null) {
                                Game.travel(planet);
                            }
                            location.setText("Location: " + Game.currentPlanet.getName());
                            distance.setText("Distance: " + Game.calculateDistance(planet));
                            fuelCost.setText("Fuel Cost: " + Game.calculateFuelPrice(planet));
                            marketPlace = new MarketPlace(player, currentPlanet.getTechLevel());
                        } else {
                            Toast.makeText(getApplicationContext(),"Not Enough Fuel!",Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });

        final Intent planetScreen = new Intent(this, PlanetScreenActivity.class);
        backButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(planetScreen);
            }
        });

        for (Planet planet : Game.planets) {
            planetNames.add(planet.getName());
        }

        final ArrayAdapter<String> planetsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, planetNames);
        planetsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        planetSpinner.setAdapter(planetsAdapter);

        planetSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String planetName = (String) planetSpinner.getSelectedItem();
                for (Planet planet : Game.planets) {
                    if(planetName.equals(planet.getName())) {
                        distance.setText("Distance: " + Game.calculateDistance(planet));
                        fuelCost.setText("Fuel Cost: " + Game.calculateFuelPrice(planet));
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                distance.setText("Distance: 0");
                fuelCost.setText("Fuel Cost: 0");
            }

        });
    }




}
