package com.example.java.submission_jetpack.data.source.remote;

import androidx.lifecycle.MutableLiveData;

import com.example.java.submission_jetpack.data.source.remote.response.movie.DetailMovieResponse;
import com.example.java.submission_jetpack.data.source.remote.response.movie.MovieResponse;
import com.example.java.submission_jetpack.data.source.remote.response.tv.DetailTvShowResponse;
import com.example.java.submission_jetpack.data.source.remote.response.tv.TvShowResponse;
import com.example.java.submission_jetpack.utils.ApiHelper;

import java.util.List;

public class RemoteDataSource {
    private static RemoteDataSource INSTANCE;
    private ApiHelper apiHelper;

    private RemoteDataSource(ApiHelper apiHelper) {
        this.apiHelper = apiHelper;
    }

    public static RemoteDataSource getInstance(ApiHelper helper) {
        if (INSTANCE == null) {
            INSTANCE = new RemoteDataSource(helper);
        }
        return INSTANCE;
    }

    public void getMovie(MutableLiveData<List<MovieResponse>> liveData) {
        apiHelper.getMovie(liveData);
    }

    public void getDetailMovie(MutableLiveData<DetailMovieResponse> liveData, String movieTv) {
        apiHelper.getDetailMovie(liveData, movieTv);
    }

    public void getTvShow(MutableLiveData<List<TvShowResponse>> liveData) {
        apiHelper.getTvShow(liveData);
    }

    public void getDetailTvShow(MutableLiveData<DetailTvShowResponse> liveData, String tvId) {
        apiHelper.getDetailTvShow(liveData, tvId);
    }
}
