package com.example.luismunoz.moviesapp.home.repository;

import android.util.Log;

import com.example.luismunoz.moviesapp.home.model.Movie;
import com.example.luismunoz.moviesapp.home.model.MoviesResponse;
import com.example.luismunoz.moviesapp.home.presenter.HomePresenter;
import com.example.luismunoz.moviesapp.theMovieDBApi.Constants;
import com.example.luismunoz.moviesapp.theMovieDBApi.RestApiAdapter;
import com.example.luismunoz.moviesapp.theMovieDBApi.Service;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeRepositoryImpl implements HomeRepository {

    private HomePresenter homePresenter;

    public HomeRepositoryImpl(HomePresenter homePresenter) {
        this.homePresenter = homePresenter;
    }

    @Override
    public void getDataMovies() {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Service service = restApiAdapter.getMoviesService();
        Call<MoviesResponse> call = service.getPopularMovies(Constants.API_KEY, "popularity.desc", "es");

        call.enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
                List<Movie> movieList = response.body().getMovies();
                homePresenter.showDataMovie(movieList);
            }

            @Override
            public void onFailure(Call<MoviesResponse> call, Throwable t) {
                Log.w("HomeRepositoryImpl", t.toString());
            }
        });

    }
}
