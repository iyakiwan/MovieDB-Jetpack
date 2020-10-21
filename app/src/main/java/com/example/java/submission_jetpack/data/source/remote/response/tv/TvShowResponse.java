package com.example.java.submission_jetpack.data.source.remote.response.tv;

import com.google.gson.annotations.SerializedName;

public class TvShowResponse {
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
    @SerializedName("overview")
    private String overview;

    public TvShowResponse(int id, String name, String posterPath, double voteAverage, String firstAirDate, String overview) {
        this.id = id;
        this.name = name;
        this.posterPath = posterPath;
        this.voteAverage = voteAverage;
        this.firstAirDate = firstAirDate;
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

    public String getOverview() {
        return overview;
    }
}
