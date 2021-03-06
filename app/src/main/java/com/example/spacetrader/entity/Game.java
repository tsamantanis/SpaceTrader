package com.example.spacetrader.entity;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.example.spacetrader.model.MarketPlace;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.content.ContentValues.TAG;

public class Game {
    public static Player player;
    public static List<Planet> planets;
    public static MarketPlace marketPlace;
    public static String playerID;

    public Game() {}

    public static void createPlayer(String name, int[] skillDistribution, String difficulty) {
        player = new Player(name, skillDistribution, difficulty);
        generateUniverse();
        player.setCurrentPlanet(planets.get(3));
        marketPlace = new MarketPlace(player, player.getCurrentPlanet().getTechLevel());

        savePlayer(null);

//        final FirebaseFirestore db = FirebaseFirestore.getInstance();
//        db.collection("players")
//                .add(player)
//                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
//                    @Override
//                    public void onSuccess(DocumentReference documentReference) {
//                        playerID = documentReference.getId();
//                        db.collection("players").document(playerID).update(
//                                "currentPlanet", currentPlanet
//                        );
//                        Log.d(TAG, "DocumentSnapshot added with ID: " + playerID);
//                    }
//                })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Log.w(TAG, "Error adding document", e);
//                    }
//                });
    }

    public static void savePlayer(final Context context) {
        final FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("players")
                .document(Game.player.getName())
                .set(Game.player)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
//                        db.collection("players").document(Game.player.getName()).update(
//                                "currentPlanet", player.getCurrentPlanet()
//                        );
                        Log.d("TAG", "DocumentSnapshot successfully written!");
                        if (context != null) Toast.makeText(context, "Game saved", Toast.LENGTH_LONG).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("TAG", "Error writing document", e);
                        if (context != null) Toast.makeText(context, "Game failed to saved", Toast.LENGTH_LONG).show();
                    }
                });
    }

    public static void loadPlayer(String name, final Context context, final Intent intent) {
        generateUniverse();
        final FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("players")
                .whereEqualTo("name", name)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData());
                                player = document.toObject(Player.class);
                                marketPlace = new MarketPlace(player, player.getCurrentPlanet().getTechLevel());
                                context.startActivity(intent);
                            }
                        } else {
                            Log.d(TAG, "Error getting documents: ", task.getException());
                        }
                    }
                });
    }

    public static void generateUniverse() {
        planets = new ArrayList<>();
        planets.add(new Planet("Aegon", 10, 130));
        planets.add(new Planet("Aldea", 55, 35));
        planets.add(new Planet("Brax", 25, 75));
        planets.add(new Planet("Castor", 65, 110));
        planets.add(new Planet("Daenerys", 50, 70));
        planets.add(new Planet("Davlos", 35, 85));
        planets.add(new Planet("Fourmi", 55, 135));
        planets.add(new Planet("Kafka", 75, 45));
        planets.add(new Planet("Rhaegon", 20, 40));
        planets.add(new Planet("Zuul", 8, 15));
    }

    public static int calculateDistance(Planet planet) {
        return (int) Math.sqrt(Math.pow(planet.getX() - player.getCurrentPlanet().getX(), 2) + Math.pow(planet.getY() - player.getCurrentPlanet().getY(), 2));
    }

    public static int calculateFuelPrice(Planet planet) {
        return (int) (calculateDistance(planet) * 3.5);
    }

    public static void travel(Planet planet) {
        int currentFuel = player.getSpaceship().getFuel();
        player.getSpaceship().setFuel(currentFuel - calculateFuelPrice(planet));
        player.setCurrentPlanet(planet);
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

}
