package com.example.luismunoz.moviesapp.home.view;

import android.view.View;

import com.example.luismunoz.moviesapp.home.model.Movie;

import java.util.List;

public interface HomeActivityView {

    void showDataMovies(List<Movie> movies);
    void showError(String error);
    void showToolbar(String title, boolean upBotton, View view);
}
