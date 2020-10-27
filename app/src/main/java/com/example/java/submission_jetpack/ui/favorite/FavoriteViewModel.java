package com.example.java.submission_jetpack.ui.favorite;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.example.java.submission_jetpack.data.source.SubmissionRepository;
import com.example.java.submission_jetpack.data.source.local.entitiy.MovieTvEntity;

public class FavoriteViewModel extends ViewModel {

    private SubmissionRepository submissionRepository;

    public FavoriteViewModel(SubmissionRepository submissionRepository) {
        this.submissionRepository = submissionRepository;
    }

    public LiveData<PagedList<MovieTvEntity>> getListFavMovie() {
        PagedList.Config config = new PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setInitialLoadSizeHint(4)
                .setPageSize(4)
                .build();
        return new LivePagedListBuilder<>( submissionRepository.getShowMovies(), config).build();
    }

    public LiveData<PagedList<MovieTvEntity>> getListFavTv() {
        PagedList.Config config = new PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setInitialLoadSizeHint(4)
                .setPageSize(4)
                .build();
        return new LivePagedListBuilder<>(submissionRepository.getShowTvs(), config).build();
    }
}
