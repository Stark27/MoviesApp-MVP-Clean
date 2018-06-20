package com.example.luismunoz.moviesapp.detail.view;

import com.example.luismunoz.moviesapp.detail.model.MovieData;

public interface DetailMovieView {

    void showData(MovieData movieData);
    void showError(String error);
    void showToolbar();
}
