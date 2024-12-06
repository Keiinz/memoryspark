package com.hti.progress5;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Question.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {
    // Singleton instance
    private static AppDatabase instance;

    // DAO
    public abstract QuestionDAO questionDao();

    // Membuat instance database
    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "question_database")
                    .fallbackToDestructiveMigration() // Untuk menghindari crash saat skema berubah
                    .build();
        }
        return instance;
    }
}

