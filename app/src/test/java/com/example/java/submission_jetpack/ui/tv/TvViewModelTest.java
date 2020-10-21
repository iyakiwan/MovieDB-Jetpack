package com.example.java.submission_jetpack.ui.tv;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.example.java.submission_jetpack.data.source.SubmissionRepository;
import com.example.java.submission_jetpack.data.source.remote.response.tv.TvShowResponse;
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

public class TvViewModelTest {
    private TvViewModel tvViewModel;

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Mock
    private SubmissionRepository submissionRepository = mock(SubmissionRepository.class);

    @Before
    public void setUp() {
        tvViewModel = spy(new TvViewModel(submissionRepository));
    }

    @Test
    public void getListTv() {
        List<TvShowResponse> dummyTvShow = FakeDataDummy.getDummyTvTest();

        MutableLiveData<List<TvShowResponse>> tvShowDummy = new MutableLiveData<>();
        tvShowDummy.setValue(dummyTvShow);

        Observer<List<TvShowResponse>> observer = mock(Observer.class);
        tvViewModel.tvShowResponse = tvShowDummy;

        tvViewModel.tvShowResponse.observeForever(observer);
        assertNotNull(tvViewModel.tvShowResponse);
        assertEquals(tvViewModel.tvShowResponse, tvViewModel.getTV());

        verify(observer).onChanged(dummyTvShow);
    }

}