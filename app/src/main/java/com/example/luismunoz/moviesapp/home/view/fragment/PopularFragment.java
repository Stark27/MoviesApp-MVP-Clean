package com.example.luismunoz.moviesapp.home.view.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.luismunoz.moviesapp.R;
import com.example.luismunoz.moviesapp.home.adapter.MovieAdapterRecyclerView;
import com.example.luismunoz.moviesapp.home.model.Movie;
import com.example.luismunoz.moviesapp.home.presenter.HomePresenter;
import com.example.luismunoz.moviesapp.home.presenter.HomePresenterImpl;
import com.example.luismunoz.moviesapp.home.view.HomeActivityView;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class PopularFragment extends Fragment implements HomeActivityView {

    private HomePresenter homePresenter;

    private RecyclerView pictureRecyclerView;
    private LinearLayoutManager linearLayoutManager;
    private MovieAdapterRecyclerView movieAdapterRecyclerView;


    public PopularFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_popular, container, false);
        showToolbar(getResources().getString(R.string.app_name), false, view);

        pictureRecyclerView = view.findViewById(R.id.rv_home_moviesRecycler);

        linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        pictureRecyclerView.setLayoutManager(linearLayoutManager);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        homePresenter = new HomePresenterImpl(this);
        homePresenter.getDataPopularMovies();

        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void showDataMovies(List<Movie> movies) {
        movieAdapterRecyclerView = new MovieAdapterRecyclerView(movies, R.layout.cardview_movie, getContext());
        pictureRecyclerView.setAdapter(movieAdapterRecyclerView);
    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void showToolbar(String title, boolean upBotton, View view) {
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(title);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(upBotton);
    }

}
