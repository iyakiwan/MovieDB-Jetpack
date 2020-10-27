package com.example.java.submission_jetpack.ui.favorite.fragment;


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
import com.example.java.submission_jetpack.ui.adapter.FavoriteAdapter;
import com.example.java.submission_jetpack.ui.favorite.FavoriteViewModel;
import com.example.java.submission_jetpack.viewmodel.ViewModelFactory;
import com.stone.vega.library.VegaLayoutManager;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavoriteTvFragment extends Fragment {

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
            ViewModelFactory factory = ViewModelFactory.getInstance(getContext());
            FavoriteViewModel favoriteViewModel = new ViewModelProvider(this, factory).get(FavoriteViewModel.class);

            FavoriteAdapter favoriteAdapter = new FavoriteAdapter("favorite tv");
            progressBar.setVisibility(View.VISIBLE);
            favoriteViewModel.getListFavTv().observe(getViewLifecycleOwner(), responses -> {
                        if (responses != null) {
                            favoriteAdapter.submitList(responses);
                            favoriteAdapter.notifyDataSetChanged();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
            );

            rvFragmentTvShowPopular.setLayoutManager(new VegaLayoutManager());
            rvFragmentTvShowPopular.setHasFixedSize(true);
            rvFragmentTvShowPopular.setAdapter(favoriteAdapter);
        }
    }
}
