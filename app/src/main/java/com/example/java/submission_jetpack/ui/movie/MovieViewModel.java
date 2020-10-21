package com.example.java.submission_jetpack.ui.movie;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.java.submission_jetpack.data.source.SubmissionRepository;
import com.example.java.submission_jetpack.data.source.remote.response.movie.MovieResponse;

import java.util.List;

public class MovieViewModel extends ViewModel {
    MutableLiveData<List<MovieResponse>> movieResponse = new MutableLiveData<>();

    private SubmissionRepository submissionRepository;

    public MovieViewModel(SubmissionRepository submissionRepository) {
        this.submissionRepository = submissionRepository;
    }

    public LiveData<List<MovieResponse>> getListMovie() {
        if (movieResponse.getValue() == null) {
            submissionRepository.getAllMovie(movieResponse);
        }
        return movieResponse;
    }
}
