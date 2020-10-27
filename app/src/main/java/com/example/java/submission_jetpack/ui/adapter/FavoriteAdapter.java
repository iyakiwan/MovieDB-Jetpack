package com.example.java.submission_jetpack.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.java.submission_jetpack.R;
import com.example.java.submission_jetpack.data.source.local.entitiy.MovieTvEntity;
import com.example.java.submission_jetpack.ui.detail.DetailActivity;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class FavoriteAdapter extends PagedListAdapter<MovieTvEntity, FavoriteAdapter.ShowAdapterHolder> {
    String show;
    String urlImage = "https://image.tmdb.org/t/p/w342";

    public FavoriteAdapter(String show) {
        super(DIFF_CALLBACK);
        this.show = show;
    }

    private static DiffUtil.ItemCallback<MovieTvEntity> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<MovieTvEntity>() {
                @Override
                public boolean areItemsTheSame(@NonNull MovieTvEntity oldItem, @NonNull MovieTvEntity newItem) {
                    return oldItem.getId().equals(newItem.getId());
                }

                @SuppressLint("DiffUtilEquals")
                @Override
                public boolean areContentsTheSame(@NonNull MovieTvEntity oldItem, @NonNull MovieTvEntity newItem) {
                    return oldItem.equals(newItem);
                }
            };

    @NonNull
    @Override
    public ShowAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false);
        return new ShowAdapterHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShowAdapterHolder holder, final int position) {
        MovieTvEntity show = getItem(position);
        if (show != null) {
            holder.bind(show);
        }
    }

    public class ShowAdapterHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private final TextView tvRating, tvName, tvRelease, tvOverview;
        private final ImageView imgPoster;

        public ShowAdapterHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvRelease = itemView.findViewById(R.id.tv_item_release);
            tvOverview = itemView.findViewById(R.id.tv_item_overview);
            tvRating = itemView.findViewById(R.id.tv_item_rating);
            imgPoster = itemView.findViewById(R.id.img_item_show);
            itemView.setOnClickListener(this);
        }

        void bind(MovieTvEntity showItems) {
            tvName.setText(showItems.getTitle());
            tvOverview.setText(showItems.getOverview());
            tvRating.setText(showItems.getRating());
            Glide.with(itemView.getContext())
                    .load(urlImage + showItems.getPoster())
                    .apply(new RequestOptions())
                    .into(imgPoster);

            String dateRelease = "";
            try {
                @SuppressLint("SimpleDateFormat") Date date = new SimpleDateFormat("yyyy-MM-dd").parse(showItems.getRelease());
                dateRelease = DateFormat.getDateInstance(DateFormat.MEDIUM).format(Objects.requireNonNull(date));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            tvRelease.setText(dateRelease);
        }

        @Override
        public void onClick(View view) {
            MovieTvEntity movieTvEntity = getItem(getAdapterPosition());

            Intent intent = new Intent(view.getContext(), DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_SHOW, show);
            intent.putExtra(DetailActivity.EXTRA_ID, Objects.requireNonNull(movieTvEntity).getId());
            view.getContext().startActivity(intent);
        }
    }
}
