package com.example.memoryspark;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.memoryspark.databinding.ActivityStarterBinding;

public class StarterActivity extends AppCompatActivity {

    private ActivityStarterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityStarterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setListeners();
    }

    private void setListeners() {
        binding.btnOpenDeck.setOnClickListener(v -> {
            startActivity(new Intent(this, MainActivity.class));
        });

        binding.btnStartTest.setOnClickListener(v -> {
            Toast.makeText(this, "Start Test Clicked!", Toast.LENGTH_SHORT).show();
        });

        binding.btnHistoryTest.setOnClickListener(v -> {
            Toast.makeText(this, "History Test Clicked!", Toast.LENGTH_SHORT).show();
        });
    }
}