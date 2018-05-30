package com.example.luismunoz.moviesapp.theMovieDBApi;

import com.example.luismunoz.moviesapp.home.model.MoviesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Service {

    @GET("discover/movie")
    Call<MoviesResponse>getPopularMovies(@Query("api_key") String apiKey,
                                         @Query("sort_by") String sortBy,
                                         @Query("language") String language);

}
