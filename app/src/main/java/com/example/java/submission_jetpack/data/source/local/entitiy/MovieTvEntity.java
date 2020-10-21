package com.example.java.submission_jetpack.data.source.local.entitiy;

public class MovieTvEntity {
    private String id, title, poster, rating, release, language, other, runtime, genre, overview;

    public MovieTvEntity() {
    }

    public MovieTvEntity(String id, String title, String poster, String rating, String release, String overview) {
        this.id = id;
        this.title = title;
        this.poster = poster;
        this.rating = rating;
        this.release = release;
        this.overview = overview;
    }

    public MovieTvEntity(String id, String title, String poster, String rating, String release, String language, String other, String runtime, String genre, String overview) {
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
}
