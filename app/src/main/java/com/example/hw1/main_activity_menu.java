package com.example.hw1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class main_activity_menu extends AppCompatActivity {

    private Button slowButtonGameMode;
    private Button buttonGameMode;
    private Button buttonSensorsMode;
    private Button leaderboardButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        slowButtonGameMode= findViewById(R.id.main_menu_BTN_SlowButtonGameMode);
        buttonGameMode= findViewById(R.id.main_menu_BTN_ButtonGameMode);
        buttonSensorsMode= findViewById(R.id.main_menu_BTN_SensorsGameMode);
        leaderboardButton= findViewById(R.id.main_menu_BTN_Leaderboard);

        slowButtonGameMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity_main.DELAY=1000;
                Intent intent = new Intent(main_activity_menu.this,activity_main.class);
                startActivity(intent);
                finish();
            }
        });
        buttonGameMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity_main.DELAY=600;
                Intent intent = new Intent(main_activity_menu.this,activity_main.class);
                startActivity(intent);
                finish();
            }
        });

        buttonSensorsMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(main_activity_menu.this,activity_main_sensorsMode.class);
                startActivity(intent);
                finish();
            }
        });

        leaderboardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(main_activity_menu.this,activity_leaderboard.class);
                startActivity(intent);
                finish();
            }
        });

    }



}