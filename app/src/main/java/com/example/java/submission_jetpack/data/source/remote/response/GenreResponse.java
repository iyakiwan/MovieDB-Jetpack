package com.example.java.submission_jetpack.data.source.remote.response;

import com.google.gson.annotations.SerializedName;

public class GenreResponse {
    @SerializedName("name")
    private String name;

    public GenreResponse( String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
