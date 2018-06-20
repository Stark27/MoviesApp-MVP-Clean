package com.example.luismunoz.moviesapp.detail.presenter;

import com.example.luismunoz.moviesapp.detail.model.MovieData;

public interface DetailMoviePresenter {

    void getDataMovie(String movie_id);
    void showDataMovie(MovieData movieData);
    void showError(String error);
}
