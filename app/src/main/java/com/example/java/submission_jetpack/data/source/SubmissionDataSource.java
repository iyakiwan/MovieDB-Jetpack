package com.example.java.submission_jetpack.data.source;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;

import com.example.java.submission_jetpack.data.source.local.entitiy.MovieTvEntity;
import com.example.java.submission_jetpack.data.source.remote.response.movie.DetailMovieResponse;
import com.example.java.submission_jetpack.data.source.remote.response.movie.MovieResponse;
import com.example.java.submission_jetpack.data.source.remote.response.tv.DetailTvShowResponse;
import com.example.java.submission_jetpack.data.source.remote.response.tv.TvShowResponse;

import java.util.List;

public interface SubmissionDataSource {
    void getAllMovie(MutableLiveData<List<MovieResponse>> liveData);

    void getAllTvShow(MutableLiveData<List<TvShowResponse>> liveData);

    void getDetailMovie(MutableLiveData<DetailMovieResponse> liveData, String movieId);

    void getDetailTvShow(MutableLiveData<DetailTvShowResponse> liveData, String tvId);

    void insertShow(MovieTvEntity show);

    void deleteShow(MovieTvEntity show);

    DataSource.Factory<Integer, MovieTvEntity> getShowMovies();

    DataSource.Factory<Integer, MovieTvEntity> getShowTvs();

    LiveData<MovieTvEntity> getShowById(String showId);
}
