package com.example.java.submission_jetpack.ui.detail;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.example.java.submission_jetpack.data.source.SubmissionRepository;
import com.example.java.submission_jetpack.data.source.local.entitiy.MovieTvEntity;
import com.example.java.submission_jetpack.data.source.remote.response.movie.DetailMovieResponse;
import com.example.java.submission_jetpack.data.source.remote.response.tv.DetailTvShowResponse;
import com.example.java.submission_jetpack.utils.FakeDataDummy;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DetailViewModelTest {
    private DetailViewModel detailViewModel;
    private DetailMovieResponse movieDetailDummy = FakeDataDummy.getDummyDetailMovieTest();
    private DetailTvShowResponse tvDetailDummy = FakeDataDummy.getDummyDetailTvTest();
    private String movieId = String.valueOf(movieDetailDummy.getId());
    private String tvId = String.valueOf(tvDetailDummy.getId());

    private MovieTvEntity dummyShow = FakeDataDummy.getDummyMovie().get(0);
    private String showId = FakeDataDummy.getDummyMovie().get(0).getId();

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Mock
    private SubmissionRepository submissionRepository = mock(SubmissionRepository.class);


    @Before
    public void setUp() {
        detailViewModel = spy(new DetailViewModel(submissionRepository));
    }

    @Test
    public void getDetailMovie() {
        MutableLiveData<DetailMovieResponse> movieDummy = new MutableLiveData<>();
        movieDummy.setValue(movieDetailDummy);

        detailViewModel.setSelectedDetailId(movieId);

        Observer<DetailMovieResponse> observer = mock(Observer.class);
        detailViewModel.detailMovieResponse = movieDummy;

        detailViewModel.detailMovieResponse.observeForever(observer);
        assertNotNull(detailViewModel.detailMovieResponse);
        assertEquals(detailViewModel.detailMovieResponse, detailViewModel.getDetailMovie());

        verify(observer).onChanged(movieDetailDummy);
    }

    @Test
    public void getDetailTv() {
        MutableLiveData<DetailTvShowResponse> tvDummy = new MutableLiveData<>();
        tvDummy.setValue(tvDetailDummy);

        detailViewModel.setSelectedDetailId(tvId);

        Observer<DetailTvShowResponse> observer = mock(Observer.class);
        detailViewModel.detailTvResponse = tvDummy;

        detailViewModel.detailTvResponse.observeForever(observer);
        assertNotNull(detailViewModel.detailTvResponse);
        assertEquals(detailViewModel.detailTvResponse, detailViewModel.getDetailTvShow());

        verify(observer).onChanged(tvDetailDummy);
    }

    @Test
    public void getFavoriteDetail() {
        MutableLiveData<MovieTvEntity> detailDummy = new MutableLiveData<>();
        detailDummy.setValue(dummyShow);

        detailViewModel.setSelectedDetailId(showId);

        when(submissionRepository.getShowById(showId)).thenReturn(detailDummy);

        Observer<MovieTvEntity> observer = mock(Observer.class);

        detailViewModel.getFavoriteDetail().observeForever(observer);

        verify(observer).onChanged(dummyShow);
    }

}