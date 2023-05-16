package com.example.hw1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hw1.Utilities.Score;

import java.util.ArrayList;
import java.util.Collections;


public class activity_leaderboard extends AppCompatActivity {
    private FragmentRanks fragmentRanks;
    private MapFragment fragmentMap;
    private Button backButton;

    private RecyclerView main_LST_Scores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_leaderboard);
        backButton = findViewById(R.id.back_Button);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_leaderboard.this, main_activity_menu.class);
                startActivity(intent);
                finish();
            }
        });


        fragmentRanks = new FragmentRanks();
        fragmentRanks.setActivity(this);
        fragmentRanks.setCallBackRanks(callBackRanks);
        getSupportFragmentManager().beginTransaction().add(R.id.leaderboard_fragment_ranks, fragmentRanks).commit();

        fragmentMap = new MapFragment();
        fragmentMap.setActivity(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.leaderboard_fragment_map, fragmentMap).commit();
    }

    FragmentRanks.CallBack_Ranks callBackRanks = new FragmentRanks.CallBack_Ranks() {
        @Override
        public void clicked(Score score) {
            double latitude = score.getLatitude();
            double longitude = score.getLongitude();
            fragmentMap.setLocation(latitude, longitude);
            Log.d("pttt", "HIIII");
        }
    };

}
