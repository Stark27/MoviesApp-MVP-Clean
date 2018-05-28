package com.example.luismunoz.moviesapp.home.view;

import com.example.luismunoz.moviesapp.home.model.Movie;

public interface HomeActivityView {

    void getDataMovies();
    void showDataMovies(Movie movie);
    void showError(String error);
}
