package com.example.luismunoz.moviesapp.detail.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.example.luismunoz.moviesapp.R;
import com.example.luismunoz.moviesapp.detail.presenter.DetailMoviePresenter;
import com.example.luismunoz.moviesapp.detail.presenter.DetailMoviePresenterImpl;

public class DetailMovieActivity extends AppCompatActivity implements DetailMovieView {

    private DetailMoviePresenter detailMoviePresenter;

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
    }

    @Override
    public void showData() {

    }

    @Override
    public void showError() {

    }

    @Override
    public void showToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getResources().getString(R.string.detail));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
