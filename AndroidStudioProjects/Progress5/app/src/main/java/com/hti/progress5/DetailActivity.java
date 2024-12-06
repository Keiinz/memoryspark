package com.hti.progress5;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Ambil skor dari Intent
        int score = getIntent().getIntExtra("score", 0);

        // Tampilkan skor
        TextView textScore = findViewById(R.id.textQuestionDetail);
        textScore.setText("Your score: " + score);
    }
}
