package com.example.java.submission_jetpack.viewmodel;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.java.submission_jetpack.data.source.SubmissionRepository;
import com.example.java.submission_jetpack.di.Injection;
import com.example.java.submission_jetpack.ui.detail.DetailViewModel;
import com.example.java.submission_jetpack.ui.favorite.FavoriteViewModel;
import com.example.java.submission_jetpack.ui.movie.MovieViewModel;
import com.example.java.submission_jetpack.ui.tv.TvViewModel;

public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory{
    private static volatile ViewModelFactory INSTANCE;

    private final SubmissionRepository mSubmissionRepository;

    private ViewModelFactory(SubmissionRepository submissionRepository) {
        mSubmissionRepository = submissionRepository;
    }

    public static ViewModelFactory getInstance(Context context ) {
        if (INSTANCE == null) {
            synchronized (ViewModelFactory.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ViewModelFactory(Injection.provideRepository(context));
                }
            }
        }
        return INSTANCE;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {

        if (modelClass.isAssignableFrom(MovieViewModel.class)) {
            return (T) new MovieViewModel(mSubmissionRepository);
        } else if (modelClass.isAssignableFrom(TvViewModel.class)) {
            return (T) new TvViewModel(mSubmissionRepository);
        } else if (modelClass.isAssignableFrom(DetailViewModel.class)) {
            return (T) new DetailViewModel(mSubmissionRepository);
        } else if (modelClass.isAssignableFrom(FavoriteViewModel.class)) {
            return (T) new FavoriteViewModel(mSubmissionRepository);
        }

        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}
