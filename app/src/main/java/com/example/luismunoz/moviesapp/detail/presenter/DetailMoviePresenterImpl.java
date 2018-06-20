package com.example.luismunoz.moviesapp.detail.presenter;

import com.example.luismunoz.moviesapp.detail.interactor.DetailMovieInteractor;
import com.example.luismunoz.moviesapp.detail.interactor.DetailMovieInteractorImpl;
import com.example.luismunoz.moviesapp.detail.model.MovieData;
import com.example.luismunoz.moviesapp.detail.view.DetailMovieView;

public class DetailMoviePresenterImpl implements DetailMoviePresenter {

    private DetailMovieView detailMovieView;
    private DetailMovieInteractor movieInteractor;

    public DetailMoviePresenterImpl(DetailMovieView detailMovieView) {
        this.detailMovieView = detailMovieView;
        movieInteractor = new DetailMovieInteractorImpl(this);
    }

    @Override
    public void getDataMovie(String movie_id) {
        movieInteractor.getDataMovie(movie_id);
    }

    @Override
    public void showDataMovie(MovieData movieData) {
        detailMovieView.showData(movieData);
    }

    @Override
    public void showError(String error) {
        detailMovieView.showError(error);
    }


}
