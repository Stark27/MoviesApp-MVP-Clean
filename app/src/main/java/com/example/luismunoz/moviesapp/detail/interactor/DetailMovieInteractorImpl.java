package com.example.luismunoz.moviesapp.detail.interactor;

import com.example.luismunoz.moviesapp.detail.presenter.DetailMoviePresenter;

public class DetailMovieInteractorImpl implements DetailMovieInteractor {

    private DetailMoviePresenter moviePresenter;

    public DetailMovieInteractorImpl(DetailMoviePresenter moviePresenter) {
        this.moviePresenter = moviePresenter;
    }

    @Override
    public void getDataMovie(String movie_id) {

    }
}
