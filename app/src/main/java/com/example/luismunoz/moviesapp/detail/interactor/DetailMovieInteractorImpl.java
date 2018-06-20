package com.example.luismunoz.moviesapp.detail.interactor;

import com.example.luismunoz.moviesapp.detail.presenter.DetailMoviePresenter;
import com.example.luismunoz.moviesapp.detail.repository.DetailMovieRepository;
import com.example.luismunoz.moviesapp.detail.repository.DetailMovieRepositoryImpl;

public class DetailMovieInteractorImpl implements DetailMovieInteractor {

    private DetailMoviePresenter moviePresenter;
    private DetailMovieRepository detailMovieRepository;

    public DetailMovieInteractorImpl(DetailMoviePresenter moviePresenter) {
        this.moviePresenter = moviePresenter;
        detailMovieRepository = new DetailMovieRepositoryImpl(moviePresenter);
    }

    @Override
    public void getDataMovie(String movie_id) {
        detailMovieRepository.getDataMovie(movie_id);
    }
}
