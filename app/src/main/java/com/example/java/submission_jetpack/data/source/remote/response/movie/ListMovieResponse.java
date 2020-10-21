package com.example.java.submission_jetpack.data.source.remote.response.movie;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListMovieResponse {
    @SerializedName("page")
    private int page;
    @SerializedName("total_pages")
    private int totalPages;
    @SerializedName("results")
    private List<MovieResponse> results;

    public ListMovieResponse(int page, int totalPages, List<MovieResponse> results) {
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

    public List<MovieResponse> getResults() {
        return results;
    }
}
