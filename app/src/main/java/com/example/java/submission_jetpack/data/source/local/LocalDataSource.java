package com.example.java.submission_jetpack.data.source.local;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;

import com.example.java.submission_jetpack.data.source.local.entitiy.MovieTvEntity;
import com.example.java.submission_jetpack.data.source.local.room.SubmissionDao;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LocalDataSource {
    private static LocalDataSource INSTANCE;
    private final SubmissionDao mSubmissionDao;
    private ExecutorService executorService;

    private LocalDataSource(SubmissionDao mSubmissionDao) {
        executorService = Executors.newSingleThreadExecutor();
        this.mSubmissionDao = mSubmissionDao;
    }

    public static LocalDataSource getInstance(SubmissionDao submissionDao) {
        if (INSTANCE == null) {
            INSTANCE = new LocalDataSource(submissionDao);
        }
        return INSTANCE;
    }

    public void insertShow(MovieTvEntity show) {
        executorService.execute(() -> mSubmissionDao.insertShow(show));
    }

    public void deleteShow(MovieTvEntity show) {
        executorService.execute(() -> mSubmissionDao.deleteShow(show));
    }

    public DataSource.Factory<Integer, MovieTvEntity> getShowMovies() {
        return mSubmissionDao.getShowMovies();
    }

    public DataSource.Factory<Integer, MovieTvEntity> getShowTvs() {
        return mSubmissionDao.getShowTvs();
    }

    public LiveData<MovieTvEntity> getShowById(String showId) {
        return mSubmissionDao.getShowById(showId);
    }
}
