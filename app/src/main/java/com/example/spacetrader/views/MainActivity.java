package com.example.spacetrader.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.spacetrader.R;

public class MainActivity extends AppCompatActivity {

    private Button newGameButton, loadGameButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newGameButton = findViewById(R.id.newGameButton);
        loadGameButton = findViewById(R.id.loadGameButton);

        final Intent newGameIntent = new Intent(this, IntroScreenActivity.class);
        final Intent loadGameIntent = new Intent(this, LoadGameActivity.class);
        newGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(newGameIntent);
            }
        });

        loadGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(loadGameIntent);
            }
        });
    }
}
