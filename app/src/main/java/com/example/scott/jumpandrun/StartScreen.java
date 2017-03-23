package com.example.scott.jumpandrun;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Scott on 3/22/2017.
 */

public class StartScreen extends AppCompatActivity implements View.OnClickListener{

    TextView tHighScore;
    Button bStart;
    SharedPreferences sharedScores;
    SharedPreferences.Editor scoresEditor;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startscreen);
        tHighScore = (TextView) findViewById(R.id.txtHighScoreValue);
        bStart = (Button) findViewById(R.id.btnStart);
        bStart.setOnClickListener(this);

        sharedScores = getSharedPreferences("scores", 0);
        scoresEditor = sharedScores.edit();
        int best = sharedScores.getInt("best", 0);
        tHighScore.setText(String.valueOf(best));
    }
    @Override
    public void onClick(View v) {
        Intent I = new Intent("com.example.Scott.JumpAndRun.Main");
        startActivity(I);
        finish();
    }
}
