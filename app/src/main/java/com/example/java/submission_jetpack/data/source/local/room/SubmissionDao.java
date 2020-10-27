package com.example.java.submission_jetpack.data.source.local.room;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.java.submission_jetpack.data.source.local.entitiy.MovieTvEntity;

@Dao
public interface SubmissionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertShow(MovieTvEntity show);

    @Delete()
    void deleteShow(MovieTvEntity note);

    @Query("SELECT * FROM show where show = 'movie'")
    DataSource.Factory<Integer, MovieTvEntity> getShowMovies();

    @Query("SELECT * FROM show where show = 'tv'")
    DataSource.Factory<Integer, MovieTvEntity> getShowTvs();

    @Query("SELECT * FROM show WHERE id = :showId")
    LiveData<MovieTvEntity> getShowById(String showId);
}
