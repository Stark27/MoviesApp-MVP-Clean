package com.example.luismunoz.moviesapp.home.view;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.luismunoz.moviesapp.R;
import com.example.luismunoz.moviesapp.home.adapter.MovieAdapterRecyclerView;
import com.example.luismunoz.moviesapp.home.model.Movie;
import com.example.luismunoz.moviesapp.home.presenter.HomePresenter;
import com.example.luismunoz.moviesapp.home.presenter.HomePresenterImpl;
import com.example.luismunoz.moviesapp.home.view.fragment.CarteleraFragment;
import com.example.luismunoz.moviesapp.home.view.fragment.NextFragment;
import com.example.luismunoz.moviesapp.home.view.fragment.PopularFragment;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    /*private HomePresenter homePresenter;

    private RecyclerView pictureRecyclerView;
    private LinearLayoutManager linearLayoutManager;
    private MovieAdapterRecyclerView movieAdapterRecyclerView;*/

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.action_popular);

        PopularFragment popularFragment = new PopularFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.home_container, popularFragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                //.addToBackStack(null)
                .commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_cartelera:
                        CarteleraFragment carteleraFragment = new CarteleraFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.home_container, carteleraFragment)
                                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                                .addToBackStack(null).commit();
                        break;
                    case R.id.action_popular:
                        PopularFragment popularFragment = new PopularFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.home_container, popularFragment)
                                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                                .addToBackStack(null).commit();
                        break;
                    case R.id.action_proximo:
                        NextFragment nextFragment = new NextFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.home_container, nextFragment)
                                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                                .addToBackStack(null).commit();
                        break;
                }
                return true;
            }
        });

    }

}
