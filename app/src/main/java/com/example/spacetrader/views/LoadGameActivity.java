package com.example.spacetrader.views;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.spacetrader.R;
import com.example.spacetrader.entity.Game;
import com.example.spacetrader.entity.Planet;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class LoadGameActivity extends AppCompatActivity {

    private Spinner userSpinner;
    private Button loadButton;
    private ArrayList<String> users = new ArrayList<>();
    ArrayAdapter<String> usersAdapter;
    private String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_game);

        userSpinner = findViewById(R.id.userSpinner);
        loadButton = findViewById(R.id.loadButton);
        final Context context = this.getApplicationContext();

        final FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("players")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d("TAG", document.getId() + " => " + document.getData());
                                users.add(document.getId());
                            }
                        } else {
                            Log.d("TAG", "Error getting documents: ", task.getException());
                        }
                        usersAdapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, users);
                        usersAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        userSpinner.setAdapter(usersAdapter);
                    }
                });


        userSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                userName = (String) userSpinner.getSelectedItem();
                loadButton.setEnabled(true);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                loadButton.setEnabled(false);
            }

        });

        final Intent gameIntent = new Intent(this, PlanetScreenActivity.class);
        gameIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        loadButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Game.loadPlayer(userName, context, gameIntent);
            }
        });
    }
}
