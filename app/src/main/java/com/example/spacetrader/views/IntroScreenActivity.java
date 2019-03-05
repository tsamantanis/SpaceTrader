package com.example.spacetrader.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.spacetrader.R;

import static com.example.spacetrader.views.MainActivity.createPlayer;

public class IntroScreenActivity extends AppCompatActivity {
    private Spinner pilotSpinner;
    private Spinner fighterSpinner;
    private Spinner traderSpinner;
    private Spinner engineerSpinner;
    private Spinner difficultySpinner;

    private TextView invalid;

    private EditText name;

    private String[] pointsArray = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "11", "12", "13", "14", "15", "16"};

    private String[] difficultyArray = {"Beginner","Easy", "Medium", "Hard", "Impossible"};

    private int[] skillDis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro_screen);

        pilotSpinner = findViewById(R.id.pilotSpinner);
        fighterSpinner = findViewById(R.id.fighterSpinner);
        traderSpinner = findViewById(R.id.traderSpinner);
        engineerSpinner = findViewById(R.id.engineerSpinner);
        difficultySpinner = findViewById(R.id.difficultySpinner);

        invalid = findViewById(R.id.invalid);

        name = findViewById(R.id.editName);

        skillDis = new int[4];


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, pointsArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> difficultyAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, difficultyArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        pilotSpinner.setAdapter(adapter);
        fighterSpinner.setAdapter(adapter);
        traderSpinner.setAdapter(adapter);
        engineerSpinner.setAdapter(adapter);

        difficultySpinner.setAdapter(difficultyAdapter);

        final Button submit = findViewById(R.id.submit);
        final Intent loadingIntent = new Intent(this, GenerateUniverseActivity.class);

        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                skillDis[0] = Integer.parseInt((String) pilotSpinner.getSelectedItem());
                skillDis[1] = Integer.parseInt((String) fighterSpinner.getSelectedItem());
                skillDis[2] = Integer.parseInt((String) traderSpinner.getSelectedItem());
                skillDis[3] = Integer.parseInt((String) engineerSpinner.getSelectedItem());
                if(skillDis[0] + skillDis[1] + skillDis[2] + skillDis[3] != 16) {
                    invalid.setText("Points improperly assigned.");
                } else {
                    invalid.setText("");
                    createPlayer(name.getText().toString(), skillDis, (String) difficultySpinner.getSelectedItem());
                }
                startActivity(loadingIntent);
            }
        });
    }
}
