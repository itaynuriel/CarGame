package com.example.hw1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.hw1.Utilities.StepCallback;
import com.example.hw1.Utilities.StepDetector;
import com.example.hw1.Utilities.signalGenerator;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textview.MaterialTextView;

import java.util.Random;


public class activity_main extends AppCompatActivity {

    private ShapeableImageView[][] board;
    private final int ROWS = 6;
    private final int COLS = 5;
    private FloatingActionButton arrow_left_btn;
    private FloatingActionButton arrow_right_btn;
    private static int colNum=1;
    private ImageView[] heartArr;
    public static int DELAY;

    public static int game_mode;

    public FloatingActionButton arrow_button;
    private TextView text_counter;
    private int counter = 0;
    private int heartArrayIndex=2;


    private StepDetector stepDetector;


    protected void onCreate(Bundle savedInstanceState)
    {
        Log.d("pttt","onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Fragment fragment = new MapFragment();
//        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout_map,fragment).commit();

        // Disable buttons on sensor mode
        if (2 == game_mode) {
            arrow_button = findViewById(R.id.left_btn);
            arrow_button.setVisibility(View.INVISIBLE);

            arrow_button = findViewById(R.id.right_btn);
            arrow_button.setVisibility(View.INVISIBLE);

            Log.d("pttt","AAAAAAAAAAAAAAAAA");
            initStepDetector();

        }


        findViews();
        initViews();

        text_counter = findViewById(R.id.text_counter);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                counter += 10;
                text_counter.setText(String.valueOf(counter));
                handler.postDelayed(this, DELAY*3);
            }
        }, DELAY*3);
    }

    private void initStepDetector() {
        stepDetector = new StepDetector(this, new StepCallback() {
            @Override
            public void stepX() {
                // TODO
                Log.d("pttt","X: " + stepDetector.getStepsX());
                if (0 == stepDetector.getStepsX()) {
                    moveLeft();
                } else {
                    moveRight();
                }

            }

            @Override
            public void stepY() {
                Log.d("pttt","Y: " + stepDetector.getStepsY());
                DELAY = stepDetector.getStepsY();
            }

            @Override
            public void stepZ() {
            }
        });
        stepDetector.stepCounterY = DELAY;
    }

    private void findViews()
    {
        heartArr=new ImageView[3];
        heartArr[0]=findViewById(R.id.heart1);
        heartArr[1]=findViewById(R.id.heart2);
        heartArr[2]=findViewById(R.id.heart3);

        board=new ShapeableImageView[6][5];

        board[0][0]=findViewById(R.id.rock_0_0);
        board[0][1]=findViewById(R.id.rock_0_1);
        board[0][2]=findViewById(R.id.rock_0_2);
        board[0][3]=findViewById(R.id.rock_0_3);
        board[0][4]=findViewById(R.id.rock_0_4);

        board[1][0]=findViewById(R.id.rock_1_0);
        board[1][1]=findViewById(R.id.rock_1_1);
        board[1][2]=findViewById(R.id.rock_1_2);
        board[1][3]=findViewById(R.id.rock_1_3);
        board[1][4]=findViewById(R.id.rock_1_4);

        board[2][0]=findViewById(R.id.rock_2_0);
        board[2][1]=findViewById(R.id.rock_2_1);
        board[2][2]=findViewById(R.id.rock_2_2);
        board[2][3]=findViewById(R.id.rock_2_3);
        board[2][4]=findViewById(R.id.rock_2_4);

        board[3][0]=findViewById(R.id.rock_3_0);
        board[3][1]=findViewById(R.id.rock_3_1);
        board[3][2]=findViewById(R.id.rock_3_2);
        board[3][3]=findViewById(R.id.rock_3_3);
        board[3][4]=findViewById(R.id.rock_3_4);

        board[4][0]=findViewById(R.id.rock_4_0);
        board[4][1]=findViewById(R.id.rock_4_1);
        board[4][2]=findViewById(R.id.rock_4_2);
        board[4][3]=findViewById(R.id.rock_4_3);
        board[4][4]=findViewById(R.id.rock_4_4);

        board[5][0]=findViewById(R.id.car_5_0);
        board[5][1]=findViewById(R.id.car_5_1);
        board[5][2]=findViewById(R.id.car_5_2);
        board[5][3]=findViewById(R.id.car_5_3);
        board[5][4]=findViewById(R.id.car_5_4);
        arrow_left_btn=findViewById(R.id.left_btn);
        arrow_right_btn=findViewById(R.id.right_btn);


    }
    private void initViews()
    {

        board[5][0].setVisibility(View.INVISIBLE);
        board[5][1].setVisibility(View.INVISIBLE);
        board[5][2].setVisibility(View.VISIBLE);
        board[5][3].setVisibility(View.INVISIBLE);
        board[5][4].setVisibility(View.INVISIBLE);
        for(int i=0;i<ROWS-1;i++)
        {
            for(int j=0;j<COLS;j++)
            {
                board[i][j].setVisibility(View.INVISIBLE);
            }
        }
        arrow_left_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveLeft();
            }
        });
        arrow_right_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveRight();
            }
        });

    }

    private void moveLeft()
    {
        if(colNum==1)
        {
            board[5][0].setVisibility(View.VISIBLE);
            board[5][1].setVisibility(View.INVISIBLE);
            board[5][2].setVisibility(View.INVISIBLE);
            board[5][3].setVisibility(View.INVISIBLE);
            board[5][4].setVisibility(View.INVISIBLE);
            colNum=0;
            return;
        }
        if(colNum==2)
        {
            board[5][0].setVisibility(View.INVISIBLE);
            board[5][1].setVisibility(View.VISIBLE);
            board[5][2].setVisibility(View.INVISIBLE);
            board[5][3].setVisibility(View.INVISIBLE);
            board[5][4].setVisibility(View.INVISIBLE);
            colNum=1;
            return;
        }
        if(colNum==3)
        {
            board[5][0].setVisibility(View.INVISIBLE);
            board[5][1].setVisibility(View.INVISIBLE);
            board[5][2].setVisibility(View.VISIBLE);
            board[5][3].setVisibility(View.INVISIBLE);
            board[5][4].setVisibility(View.INVISIBLE);
            colNum=2;
            return;
        }
        if(colNum==4)
        {
            board[5][0].setVisibility(View.INVISIBLE);
            board[5][1].setVisibility(View.INVISIBLE);
            board[5][2].setVisibility(View.INVISIBLE);
            board[5][3].setVisibility(View.VISIBLE);
            board[5][4].setVisibility(View.INVISIBLE);
            colNum=3;
            return;
        }
        if(colNum==0)
        {
            return;
        }


    }
    private void moveRight()
    {
        if(colNum==1)
        {
            board[5][0].setVisibility(View.INVISIBLE);
            board[5][1].setVisibility(View.INVISIBLE);
            board[5][2].setVisibility(View.VISIBLE);
            board[5][3].setVisibility(View.INVISIBLE);
            board[5][4].setVisibility(View.INVISIBLE);
            colNum=2;
            return;
        }
        if(colNum==0)
        {
            board[5][0].setVisibility(View.INVISIBLE);
            board[5][1].setVisibility(View.VISIBLE);
            board[5][2].setVisibility(View.INVISIBLE);
            board[5][3].setVisibility(View.INVISIBLE);
            board[5][4].setVisibility(View.INVISIBLE);
            colNum=1;
            return;
        }
        if(colNum==2)
        {
            board[5][0].setVisibility(View.INVISIBLE);
            board[5][1].setVisibility(View.INVISIBLE);
            board[5][2].setVisibility(View.INVISIBLE);
            board[5][3].setVisibility(View.VISIBLE);
            board[5][4].setVisibility(View.INVISIBLE);
            colNum=3;
            return;
        }
        if(colNum==3)
        {
            board[5][0].setVisibility(View.INVISIBLE);
            board[5][1].setVisibility(View.INVISIBLE);
            board[5][2].setVisibility(View.INVISIBLE);
            board[5][3].setVisibility(View.INVISIBLE);
            board[5][4].setVisibility(View.VISIBLE);
            colNum=4;
            return;
        }
        if(colNum==4)
            return;

    }


    @Override
    protected void onStart() {
        Log.d("pttt","onStart");
        super.onStart();
        startGame();
    }
    @Override
    protected void onResume() {
        Log.d("pttt","onResume");
        super.onResume();
        stepDetector.start();
    }
    @Override
    protected void onPause() {
        Log.d("pttt","onPause");
        super.onPause();
        stepDetector.stop();
    }

    @Override
    protected void onStop() {
        Log.d("pttt","onStop");
        super.onStop();
        stopGame();
    }
    final Handler handler=new Handler();
    private Runnable runnable=new Runnable() {
        @Override
        public void run() {
            handler.postDelayed(this,DELAY);
            helper();
        }
    };
    private void startGame()
    {
        handler.postDelayed(runnable,DELAY);
    }
    private void stopGame()
    {
        handler.removeCallbacks(runnable);
    }
    private int setRandomObject()
    {
        Random rnd=new Random();
        int colIndex=rnd.nextInt(COLS);
        int randCoin = rnd.nextInt(COLS);
        Log.d("pttt","cIndex = "+colIndex+"is coin: "+isCoin);
        isCoin = randCoin == 3;

        if(isCoin)
        {
            object=R.drawable.coins;
        }
        else
        {
            object=R.drawable.rock;
        }
        for (int i=0; i<ROWS-1 ; i++)
        {
            board[i][colIndex].setImageResource(object);
        }
        board[0][colIndex].setVisibility(View.VISIBLE);
        return colIndex;
    }
    boolean start = true;
    boolean isCoin = false;
    int object = R.drawable.rock;
    int colIndex = 0;
    int rowIndex = 0;
    private void helper()
    {
        if (start)
        {
            board[rowIndex][colIndex].setVisibility(View.INVISIBLE);
            rowIndex = 0;
            colIndex = setRandomObject();
            start = false;
        }
        else
        {
            moveRocks(colIndex);
        }
    }



    private void moveRocks(int colIndex)
    {
        signalGenerator.init(this);

        // note to self!!!
        if (rowIndex < 4) {
            board[rowIndex+1][colIndex].setVisibility(View.VISIBLE);
        }
        board[rowIndex++][colIndex].setVisibility(View.INVISIBLE);
        if (rowIndex == 4) {
            start = true;
        }
        if(heartArrayIndex<0)
        {
            Toast.makeText(activity_main.this, "X-GAME OVER-X", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(activity_main.this,activity_leaderboard.class);
            startActivity(intent);
            finish();
            stopGame();
        }
        for (int i=0; i<COLS; i++)
        {
            if(board[ROWS-1][i].getVisibility()==View.VISIBLE && board[ROWS-2][i].getVisibility()==View.VISIBLE)
            {
                if(isCoin) {
                    counter+=100;
                }
                else {
                    signalGenerator.getInstance().vibrate(500);
                    signalGenerator.getInstance().playSound();
                    signalGenerator.getInstance().toast("Accident Occured! ", Toast.LENGTH_SHORT);
                    heartArr[heartArrayIndex].setVisibility(View.INVISIBLE);
                    heartArrayIndex--;
                }
            }
        }

    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        Log.d("pttt","onState");
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onDestroy() {
        Log.d("pttt","onDestroy");
        super.onDestroy();
    }

}
