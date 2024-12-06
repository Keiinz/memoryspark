package com.hti.progress5;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface QuestionDAO {
    // Menambahkan satu pertanyaan
    @Insert
    void insertQuestion(Question question);

    // Menambahkan banyak pertanyaan (data dummy)
    @Insert
    void insertQuestions(List<Question> questions);

    // Mengambil semua pertanyaan
    @Query("SELECT * FROM question_table")
    List<Question> getAllQuestions();

    // Mengupdate pertanyaan
    @Update
    void updateQuestion(Question question);

    // Menghapus pertanyaan tertentu
    @Delete
    void deleteQuestion(Question question);

    // Menghapus semua pertanyaan
    @Query("DELETE FROM question_table")
    void deleteAllQuestions();
}

