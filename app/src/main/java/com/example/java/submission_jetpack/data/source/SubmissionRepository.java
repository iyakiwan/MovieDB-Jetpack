package com.example.java.submission_jetpack.data.source;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.java.submission_jetpack.data.source.remote.RemoteDataSource;
import com.example.java.submission_jetpack.data.source.remote.response.movie.DetailMovieResponse;
import com.example.java.submission_jetpack.data.source.remote.response.movie.MovieResponse;
import com.example.java.submission_jetpack.data.source.remote.response.tv.DetailTvShowResponse;
import com.example.java.submission_jetpack.data.source.remote.response.tv.TvShowResponse;

import java.util.List;

public class SubmissionRepository implements SubmissionDataSource {
    private volatile static SubmissionRepository INSTANCE = null;
    private final RemoteDataSource remoteDataSource;

    private SubmissionRepository(@NonNull RemoteDataSource remoteDataSource) {
        this.remoteDataSource = remoteDataSource;
    }

    public static SubmissionRepository getInstance(RemoteDataSource remoteData) {
        if (INSTANCE == null) {
            synchronized (SubmissionRepository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new SubmissionRepository(remoteData);
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
}
