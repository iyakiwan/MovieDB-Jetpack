package com.example.java.submission_jetpack.ui.favorite;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.paging.DataSource;
import androidx.paging.PagedList;

import com.example.java.submission_jetpack.data.source.SubmissionRepository;
import com.example.java.submission_jetpack.data.source.local.entitiy.MovieTvEntity;
import com.example.java.submission_jetpack.utils.FakeDataDummy;
import com.example.java.submission_jetpack.utils.PagedListUtil;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class FavoriteViewModelTest {
    private FavoriteViewModel favoriteViewModel;

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Mock
    private SubmissionRepository submissionRepository = mock(SubmissionRepository.class);

    @Before
    public void setUp() {
        favoriteViewModel = spy(new FavoriteViewModel(submissionRepository));
    }

    @Test
    public void getListFavMovie() {
        List<MovieTvEntity> movieShow = FakeDataDummy.getDummyMovie();
        DataSource.Factory<Integer, MovieTvEntity> dataSourceFactory = mock(DataSource.Factory.class);

        when(submissionRepository.getShowMovies()).thenReturn(dataSourceFactory);
        PagedList<MovieTvEntity> result = PagedListUtil.mockPagedList(FakeDataDummy.getDummyMovie());

        favoriteViewModel.getListFavMovie();

        verify(submissionRepository).getShowMovies();
        assertNotNull(result);
        assertEquals(movieShow.size(), result.size());
    }

    @Test
    public void getListFavTv() {
        List<MovieTvEntity> tvShow = FakeDataDummy.getDummyTvShow();
        DataSource.Factory<Integer, MovieTvEntity> dataSourceFactory = mock(DataSource.Factory.class);

        when(submissionRepository.getShowTvs()).thenReturn(dataSourceFactory);
        PagedList<MovieTvEntity> result = PagedListUtil.mockPagedList(FakeDataDummy.getDummyTvShow());

        favoriteViewModel.getListFavTv();

        verify(submissionRepository).getShowTvs();
        assertNotNull(result);
        assertEquals(tvShow.size(), result.size());
    }
}