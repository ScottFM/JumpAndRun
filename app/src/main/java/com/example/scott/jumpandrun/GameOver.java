package com.example.scott.jumpandrun;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Scott on 3/22/2017.
 */

public class GameOver extends AppCompatActivity implements View.OnClickListener {

    TextView tFinalScore;
    TextView tBestScore;
    Button bRetry;

    SharedPreferences sharedScores;
    SharedPreferences.Editor scoresEditor;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameover);

        tFinalScore = (TextView) findViewById(R.id.txtFinalScoreVal);
        tBestScore = (TextView) findViewById(R.id.txtBestScoreVal);
        bRetry = (Button) findViewById(R.id.btnRetry);
        bRetry.setOnClickListener(this);

        sharedScores = getSharedPreferences("scores", 0);
        scoresEditor = sharedScores.edit();

        int score = sharedScores.getInt("score", 0);
        int best = sharedScores.getInt("best", 0);
        tFinalScore.setText(String.valueOf(score));
        tBestScore.setText(String.valueOf(best));
    }


    @Override
    public void onClick(View v) {
        Intent I = new Intent("com.example.Scott.JumpAndRun.Main");
        startActivity(I);
        finish();

    }
}
