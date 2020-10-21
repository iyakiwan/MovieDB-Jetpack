package com.example.java.submission_jetpack.data.source.remote.response;

import com.google.gson.annotations.SerializedName;

public class GenreResponse {
    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;

    public GenreResponse(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
