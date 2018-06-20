package com.example.luismunoz.moviesapp.detail.repository;

import android.util.Log;

import com.example.luismunoz.moviesapp.detail.model.MovieData;
import com.example.luismunoz.moviesapp.detail.presenter.DetailMoviePresenter;
import com.example.luismunoz.moviesapp.theMovieDBApi.Constants;
import com.example.luismunoz.moviesapp.theMovieDBApi.RestApiAdapter;
import com.example.luismunoz.moviesapp.theMovieDBApi.Service;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailMovieRepositoryImpl implements DetailMovieRepository {

    private DetailMoviePresenter moviePresenter;

    public DetailMovieRepositoryImpl(DetailMoviePresenter moviePresenter) {
        this.moviePresenter = moviePresenter;
    }

    @Override
    public void getDataMovie(final String movie_id) {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Service service = restApiAdapter.getMoviesService();

        Call<MovieData> call = service.getDataMovie(movie_id, Constants.API_KEY, "es");

        call.enqueue(new Callback<MovieData>() {
            @Override
            public void onResponse(Call<MovieData> call, Response<MovieData> response) {
                MovieData movieData = response.body();
                moviePresenter.showDataMovie(movieData);
            }

            @Override
            public void onFailure(Call<MovieData> call, Throwable t) {
                Log.e("ERROR: ", t.getStackTrace().toString());
                moviePresenter.showError(t.getStackTrace().toString());
            }
        });

    }
}
