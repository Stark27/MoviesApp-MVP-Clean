package com.example.luismunoz.moviesapp.detail.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.luismunoz.moviesapp.R;
import com.example.luismunoz.moviesapp.detail.model.MovieData;
import com.example.luismunoz.moviesapp.detail.presenter.DetailMoviePresenter;
import com.example.luismunoz.moviesapp.detail.presenter.DetailMoviePresenterImpl;
import com.squareup.picasso.Picasso;

public class DetailMovieActivity extends AppCompatActivity implements DetailMovieView {

    private DetailMoviePresenter detailMoviePresenter;

    public static final String URL_BASE_IMAGE = "https://image.tmdb.org/t/p/w500/";

    private ImageView moviePicture;
    private TextView overviewText;
    private TextView voteAverageText;
    private TextView movieTitleText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);
        showToolbar();

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String movieId = extras.getString("movie_id");

        detailMoviePresenter = new DetailMoviePresenterImpl(this);
        detailMoviePresenter.getDataMovie(movieId);

        moviePicture = findViewById(R.id.imv_detail_moviePicture);
        overviewText = findViewById(R.id.tv_detail_overview);
        voteAverageText = findViewById(R.id.tv_detail_voteAverage);
        movieTitleText = findViewById(R.id.tv_detail_movieName);
    }

    @Override
    public void showData(MovieData movieData) {
        String image_path = movieData.getBackdropPath();
        String overviewData = movieData.getOverview();
        String voteAverageData = movieData.getVoteAverage().toString();
        String movieTitleData = movieData.getTitle();

        Picasso.get()
                .load(URL_BASE_IMAGE + image_path)
                .placeholder(R.drawable.noimage)
                .into(moviePicture);

        movieTitleText.setText(movieTitleData);
        voteAverageText.setText(getResources().getString(R.string.movie_vote_average, voteAverageData));
        overviewText.setText(overviewData);
    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void showToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getResources().getString(R.string.detail));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
