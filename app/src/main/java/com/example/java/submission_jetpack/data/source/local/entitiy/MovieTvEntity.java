package com.example.java.submission_jetpack.data.source.local.entitiy;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "show")
public class MovieTvEntity {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    private String id;

    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo(name = "poster")
    private String poster;

    @ColumnInfo(name = "rating")
    private String rating;

    @ColumnInfo(name = "release")
    private String release;

    @ColumnInfo(name = "language")
    private String language;

    @ColumnInfo(name = "other")
    private String other;

    @ColumnInfo(name = "runtime")
    private String runtime;

    @ColumnInfo(name = "genre")
    private String genre;

    @ColumnInfo(name = "overview")
    private String overview;

    @ColumnInfo(name = "show")
    private String show;

    public MovieTvEntity() {
    }

    public MovieTvEntity(String id, String title, String poster, String rating, String release, String overview, String show) {
        this.id = id;
        this.title = title;
        this.poster = poster;
        this.rating = rating;
        this.release = release;
        this.overview = overview;
        this.show = show;
    }

    public MovieTvEntity(String id, String title, String poster, String rating, String release, String language, String other, String runtime, String genre, String overview, String show) {
        this.id = id;
        this.title = title;
        this.poster = poster;
        this.rating = rating;
        this.release = release;
        this.language = language;
        this.other = other;
        this.runtime = runtime;
        this.genre = genre;
        this.overview = overview;
        this.show = show;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getShow() {
        return show;
    }

    public void setShow(String show) {
        this.show = show;
    }
}