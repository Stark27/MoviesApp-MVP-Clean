package com.example.luismunoz.moviesapp.home.interactor;

import com.example.luismunoz.moviesapp.home.presenter.HomePresenter;
import com.example.luismunoz.moviesapp.home.repository.HomeRepository;
import com.example.luismunoz.moviesapp.home.repository.HomeRepositoryImpl;

public class HomeInteractorImpl implements HomeInteractor {

    private HomePresenter homePresenter;
    private HomeRepository homeRepository;

    public HomeInteractorImpl(HomePresenter homePresenter) {
        this.homePresenter = homePresenter;
        homeRepository = new HomeRepositoryImpl(homePresenter);
    }

    @Override
    public void getDataPopularMovies() {
        homeRepository.getDataPopularMovies();
    }

    @Override
    public void getDataCarteleraMovies() {
        homeRepository.getDataCarteleraMovies();
    }

    @Override
    public void getDataUpCommingMovies() {
        homeRepository.getDataUpCommingMovies();
    }
}
