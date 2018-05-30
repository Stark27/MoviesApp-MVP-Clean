package com.example.luismunoz.moviesapp.home.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.luismunoz.moviesapp.R;
import com.example.luismunoz.moviesapp.home.adapter.MovieAdapterRecyclerView;
import com.example.luismunoz.moviesapp.home.model.Movie;
import com.example.luismunoz.moviesapp.home.presenter.HomePresenter;
import com.example.luismunoz.moviesapp.home.presenter.HomePresenterImpl;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements HomeActivityView{

    private HomePresenter homePresenter;

    private RecyclerView pictureRecyclerView;
    private LinearLayoutManager linearLayoutManager;
    private MovieAdapterRecyclerView movieAdapterRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        homePresenter = new HomePresenterImpl(this);
        homePresenter.getDataMovies();

        pictureRecyclerView = findViewById(R.id.rv_home_moviesRecycler);

        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        pictureRecyclerView.setLayoutManager(linearLayoutManager);

    }


    @Override
    public void showDataMovies(List<Movie> movies) {
        movieAdapterRecyclerView = new MovieAdapterRecyclerView(movies, R.layout.cardview_movie, this);
        pictureRecyclerView.setAdapter(movieAdapterRecyclerView);
    }

    @Override
    public void showError(String error) {

    }
}
