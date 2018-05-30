package com.example.luismunoz.moviesapp.home.presenter;

import com.example.luismunoz.moviesapp.home.interactor.HomeInteractor;
import com.example.luismunoz.moviesapp.home.interactor.HomeInteractorImpl;
import com.example.luismunoz.moviesapp.home.model.Movie;
import com.example.luismunoz.moviesapp.home.view.HomeActivityView;

import java.util.List;

public class HomePresenterImpl implements HomePresenter {

    private HomeActivityView homeActivityView;
    private HomeInteractor homeInteractor;

    public HomePresenterImpl(HomeActivityView homeActivityView) {
        this.homeActivityView = homeActivityView;
        homeInteractor = new HomeInteractorImpl(this);
    }

    @Override
    public void getDataMovies() {
        homeInteractor.getDataMovies();
    }

    @Override
    public void showDataMovie(List<Movie> movies) {
        homeActivityView.showDataMovies(movies);

    }

    @Override
    public void showError() {

    }
}
