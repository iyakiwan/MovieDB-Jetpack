package com.example.java.submission_jetpack.data.source;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;

import com.example.java.submission_jetpack.data.source.local.LocalDataSource;
import com.example.java.submission_jetpack.data.source.local.entitiy.MovieTvEntity;
import com.example.java.submission_jetpack.data.source.remote.RemoteDataSource;
import com.example.java.submission_jetpack.data.source.remote.response.movie.DetailMovieResponse;
import com.example.java.submission_jetpack.data.source.remote.response.movie.MovieResponse;
import com.example.java.submission_jetpack.data.source.remote.response.tv.DetailTvShowResponse;
import com.example.java.submission_jetpack.data.source.remote.response.tv.TvShowResponse;

import java.util.List;

public class SubmissionRepository implements SubmissionDataSource {
    private volatile static SubmissionRepository INSTANCE = null;
    private final RemoteDataSource remoteDataSource;
    private final LocalDataSource localDataSource;

    private SubmissionRepository(@NonNull RemoteDataSource remoteDataSource, @NonNull LocalDataSource localDataSource) {
        this.remoteDataSource = remoteDataSource;
        this.localDataSource = localDataSource;
    }

    public static SubmissionRepository getInstance(RemoteDataSource remoteData, LocalDataSource localDataSource) {
        if (INSTANCE == null) {
            synchronized (SubmissionRepository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new SubmissionRepository(remoteData, localDataSource);
                }
            }
        }
        return INSTANCE;
    }
    @Override
    public void getAllMovie(MutableLiveData<List<MovieResponse>> liveData){
        remoteDataSource.getMovie(liveData);
    }

    @Override
    public void  getAllTvShow(MutableLiveData<List<TvShowResponse>> liveData) {
        remoteDataSource.getTvShow(liveData);
    }

    @Override
    public void getDetailMovie(MutableLiveData<DetailMovieResponse> liveData, String movieId){
        remoteDataSource.getDetailMovie(liveData, movieId);
    }

    @Override
    public void getDetailTvShow(MutableLiveData<DetailTvShowResponse> liveData, String tvId){
        remoteDataSource.getDetailTvShow(liveData, tvId);
    }

    @Override
    public void insertShow(MovieTvEntity show) {
        localDataSource.insertShow(show);
    }

    @Override
    public void deleteShow(MovieTvEntity show) {
        localDataSource.deleteShow(show);
    }

    @Override
    public DataSource.Factory<Integer, MovieTvEntity> getShowMovies() {
        return localDataSource.getShowMovies();
    }

    @Override
    public DataSource.Factory<Integer, MovieTvEntity> getShowTvs() {
        return localDataSource.getShowTvs();
    }

    @Override
    public LiveData<MovieTvEntity> getShowById(String showId) {
        return localDataSource.getShowById(showId);
    }
}
