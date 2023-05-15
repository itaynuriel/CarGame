package com.example.hw1;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hw1.Utilities.Score;

import java.util.ArrayList;
import java.util.Collections;


public class activity_leaderboard extends AppCompatActivity {
    private FragmentRanks fragmentRanks;

    private ArrayList<Score> scores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_leaderboard);

        scores = new ArrayList<>();

        fragmentRanks = new FragmentRanks();
        fragmentRanks.setActivity(this);
        fragmentRanks.setCallBackRanks(callBackRanks);
        getSupportFragmentManager().beginTransaction().add(R.id.leaderboard_fragment_ranks, fragmentRanks).commit();

    }

    FragmentRanks.CallBack_Ranks callBackRanks = new FragmentRanks.CallBack_Ranks() {
        @Override
        public void clicked(Score score) {
            double latitude = score.getLatitude();
            double longitude = score.getLongitude();
//            fragmentMap.setLocation(latitude, longitude);
        }
    };

}
