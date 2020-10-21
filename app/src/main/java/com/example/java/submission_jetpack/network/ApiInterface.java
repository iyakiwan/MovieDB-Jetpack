package com.example.java.submission_jetpack.network;

import com.example.java.submission_jetpack.data.source.remote.response.movie.DetailMovieResponse;
import com.example.java.submission_jetpack.data.source.remote.response.movie.ListMovieResponse;
import com.example.java.submission_jetpack.data.source.remote.response.tv.DetailTvShowResponse;
import com.example.java.submission_jetpack.data.source.remote.response.tv.ListTvShowResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {
    //Get Data Movie
    @GET("movie/popular")
    Call<ListMovieResponse> getDataMovie(
            @Query("api_key") String apiKey,
            @Query("language") String language,
            @Query("page") String page
    );

    //Get Data Detail Movie
    @GET("movie/{movieId}")
    Call<DetailMovieResponse> getDetailMovie(
            @Path("movieId") String movieId,
            @Query("api_key") String apiKey,
            @Query("language") String language
    );

    //Get Data Movie
    @GET("tv/popular")
    Call<ListTvShowResponse> getDataTvShow(
            @Query("api_key") String apiKey,
            @Query("language") String language,
            @Query("page") String page
    );

    //Get Data Detail Movie
    @GET("tv/{tvId}")
    Call<DetailTvShowResponse> getDetailTvShow(
            @Path("tvId") String tvId,
            @Query("api_key") String apiKey,
            @Query("language") String language
    );
}
