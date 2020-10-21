package com.example.java.submission_jetpack.ui.tv;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.java.submission_jetpack.data.source.SubmissionRepository;
import com.example.java.submission_jetpack.data.source.remote.response.tv.TvShowResponse;

import java.util.List;

public class TvViewModel extends ViewModel {
    MutableLiveData<List<TvShowResponse>> tvShowResponse = new MutableLiveData<>();

    private SubmissionRepository submissionRepository;

    public TvViewModel(SubmissionRepository submissionRepository) {
        this.submissionRepository = submissionRepository;
    }

    public LiveData<List<TvShowResponse>> getTV() {
        if (tvShowResponse.getValue() == null) {
            submissionRepository.getAllTvShow(tvShowResponse);
        }
        return tvShowResponse;
    }
}
