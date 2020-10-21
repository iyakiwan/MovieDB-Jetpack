package com.example.java.submission_jetpack.ui.tv;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.java.submission_jetpack.R;
import com.example.java.submission_jetpack.data.source.local.entitiy.MovieTvEntity;
import com.example.java.submission_jetpack.data.source.remote.response.tv.TvShowResponse;
import com.example.java.submission_jetpack.ui.ShowAdapter;
import com.example.java.submission_jetpack.utils.EspressoIdlingResource;
import com.example.java.submission_jetpack.viewmodel.ViewModelFactory;
import com.stone.vega.library.VegaLayoutManager;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TvFragment extends Fragment {

    private RecyclerView rvFragmentTvShowPopular;
    private ProgressBar progressBar;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tv, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvFragmentTvShowPopular = view.findViewById(R.id.rv_fragment_tv);
        progressBar = view.findViewById(R.id.progress_bar);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() != null) {
            ViewModelFactory factory = ViewModelFactory.getInstance();
            TvViewModel tvViewModel = new ViewModelProvider(this, factory).get(TvViewModel.class);

            ShowAdapter showAdapter = new ShowAdapter("tv");
            progressBar.setVisibility(View.VISIBLE);
            tvViewModel.getTV().observe(getViewLifecycleOwner(), tvShowResponses -> {
                        if (tvShowResponses != null) {
                            List<MovieTvEntity> movieTvEntityList = new ArrayList<>();
                            for (TvShowResponse response : tvShowResponses) {
                                MovieTvEntity tv = new MovieTvEntity(
                                        String.valueOf(response.getId()),
                                        response.getName(),
                                        response.getPosterPath(),
                                        String.valueOf(response.getVoteAverage()),
                                        response.getFirstAirDate(),
                                        response.getOverview());

                                movieTvEntityList.add(tv);
                            }
                            showAdapter.setData(movieTvEntityList);
                            showAdapter.notifyDataSetChanged();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
            );

            rvFragmentTvShowPopular.setLayoutManager(new VegaLayoutManager());
            rvFragmentTvShowPopular.setHasFixedSize(true);
            rvFragmentTvShowPopular.setAdapter(showAdapter);
        }
    }
}
