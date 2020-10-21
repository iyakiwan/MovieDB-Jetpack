package com.example.java.submission_jetpack.data.source.remote.response.movie;

import com.example.java.submission_jetpack.data.source.remote.response.GenreResponse;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class DetailMovieResponse {
    @SerializedName("id")
    private int id;
    @SerializedName("title")
    private String title;
    @SerializedName("poster_path")
    private String posterPath;
    @SerializedName("vote_average")
    private double voteAverage;
    @SerializedName("release_date")
    private String releaseDate;
    @SerializedName("original_language")
    private String originalLanguage;
    @SerializedName("adult")
    private boolean adult;
    @SerializedName("runtime")
    private int runtime;
    @SerializedName("genres")
    private ArrayList<GenreResponse> genres;
    @SerializedName("overview")
    private String overview;

    public DetailMovieResponse(int id, String title, String posterPath, double voteAverage, String releaseDate, String originalLanguage, boolean adult, int runtime, ArrayList<GenreResponse> genres, String overview) {
        this.id = id;
        this.title = title;
        this.posterPath = posterPath;
        this.voteAverage = voteAverage;
        this.releaseDate = releaseDate;
        this.originalLanguage = originalLanguage;
        this.adult = adult;
        this.runtime = runtime;
        this.genres = genres;
        this.overview = overview;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public boolean isAdult() {
        return adult;
    }

    public int getRuntime() {
        return runtime;
    }

    public ArrayList<GenreResponse> getGenres() {
        return genres;
    }

    public String getOverview() {
        return overview;
    }
}
