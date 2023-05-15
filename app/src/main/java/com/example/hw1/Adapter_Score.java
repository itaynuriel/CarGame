package com.example.hw1;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.color.utilities.Score;
import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;

import com.example.hw1.Adapter_Score;
import com.example.hw1.R;

public class Adapter_Score extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public Adapter_Score(AppCompatActivity activity, ArrayList<com.example.hw1.Utilities.Score> scores) {
    }

    public interface ScoreItemClickListener {
        void locationClicked(Score score);
    }

    private Activity activity;
    private ArrayList<Score> scores;
    private ScoreItemClickListener scoreItemClickListener;

    public Adapter_Score(Activity activity, ArrayList<Score> scores) {
        this.activity = activity;
        this.scores = scores;
    }

    public Adapter_Score setScoreItemClickListener(ScoreItemClickListener scoreItemClickListener) {
        this.scoreItemClickListener = scoreItemClickListener;
        return this;
    }

    @Override
    public RecyclerView.ViewHolder
    onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_score, viewGroup, false);
        return new ScoreViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ScoreViewHolder scoreViewHolder = (ScoreViewHolder) holder;
        Score s = getItem(position);
        scoreViewHolder.score_LBL_rank.setText("" + (position + 1));
//        scoreViewHolder.score_LBL_score.setText("" + s.getScore());
//        if (s.isOnLocation()) {
//            scoreViewHolder.score_IMG_background.setImageResource(R.drawable.background);
//        } else
//            scoreViewHolder.score_IMG_background.setImageResource(R.drawable.background);
    }

    @Override
    public int getItemCount() {
        if (scores == null) return 0;
        return scores.size();
    }

    private Score getItem(int position) {
        return scores.get(position);
    }

    public class ScoreViewHolder extends RecyclerView.ViewHolder {
        public AppCompatImageView score_IMG_location;
        public AppCompatImageView score_IMG_background;
        public MaterialTextView score_LBL_rank;
        public MaterialTextView score_LBL_score;
        public MaterialTextView score_LBL_the_date;


        public ScoreViewHolder(final View itemView) {
            super(itemView);
            this.score_IMG_location = itemView.findViewById(R.id.score_LBL_score);
            this.score_LBL_rank = itemView.findViewById(R.id.score_LBL_rank);
            this.score_LBL_score = itemView.findViewById(R.id.score_LBL_score);
            this.score_IMG_background = itemView.findViewById(R.id.score_IMG_background);

            score_IMG_location.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (scoreItemClickListener != null) {
                        scoreItemClickListener.locationClicked(getItem(getAdapterPosition()));
                    }
                }
            });
        }
    }
}
