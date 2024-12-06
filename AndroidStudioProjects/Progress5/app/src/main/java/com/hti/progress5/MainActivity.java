package com.hti.progress5;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private QuestionAdapter adapter;
    private AppDatabase database;
    private QuestionDAO questionDao;
    private Button buttonFinish;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inisialisasi RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new QuestionAdapter(this::onOptionSelected); // Listener untuk opsi
        recyclerView.setAdapter(adapter);

        // Inisialisasi Tombol Selesai
        buttonFinish = findViewById(R.id.buttonFinish);
        buttonFinish.setOnClickListener(v -> finishQuiz());

        // Inisialisasi Database
        database = AppDatabase.getInstance(this);
        questionDao = database.questionDao();

        // Muat pertanyaan dari database
        loadQuestions();
    }

    private void loadQuestions() {
        new Thread(() -> {
            List<Question> questions = questionDao.getAllQuestions();
            runOnUiThread(() -> {
                if (questions.isEmpty()) {
                    Toast.makeText(this, "No questions available", Toast.LENGTH_SHORT).show();
                } else {
                    adapter.setData(questions);
                }
            });
        }).start();
    }

    private void onOptionSelected(Question question, String selectedOption) {
        if (selectedOption.equals(question.getCorrectAnswer())) {
            score++; // Tambahkan skor jika jawaban benar
        }
    }

    private void finishQuiz() {
        // Pindah ke DetailActivity untuk menampilkan skor
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        intent.putExtra("score", score);
        startActivity(intent);
    }
}
