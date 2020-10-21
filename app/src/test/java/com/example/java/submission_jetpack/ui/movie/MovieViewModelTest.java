package com.example.java.submission_jetpack.ui.movie;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.example.java.submission_jetpack.data.source.SubmissionRepository;
import com.example.java.submission_jetpack.data.source.remote.response.movie.MovieResponse;
import com.example.java.submission_jetpack.utils.FakeDataDummy;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class MovieViewModelTest {
    private MovieViewModel movieViewModel;

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Mock
    private SubmissionRepository submissionRepository = mock(SubmissionRepository.class);

    @Before
    public void setUp() {
        movieViewModel = spy(new MovieViewModel(submissionRepository));
    }

    @Test
    public void getListMovie() {
        List<MovieResponse> dummyMovie = FakeDataDummy.getDummyMovieTest();

        MutableLiveData<List<MovieResponse>> movieDummy = new MutableLiveData<>();
        movieDummy.setValue(dummyMovie);

        Observer<List<MovieResponse>> observer = mock(Observer.class);
        movieViewModel.movieResponse = movieDummy;

        movieViewModel.movieResponse.observeForever(observer);
        assertNotNull(movieViewModel.movieResponse);
        assertEquals(movieViewModel.movieResponse, movieViewModel.getListMovie());

        verify(observer).onChanged(dummyMovie);
    }

}