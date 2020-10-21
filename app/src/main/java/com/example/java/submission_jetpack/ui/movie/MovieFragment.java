package com.example.java.submission_jetpack.ui.movie;


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
import com.example.java.submission_jetpack.data.source.remote.response.movie.MovieResponse;
import com.example.java.submission_jetpack.ui.ShowAdapter;
import com.example.java.submission_jetpack.utils.EspressoIdlingResource;
import com.example.java.submission_jetpack.viewmodel.ViewModelFactory;
import com.stone.vega.library.VegaLayoutManager;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment {

    private RecyclerView rvFragmentMoviePopular;
    private ProgressBar progressBar;

    public MovieFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_movie, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvFragmentMoviePopular = view.findViewById(R.id.rv_fragment_movie);
        progressBar = view.findViewById(R.id.progress_bar);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() != null) {
            ViewModelFactory factory = ViewModelFactory.getInstance();
            MovieViewModel movieViewModel = new ViewModelProvider(this, factory).get(MovieViewModel.class);

            ShowAdapter showAdapter = new ShowAdapter("movie");
            progressBar.setVisibility(View.VISIBLE);
            movieViewModel.getListMovie().observe(getViewLifecycleOwner(), movieResponses -> {
                        if (movieResponses != null){
                            List<MovieTvEntity> movieTvEntityArrayList = new ArrayList<>();
                            for (MovieResponse response : movieResponses) {
                                MovieTvEntity movie = new MovieTvEntity(
                                        String.valueOf(response.getId()),
                                        response.getTitle(),
                                        response.getPosterPath(),
                                        String.valueOf(response.getVoteAverage()),
                                        response.getReleaseDate(),
                                        response.getOverview());

                                movieTvEntityArrayList.add(movie);
                            }
                            showAdapter.setData(movieTvEntityArrayList);
                            showAdapter.notifyDataSetChanged();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
            );

            rvFragmentMoviePopular.setLayoutManager(new VegaLayoutManager());
            rvFragmentMoviePopular.setHasFixedSize(true);
            rvFragmentMoviePopular.setAdapter(showAdapter);
        }
    }
}
