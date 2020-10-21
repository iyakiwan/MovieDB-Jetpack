package com.example.java.submission_jetpack.utils;

import com.example.java.submission_jetpack.data.source.remote.response.GenreResponse;
import com.example.java.submission_jetpack.data.source.remote.response.movie.DetailMovieResponse;
import com.example.java.submission_jetpack.data.source.remote.response.movie.MovieResponse;
import com.example.java.submission_jetpack.data.source.remote.response.tv.DetailTvShowResponse;
import com.example.java.submission_jetpack.data.source.remote.response.tv.TvShowResponse;

import java.util.ArrayList;
import java.util.List;

public class FakeDataDummy {

    public static List<MovieResponse> getDummyMovieTest() {
        List<MovieResponse> movieShow = new ArrayList<>();

        movieShow.add(new MovieResponse(1, "Avengers: Infinity War",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg",
                8.3,
                "April 27, 2018",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain."));
        movieShow.add(new MovieResponse(2, "Aquaman",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/ydUpl3QkVUCHCq1VWvo2rW4Sf7y.jpg",
                6.8,
                "December 21, 2018",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm`s half-human, half-Atlantean brother and true heir to the throne."));

        return movieShow;
    }

    public static List<TvShowResponse> getDummyTvTest() {
        List<TvShowResponse> tvShow = new ArrayList<>();

        tvShow.add(new TvShowResponse(1,
                "Arrow",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/mo0FP1GxOFZT4UDde7RFDz5APXF.jpg",
                5.8,
                "October 10, 2012",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow."));
        tvShow.add(new TvShowResponse(2,
                "Dragon Ball",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/3wx3EAMtqnbSLhGG8NrqXriCUIQ.jpg",
                7.1,
                "February 26, 1986",
                "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the dragon balls brought her to Goku`s home. Together, they set off to find all seven dragon balls in an adventure that would change Goku`s life forever. See how Goku met his life long friends Bulma, Yamcha, Krillin, Master Roshi and more. And see his adventures as a boy, all leading up to Dragonball Z and later Dragonball GT."));

        return tvShow;
    }

    public static DetailMovieResponse getDummyDetailMovieTest(){
        ArrayList<GenreResponse> genreResponses = new ArrayList<>();
        genreResponses.add(new GenreResponse(1, "Adventure"));
        genreResponses.add(new GenreResponse(2, "Action"));
        genreResponses.add(new GenreResponse(3, "Fantasy"));

        return new DetailMovieResponse(
                1,
                "Avengers: Infinity War",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg",
                8.3,
                "April 27, 2018",
                "Anthony Russo, Joe Russo",
                true,
                149,
                genreResponses,
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.");
    }

    public static DetailTvShowResponse getDummyDetailTvTest(){
        ArrayList<GenreResponse> genreResponses = new ArrayList<>();
        genreResponses.add(new GenreResponse(1, "Adventure"));
        genreResponses.add(new GenreResponse(2, "Action"));
        genreResponses.add(new GenreResponse(4, "Drama"));
        genreResponses.add(new GenreResponse(5, "Crime"));
        genreResponses.add(new GenreResponse(6, "Mystery"));

        String[] language = {"English"};
        int[] runTIme = {42};

        return new DetailTvShowResponse(2,
                "Arrow",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/mo0FP1GxOFZT4UDde7RFDz5APXF.jpg",
                5.8,
                "October 10, 2012",
                language,
                true,
                runTIme,
                genreResponses,
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.");
    }
}
