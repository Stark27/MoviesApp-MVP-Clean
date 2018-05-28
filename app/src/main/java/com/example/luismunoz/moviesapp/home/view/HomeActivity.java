package com.example.luismunoz.moviesapp.home.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.luismunoz.moviesapp.R;
import com.example.luismunoz.moviesapp.home.model.Movie;

public class HomeActivity extends AppCompatActivity implements HomeActivityView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    @Override
    public void getDataMovies() {

    }

    @Override
    public void showDataMovies(Movie movie) {

    }

    @Override
    public void showError(String error) {

    }
}
