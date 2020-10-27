package com.example.java.submission_jetpack.data.source.remote.response.movie;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListMovieResponse {
    @SerializedName("results")
    private List<MovieResponse> results;

    public List<MovieResponse> getResults() {
        return results;
    }
}
