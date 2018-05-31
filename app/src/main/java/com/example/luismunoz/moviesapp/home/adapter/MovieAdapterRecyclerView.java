package com.example.luismunoz.moviesapp.home.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.luismunoz.moviesapp.R;
import com.example.luismunoz.moviesapp.home.model.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieAdapterRecyclerView extends RecyclerView.Adapter<MovieAdapterRecyclerView.MovieViewHolder> {

    private List<Movie> movies;
    private int resource;
    private Context context;

    public MovieAdapterRecyclerView(List<Movie> movies, int resource, Context context) {
        this.movies = movies;
        this.resource = resource;
        this.context = context;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        Movie movie = movies.get(position);

        String base_url_image = "https://image.tmdb.org/t/p/w500";
        Picasso.get()
                .load(base_url_image + movie.backdropPath)
                .placeholder(R.drawable.noimage)
                .into(holder.pictureCard);

        holder.movieTitleCard.setText(movie.title);
        holder.voteAverageCard.setText(String.format(context.getResources().getString(R.string.movie_vote_average), movie.voteAverage.toString()));
        //holder.voteAverageCard.setText(movie.voteAverage.toString());
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder{

        private ImageView pictureCard;
        private TextView movieTitleCard;
        private TextView voteAverageCard;

        public MovieViewHolder(View itemView) {
            super(itemView);

            pictureCard     = itemView.findViewById(R.id.imv_card_movieCard);
            movieTitleCard  = itemView.findViewById(R.id.tv_cardview_movieTitle);
            voteAverageCard = itemView.findViewById(R.id.tv_cardview_voteAverage);
        }
    }


}
