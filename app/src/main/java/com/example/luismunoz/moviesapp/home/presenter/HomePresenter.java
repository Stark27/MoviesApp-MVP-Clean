package com.example.luismunoz.moviesapp.home.presenter;

import com.example.luismunoz.moviesapp.home.model.Movie;

import java.util.List;

public interface HomePresenter {

    void getDataPopularMovies();
    void getDataCarteleraMovies();
    void getDataUpCommingMovies();

    void showDataMovie(List<Movie> movies);
    void showError();
}
