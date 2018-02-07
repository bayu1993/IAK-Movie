package com.ngodingbareng.android.iakmovie.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ngodingbareng.android.iakmovie.R;
import com.ngodingbareng.android.iakmovie.model.Movie;

import java.util.List;

/**
 * Created by dell on 1/31/18.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieHolder> {
    private List<Movie> movies;
    private int rowLayout;
    private Context context;

    public MovieAdapter(List<Movie> movies, int rowLayout, Context context) {
        this.movies = movies;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public MovieAdapter.MovieHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new MovieHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(final MovieAdapter.MovieHolder holder, int position) {
        holder.tvTitle.setText(movies.get(position).getTitle());
        holder.tvSubtitle.setText(movies.get(position).getReleaseDate());
        holder.tvDescription.setText(movies.get(position).getOverview());
        holder.tvRating.setText(movies.get(position).getVoteAverage().toString());
        Glide.with(context)
                .load("https://image.tmdb.org/t/p/w500"+movies.get(position).getPosterPath())
                .into(holder.ivCover);

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    class MovieHolder extends RecyclerView.ViewHolder {
        CardView movieLayout;
        TextView tvTitle;
        TextView tvSubtitle;
        TextView tvDescription;
        TextView tvRating;
        ImageView ivCover;

        MovieHolder(View itemView) {
            super(itemView);
            movieLayout = itemView.findViewById(R.id.movie_layout);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvSubtitle = itemView.findViewById(R.id.tv_subtitle);
            tvDescription = itemView.findViewById(R.id.tv_desc);
            tvRating = itemView.findViewById(R.id.tv_rating);
            ivCover = itemView.findViewById(R.id.iv_image_cover);
        }
    }
}
