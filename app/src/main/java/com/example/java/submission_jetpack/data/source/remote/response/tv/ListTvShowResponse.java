package com.example.java.submission_jetpack.data.source.remote.response.tv;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ListTvShowResponse {
    @SerializedName("page")
    private int page;
    @SerializedName("total_pages")
    private int totalPages;
    @SerializedName("results")
    private ArrayList<TvShowResponse>  results;

    public ListTvShowResponse(int page, int totalPages, ArrayList<TvShowResponse> results) {
        this.page = page;
        this.totalPages = totalPages;
        this.results = results;
    }

    public int getPage() {
        return page;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public ArrayList<TvShowResponse> getResults() {
        return results;
    }
}
