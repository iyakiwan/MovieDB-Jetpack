package com.example.java.submission_jetpack.ui.detail;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.java.submission_jetpack.data.source.SubmissionRepository;
import com.example.java.submission_jetpack.data.source.local.entitiy.MovieTvEntity;
import com.example.java.submission_jetpack.data.source.remote.response.movie.DetailMovieResponse;
import com.example.java.submission_jetpack.data.source.remote.response.tv.DetailTvShowResponse;

public class DetailViewModel extends ViewModel {
    MutableLiveData<DetailMovieResponse> detailMovieResponse = new MutableLiveData<>();
    MutableLiveData<DetailTvShowResponse> detailTvResponse = new MutableLiveData<>();

    private String detailId;
    private SubmissionRepository submissionRepository;

    public DetailViewModel(SubmissionRepository submissionRepository) {
        this.submissionRepository = submissionRepository;
    }

    public void setSelectedDetailId(String detailId) {
        this.detailId = detailId;
    }

    public LiveData<DetailMovieResponse> getDetailMovie() {
        if (detailMovieResponse.getValue() == null) {
            submissionRepository.getDetailMovie(detailMovieResponse, detailId);
        }
        return detailMovieResponse;
    }

    public LiveData<DetailTvShowResponse> getDetailTvShow() {
        if (detailTvResponse.getValue() == null) {
            submissionRepository.getDetailTvShow(detailTvResponse, detailId);
        }
        return detailTvResponse;
    }

    public void insertShow(MovieTvEntity show) {
        submissionRepository.insertShow(show);
    }

    public void deleteShow(MovieTvEntity show) {
        submissionRepository.deleteShow(show);
    }

    public LiveData<MovieTvEntity> getFavoriteDetail() {
        return submissionRepository.getShowById(detailId);
    }
}
