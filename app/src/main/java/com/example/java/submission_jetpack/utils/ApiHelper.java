package com.example.java.submission_jetpack.utils;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.java.submission_jetpack.data.source.remote.response.movie.DetailMovieResponse;
import com.example.java.submission_jetpack.data.source.remote.response.movie.ListMovieResponse;
import com.example.java.submission_jetpack.data.source.remote.response.movie.MovieResponse;
import com.example.java.submission_jetpack.data.source.remote.response.tv.DetailTvShowResponse;
import com.example.java.submission_jetpack.data.source.remote.response.tv.ListTvShowResponse;
import com.example.java.submission_jetpack.data.source.remote.response.tv.TvShowResponse;
import com.example.java.submission_jetpack.network.ApiClient;
import com.example.java.submission_jetpack.network.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiHelper {
    private static final String LANGUAGE = "en-US";
    private static final String API_KEY = "7b4a111dae6877683996f90a8ea25891";
    private static final String PAGE = "1";

    private ApiInterface service = ApiClient.getRetrofitInstance().create(ApiInterface.class);

    public void getMovie(MutableLiveData<List<MovieResponse>> liveDataMovie) {
        EspressoIdlingResource.increment();

        Call<ListMovieResponse> call = service.getDataMovie(API_KEY, LANGUAGE, PAGE);
        call.enqueue(new Callback<ListMovieResponse>() {
            @Override
            public void onResponse(@NonNull Call<ListMovieResponse> call, @NonNull Response<ListMovieResponse> response) {
                if (response.isSuccessful()) {
                    ListMovieResponse listMovieResponse = response.body();
                    if (listMovieResponse != null && listMovieResponse.getResults() != null) {
                        liveDataMovie.postValue(listMovieResponse.getResults());
                    } else {
                        Log.d("ApiCall", "Empty Data Movie");
                    }
                }
                EspressoIdlingResource.decrement();
            }

            @Override
            public void onFailure(@NonNull Call<ListMovieResponse> call, @NonNull Throwable t) {
                Log.d("ApiCall", "Failure Data Movie");
                EspressoIdlingResource.decrement();
            }
        });
    }

    public void getDetailMovie(MutableLiveData<DetailMovieResponse> liveData, String id) {
        EspressoIdlingResource.increment();

        Call<DetailMovieResponse> call = service.getDetailMovie(id,API_KEY, LANGUAGE);
        call.enqueue(new Callback<DetailMovieResponse>() {
            @Override
            public void onResponse(@NonNull Call<DetailMovieResponse> call, @NonNull Response<DetailMovieResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        DetailMovieResponse mDetailMovieResponse = response.body();
                        liveData.postValue(mDetailMovieResponse);
                    } else {
                        Log.d("ApiCall", "Empty Data Detail Movie");
                    }
                }
                EspressoIdlingResource.decrement();
            }

            @Override
            public void onFailure(@NonNull Call<DetailMovieResponse> call, @NonNull Throwable t) {
                Log.d("ApiCall", "Failure Data Detail Movie");
                EspressoIdlingResource.decrement();
            }
        });
    }

    public void getTvShow(MutableLiveData<List<TvShowResponse>> liveDataTvShow) {
        EspressoIdlingResource.increment();

        Call<ListTvShowResponse> call = service.getDataTvShow(API_KEY, LANGUAGE, PAGE);
        call.enqueue(new Callback<ListTvShowResponse>() {
            @Override
            public void onResponse(@NonNull Call<ListTvShowResponse> call, @NonNull Response<ListTvShowResponse> response) {
                if (response.isSuccessful()) {
                    ListTvShowResponse listTvShowResponse = response.body();
                    if (listTvShowResponse != null && listTvShowResponse.getResults() != null) {
                        liveDataTvShow.postValue(listTvShowResponse.getResults());
                    } else {
                        Log.d("ApiCall", "Empty Data Tv Show");
                    }
                }
                EspressoIdlingResource.decrement();
            }

            @Override
            public void onFailure(@NonNull Call<ListTvShowResponse> call, @NonNull Throwable t) {
                Log.d("ApiCall", "Failure Data Tv Show");
                EspressoIdlingResource.decrement();
            }
        });
    }

    public void getDetailTvShow(MutableLiveData<DetailTvShowResponse> liveData, String id) {
        EspressoIdlingResource.increment();

        Call<DetailTvShowResponse> call = service.getDetailTvShow(id,API_KEY, LANGUAGE);
        call.enqueue(new Callback<DetailTvShowResponse>() {
            @Override
            public void onResponse(@NonNull Call<DetailTvShowResponse> call, @NonNull Response<DetailTvShowResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        DetailTvShowResponse mDetailTvShowResponse = response.body();
                        liveData.postValue(mDetailTvShowResponse);
                    } else {
                        Log.d("ApiCall", "Empty Data Detail Tv Show");
                    }
                }
                EspressoIdlingResource.decrement();
            }

            @Override
            public void onFailure(@NonNull Call<DetailTvShowResponse> call, @NonNull Throwable t) {
                Log.d("ApiCall", "Failure Data Detail Tv Show");
                EspressoIdlingResource.decrement();
            }
        });
    }
}
