package com.example.movieapp.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.movieapp.ChitietMovie_Activity;
import com.example.movieapp.R;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.List;
import com.example.movieapp.Movie;
public class NowPlayingAdapter extends RecyclerView.Adapter<NowPlayingAdapter.NowPlayingViewHolder> {
    private List<Movie> movies;
    private Context context;

    public NowPlayingAdapter(List<Movie> movies, Context context) {
        this.movies = movies;
        this.context = context;
    }

    @NonNull
    @Override
    public NowPlayingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item_movie, parent, false);
        return new NowPlayingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NowPlayingViewHolder holder, int position) {
        Movie movie = movies.get(position);

        Glide.with(context)
                .load(movie.getImageUrl()) // từ URL
                .placeholder(R.drawable.placeholder_poster)
                .into(holder.moviePoster);

        holder.moviePoster.setOnClickListener(v -> {
            Intent intent = new Intent(context, ChitietMovie_Activity.class);
            intent.putExtra("movieId", movie.getMovieId()); // truyền ID
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public static class NowPlayingViewHolder extends RecyclerView.ViewHolder {
        ShapeableImageView moviePoster;

        public NowPlayingViewHolder(@NonNull View itemView) {
            super(itemView);
            moviePoster = itemView.findViewById(R.id.movie_poster);
        }
    }
}