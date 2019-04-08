package com.example.spacetrader.entity;

import android.support.annotation.NonNull;
import android.util.Log;

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
    public static Planet currentPlanet;
    public static List<Planet> planets;
    public static MarketPlace marketPlace;

    public static void createPlayer(String name, int[] skillDistribution, String difficulty) {
        player = new Player(name, skillDistribution, difficulty);
        marketPlace = new MarketPlace(player, currentPlanet.getTechLevel());
        savePlayer();
    }

    private static void savePlayer() {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
//        Map<String, String> player = new HashMap<>();
//        player.put("name", this.player.getName());
//        player.put("skills", this.player.getSkillDistribution().toString());
//        player.put("difficulty", this.player.getDifficulty());
//        player.put("credits", this.player.getCredits() + "");
//        player.put("weapon", this.player.getWeapon());
//        player.put("spaceship")

        db.collection("players")
                .add(player)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
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
        currentPlanet = planets.get(3);
    }

    public static int calculateDistance(Planet planet) {
        return (int) Math.sqrt(Math.pow(planet.getX() - currentPlanet.getX(), 2) + Math.pow(planet.getY() - currentPlanet.getY(), 2));
    }

    public static int calculateFuelPrice(Planet planet) {
        return (int) (calculateDistance(planet) * 3.5);
    }

    public static void travel(Planet planet) {
        int currentFuel = player.getSpaceship().getFuel();
        player.getSpaceship().setFuel(currentFuel - calculateFuelPrice(planet));
        currentPlanet = planet;
    }



}
