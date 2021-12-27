package com.example.countcouter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityBasketCourtCounter extends AppCompatActivity implements View.OnClickListener {

    private TextView twoPointA;
    private TextView threePointA;
    private TextView freeThrowA;
    private TextView teamScoreA;
    private TextView twoPointB;
    private TextView threePointB;
    private TextView freeThrowB;
    private TextView teamScoreB;
    private Button clear;
    private Button back;
    private int constant = 0;

    //variables for saving points during the basketball match
    int[] points = new int[100];
    int[] team = new int[100];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basketcounter);

        twoPointA = findViewById(R.id.point02_A);
        threePointA = findViewById(R.id.point03_A);
        freeThrowA = findViewById(R.id.freeThrow_A);
        teamScoreA = findViewById(R.id.teamA_score);
        twoPointB = findViewById(R.id.point02_B);
        threePointB = findViewById(R.id.point03_B);
        freeThrowB = findViewById(R.id.freeThrow_B);
        teamScoreB = findViewById(R.id.teamB_score);

        TextView[] points = new TextView[]{twoPointA, threePointA, freeThrowA, twoPointB, threePointB, freeThrowB};
        for(TextView text: points){
            text.setOnClickListener(this);
        }

        clear = findViewById(R.id.clear_score);
        clear.setOnClickListener(view -> {
            teamScoreA.setText("0");
            teamScoreB.setText("0");
            constant = 0;
        });
        back = findViewById(R.id.previous_score);
        back.setOnClickListener(view -> removeScore());
    }

    //function to remove previous score
    private void removeScore() {
        if(constant > 0){
            constant--;
        }
        int score;
        if (!teamScoreA.getText().toString().equals("0") || !teamScoreB.getText().toString().equals("0")) {
            if(team[constant] == 1){
                score = Integer.parseInt(teamScoreA.getText().toString()) - points[constant];
                teamScoreA.setText(String.valueOf(score));
            }else if(team[constant] == 2){
                score = Integer.parseInt(teamScoreB.getText().toString()) - points[constant];
                teamScoreB.setText(String.valueOf(score));
            }
        }
    }

    private void addPoint(TextView point){
        int basketNumber;
        int scoreA = Integer.parseInt(teamScoreA.getText().toString());
        int scoreB = Integer.parseInt(teamScoreB.getText().toString());

        if(point == twoPointA){
            basketNumber = 2 + scoreA;
            teamScoreA.setText(String.valueOf(basketNumber));

            //saving of score
            team[constant] = 1;
            points[constant] = 2;
            constant++;
        }else if(point == threePointA){
            basketNumber = 3 + scoreA;
            teamScoreA.setText(String.valueOf(basketNumber));

            //saving of score
            points[constant] = 3;
            team[constant] = 1;
            constant++;
        }else if(point == freeThrowA){
            basketNumber = 1 + scoreA;
            teamScoreA.setText(String.valueOf(basketNumber));

            //saving of score
            team[constant] = 1;
            points[constant] = 1;
            constant++;
        }else if(point == twoPointB){
            basketNumber = 2 + scoreB;
            teamScoreB.setText(String.valueOf(basketNumber));

            //saving of score
            team[constant] = 2;
            points[constant] = 2;
            constant++;
        }else if(point == threePointB){
            basketNumber = 3 + scoreB;
            teamScoreB.setText(String.valueOf(basketNumber));

            //saving of score
            team[constant] = 2;
            points[constant] = 3;
            constant++;
        }else if(point == freeThrowB){
            basketNumber = 1 + scoreB;
            teamScoreB.setText(String.valueOf(basketNumber));

            //saving of score
            team[constant] = 2;
            points[constant] = 1;
            constant++;
        }
    }

    @Override
    public void onClick(View view) {
        addPoint((TextView) view);
    }
}