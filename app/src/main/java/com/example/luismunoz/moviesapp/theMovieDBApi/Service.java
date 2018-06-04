package com.example.luismunoz.moviesapp.theMovieDBApi;

import com.example.luismunoz.moviesapp.home.model.MoviesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Service {

    @GET("movie/popular")
    Call<MoviesResponse> getPopularMovies(@Query("api_key") String apiKey,
                                         @Query("sort_by") String sortBy,
                                         @Query("language") String language);

    @GET("discover/movie")
    Call<MoviesResponse> getCarteleraMovies(@Query("api_key") String apikey,
                                             @Query("primary_release_date.gte") String startReleaseDate,
                                             @Query("primary_release_date.lte") String endReleaseDate,
                                             @Query("language") String language);

    @GET("movie/upcoming")
    Call<MoviesResponse> getUpCommingMovies(@Query("api_key") String apikey,
                                            @Query("language") String language);

}
