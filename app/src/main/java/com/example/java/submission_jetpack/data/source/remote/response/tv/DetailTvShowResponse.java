package com.example.java.submission_jetpack.data.source.remote.response.tv;

import com.example.java.submission_jetpack.data.source.remote.response.GenreResponse;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class DetailTvShowResponse {
    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("poster_path")
    private String posterPath;
    @SerializedName("vote_average")
    private double voteAverage;
    @SerializedName("first_air_date")
    private String firstAirDate;
    @SerializedName("languages")
    private String[] languages;
    @SerializedName("in_production")
    private boolean in_production;
    @SerializedName("episode_run_time")
    private int[] episodeRunTime;
    @SerializedName("genres")
    private ArrayList<GenreResponse> genres;
    @SerializedName("overview")
    private String overview;

    public DetailTvShowResponse(int id, String name, String posterPath, double voteAverage, String firstAirDate, String[] languages, boolean in_production, int[] episodeRunTime, ArrayList<GenreResponse> genres, String overview) {
        this.id = id;
        this.name = name;
        this.posterPath = posterPath;
        this.voteAverage = voteAverage;
        this.firstAirDate = firstAirDate;
        this.languages = languages;
        this.in_production = in_production;
        this.episodeRunTime = episodeRunTime;
        this.genres = genres;
        this.overview = overview;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public String getFirstAirDate() {
        return firstAirDate;
    }

    public String[] getLanguages() {
        return languages;
    }

    public boolean isIn_production() {
        return in_production;
    }

    public int[] getEpisodeRunTime() {
        return episodeRunTime;
    }

    public ArrayList<GenreResponse> getGenres() {
        return genres;
    }

    public String getOverview() {
        return overview;
    }
}
