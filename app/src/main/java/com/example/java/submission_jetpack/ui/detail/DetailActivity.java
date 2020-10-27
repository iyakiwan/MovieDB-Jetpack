package com.example.java.submission_jetpack.ui.detail;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.java.submission_jetpack.R;
import com.example.java.submission_jetpack.data.source.local.entitiy.MovieTvEntity;
import com.example.java.submission_jetpack.data.source.remote.response.GenreResponse;
import com.example.java.submission_jetpack.viewmodel.ViewModelFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_SHOW = "extra_show";
    public static final String EXTRA_ID = "extra_id";

    private ProgressBar progressBar;
    private TextView tvTitle;
    private TextView tvRating;
    private TextView tvDirNet;
    private TextView tvRelease;
    private TextView tvDesc;
    private TextView tvGenre;
    private TextView tvLanguage;
    private TextView tvRuntime;
    private ImageView imgPoster;

    private DetailViewModel detailViewModel;
    private Menu menu;
    private MovieTvEntity movieTvEntity;

    private String show = "", id = "";
    private boolean favorite = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        tvTitle = findViewById(R.id.tv_detail_title);
        tvRating = findViewById(R.id.tv_detail_rating);
        tvDirNet = findViewById(R.id.tv_detail_other);
        tvRelease = findViewById(R.id.tv_detail_release);
        tvDesc = findViewById(R.id.tv_detail_desc);
        tvGenre = findViewById(R.id.tv_detail_genre);
        tvLanguage = findViewById(R.id.tv_detail_language);
        tvRuntime = findViewById(R.id.tv_detail_runtime);
        TextView tvJdlDirNet = findViewById(R.id.tv_head_other);
        imgPoster = findViewById(R.id.img_detail_poster);
        progressBar = findViewById(R.id.progress_bar);

        ViewModelFactory factory = ViewModelFactory.getInstance(this);
        detailViewModel = new ViewModelProvider(this, factory).get(DetailViewModel.class);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            id = extras.getString(EXTRA_ID);
            show = getIntent().getStringExtra(EXTRA_SHOW);
            if (id != null && show != null) {
                detailViewModel.setSelectedDetailId(id);

                progressBar.setVisibility(View.VISIBLE);
                if (show.equals("movie")) {
                    detailViewModel.getDetailMovie().observe(this, response -> {
                        getSupportActionBar().setTitle(response.getTitle());
                        MovieTvEntity detailMovie = new MovieTvEntity();

                        detailMovie.setId(String.valueOf(response.getId()));
                        detailMovie.setTitle(response.getTitle());
                        detailMovie.setPoster(response.getPosterPath());
                        detailMovie.setRating(String.valueOf(response.getVoteAverage()));
                        detailMovie.setRelease(response.getReleaseDate());
                        detailMovie.setLanguage(response.getOriginalLanguage());
                        detailMovie.setRuntime(response.getRuntime() + " M");
                        detailMovie.setOverview(response.getOverview());
                        detailMovie.setOther((response.isAdult()) ? "Yes" : "No");
                        StringBuilder genres = new StringBuilder();
                        for (int i = 0; i < response.getGenres().size(); i++) {
                            GenreResponse genreResponse = response.getGenres().get(i);
                            if (i == 0) {
                                genres.append(genreResponse.getName());
                                continue;
                            }
                            genres.append(", ").append(genreResponse.getName());
                        }
                        detailMovie.setGenre(genres.toString());
                        detailMovie.setShow(show);

                        movieTvEntity = detailMovie;
                        setDetail(detailMovie);
                        progressBar.setVisibility(View.GONE);
                    });
                } else if (show.equals("tv")) {
                    tvJdlDirNet.setText(getResources().getString(R.string.production));

                    detailViewModel.getDetailTvShow().observe(this, response -> {
                        getSupportActionBar().setTitle(response.getName());

                        MovieTvEntity detailTvShow = new MovieTvEntity();

                        detailTvShow.setId(String.valueOf(response.getId()));
                        detailTvShow.setTitle(response.getName());
                        detailTvShow.setPoster(response.getPosterPath());
                        detailTvShow.setRating(String.valueOf(response.getVoteAverage()));
                        detailTvShow.setRelease(response.getFirstAirDate());
                        detailTvShow.setOverview(response.getOverview());
                        detailTvShow.setOther((response.isIn_production()) ? "Yes" : "No");

                        //Language
                        StringBuilder languages = new StringBuilder();
                        for (int i = 0; i < response.getLanguages().length; i++) {
                            if (i == 0) {
                                languages.append(response.getLanguages()[i]);
                                continue;
                            }
                            languages.append(", ").append(response.getLanguages()[i]);
                        }
                        detailTvShow.setLanguage(languages.toString());

                        //Run Time
                        StringBuilder runtime = new StringBuilder();
                        for (int i = 0; i < response.getEpisodeRunTime().length; i++) {
                            if (i == 0) {
                                runtime.append(response.getEpisodeRunTime()[i]).append(" M");
                                continue;
                            }
                            runtime.append(", ").append(response.getEpisodeRunTime()[i]).append(" M");
                        }
                        detailTvShow.setRuntime(runtime.toString());

                        //Genre
                        StringBuilder genres = new StringBuilder();
                        for (int i = 0; i < response.getGenres().size(); i++) {
                            GenreResponse genreResponse = response.getGenres().get(i);
                            if (i == 0) {
                                genres.append(genreResponse.getName());
                                continue;
                            }
                            genres.append(", ").append(genreResponse.getName());
                        }
                        detailTvShow.setGenre(genres.toString());
                        detailTvShow.setShow(show);

                        movieTvEntity = detailTvShow;
                        setDetail(detailTvShow);
                        progressBar.setVisibility(View.GONE);
                    });
                } else {
                    if (show.equals("favorite tv")) {
                        tvJdlDirNet.setText(getResources().getString(R.string.production));
                    }
                    detailViewModel.getFavoriteDetail().observe(this, response -> {
                        if (response != null){
                            movieTvEntity = response;
                            setDetail(response);
                            progressBar.setVisibility(View.GONE);
                        }
                    });
                }
            }
        }
    }

    private void setDetail(MovieTvEntity movieTvEntity) {
        tvTitle.setText(movieTvEntity.getTitle());
        tvRating.setText(movieTvEntity.getRating());
        tvDirNet.setText(movieTvEntity.getOther());
        String dateRelease = "";
        try {
            @SuppressLint("SimpleDateFormat") Date date = new SimpleDateFormat("yyyy-MM-dd").parse(movieTvEntity.getRelease());
            dateRelease = DateFormat.getDateInstance(DateFormat.MEDIUM).format(Objects.requireNonNull(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        tvRelease.setText(dateRelease);
        tvDesc.setText(movieTvEntity.getOverview());
        tvGenre.setText(movieTvEntity.getGenre());
        tvLanguage.setText(movieTvEntity.getLanguage());
        tvRuntime.setText(movieTvEntity.getRuntime());
        String urlImage = "https://image.tmdb.org/t/p/w342";
        Glide.with(this)
                .load(urlImage + movieTvEntity.getPoster())
                .apply(new RequestOptions())
                .into(imgPoster);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        this.menu = menu;
        detailViewModel.getFavoriteDetail().observe(this, response -> {
            if (response != null){
                if (response.getId().equals(id)){
                    favorite = true;
                    setBookmarkState(true);
                }
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_favorite) {
            if (favorite) {
                favorite = false;
                detailViewModel.deleteShow(movieTvEntity);
            } else {
                favorite = true;
                detailViewModel.insertShow(movieTvEntity);
            }
            setBookmarkState(favorite);
            return true;
        } else if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    private void setBookmarkState(boolean state) {
        if (menu == null) return;
        MenuItem menuItem = menu.findItem(R.id.action_favorite);
        if (state) {
            menuItem.setIcon(ContextCompat.getDrawable(this, R.drawable.ic_favorite_full_white));
        } else {
            menuItem.setIcon(ContextCompat.getDrawable(this, R.drawable.ic_favorite_white));
        }
    }
}