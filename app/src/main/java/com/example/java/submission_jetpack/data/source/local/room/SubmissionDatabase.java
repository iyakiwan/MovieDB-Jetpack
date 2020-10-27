package com.example.java.submission_jetpack.data.source.local.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.java.submission_jetpack.data.source.local.entitiy.MovieTvEntity;

@Database(entities = {MovieTvEntity.class}, version = 1)
public abstract class SubmissionDatabase extends RoomDatabase {
    public abstract SubmissionDao submissionDao();

    private static volatile SubmissionDatabase INSTANCE;

    public static SubmissionDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (SubmissionDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            SubmissionDatabase.class, "Submission.db")
                            .build();
                }

            }
        }
        return INSTANCE;
    }
}
