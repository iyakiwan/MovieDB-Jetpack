package com.example.java.submission_jetpack.di;

import android.content.Context;

import com.example.java.submission_jetpack.data.source.SubmissionRepository;
import com.example.java.submission_jetpack.data.source.local.LocalDataSource;
import com.example.java.submission_jetpack.data.source.local.room.SubmissionDatabase;
import com.example.java.submission_jetpack.data.source.remote.RemoteDataSource;
import com.example.java.submission_jetpack.utils.ApiHelper;

public class Injection {
    public static SubmissionRepository provideRepository(Context context) {
        SubmissionDatabase database = SubmissionDatabase.getInstance(context);

        RemoteDataSource remoteDataSource = RemoteDataSource.getInstance(new ApiHelper(context));
        LocalDataSource localDataSource = LocalDataSource.getInstance(database.submissionDao());

        return SubmissionRepository.getInstance(remoteDataSource, localDataSource);
    }
}
