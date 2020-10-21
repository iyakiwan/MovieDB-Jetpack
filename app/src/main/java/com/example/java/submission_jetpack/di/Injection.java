package com.example.java.submission_jetpack.di;

import com.example.java.submission_jetpack.data.source.SubmissionRepository;
import com.example.java.submission_jetpack.data.source.remote.RemoteDataSource;
import com.example.java.submission_jetpack.utils.ApiHelper;

public class Injection {
    public static SubmissionRepository provideRepository() {
        RemoteDataSource remoteDataSource = RemoteDataSource.getInstance(new ApiHelper());
        return SubmissionRepository.getInstance(remoteDataSource);
    }
}
