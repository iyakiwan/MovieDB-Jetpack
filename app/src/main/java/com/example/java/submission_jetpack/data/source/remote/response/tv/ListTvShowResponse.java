package com.example.java.submission_jetpack.data.source.remote.response.tv;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ListTvShowResponse {
    @SerializedName("results")
    private ArrayList<TvShowResponse>  results;

    public ArrayList<TvShowResponse> getResults() {
        return results;
    }
}
