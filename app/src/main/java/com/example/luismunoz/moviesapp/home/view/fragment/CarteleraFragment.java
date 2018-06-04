package com.example.luismunoz.moviesapp.home.view.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

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
public class CarteleraFragment extends Fragment implements HomeActivityView {

    private HomePresenter homePresenter;

    private RecyclerView pictureRecyclerView;
    private LinearLayoutManager linearLayoutManager;
    private MovieAdapterRecyclerView movieAdapterRecyclerView;

    public CarteleraFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cartelera, container, false);

        pictureRecyclerView = view.findViewById(R.id.rv_cartelera_moviesRecycler);
        linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        pictureRecyclerView.setLayoutManager(linearLayoutManager);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        homePresenter = new HomePresenterImpl(this);
        homePresenter.getDataCarteleraMovies();
    }

    @Override
    public void showDataMovies(List<Movie> movies) {
        movieAdapterRecyclerView = new MovieAdapterRecyclerView(movies, R.layout.cardview_movie, getContext());
        pictureRecyclerView.setAdapter(movieAdapterRecyclerView);
    }

    @Override
    public void showError(String error) {

    }
}
