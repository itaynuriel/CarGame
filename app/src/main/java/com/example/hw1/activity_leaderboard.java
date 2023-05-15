package com.example.hw1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.hw1.Utilities.Score;

import java.util.ArrayList;

public class activity_leaderboard extends AppCompatActivity {

    private Button backButton;

    private FragmentRanks fragmentRanks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);


        fragmentRanks = new FragmentRanks();
        fragmentRanks.setActivity(this);
//        fragmentRanks.setCallBackRanks(callBackRanks);
        getSupportFragmentManager().beginTransaction().add(R.id.leaderboard_fragment_ranks, fragmentRanks).commit();


        backButton= findViewById(R.id.back_Button);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_leaderboard.this,main_activity_menu.class);
                ArrayList<Score> scores = new ArrayList<>();
                for (int i = 0; i < 5; i++) {
                    scores.add(new Score(i, true, 0, 0));
                }
                fragmentRanks.setScores(scores);
//                startActivity(intent);
            }
        });
    }
}