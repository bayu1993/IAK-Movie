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
 * Created by dell on 2/7/18.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {
    private List<Movie> movieHome;
    private int rowLayout;
    private Context context;

    public HomeAdapter(List<Movie> movieHome, int rowLayout, Context context) {
        this.movieHome = movieHome;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public HomeAdapter.HomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewHome = LayoutInflater.from(parent.getContext()).inflate(rowLayout,parent,false);
        return new HomeViewHolder(viewHome);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(HomeAdapter.HomeViewHolder holder, int position) {
        holder.tvTitleHome.setText(movieHome.get(position).getTitle());
        holder.tvSubtitleHome.setText(movieHome.get(position).getReleaseDate());
        holder.tvDescriptionHome.setText(movieHome.get(position).getOverview());
        holder.tvRatingHome.setText(movieHome.get(position).getVoteAverage().toString());
        Glide.with(context)
                .load("https://image.tmdb.org/t/p/w500"+movieHome.get(position).getPosterPath())
                .into(holder.ivCoverHome);
    }

    @Override
    public int getItemCount() {
        return movieHome.size();
    }

    class HomeViewHolder extends RecyclerView.ViewHolder {
        CardView homeLayout;
        TextView tvTitleHome;
        TextView tvSubtitleHome;
        TextView tvDescriptionHome;
        TextView tvRatingHome;
        ImageView ivCoverHome;
        HomeViewHolder(View itemView) {
            super(itemView);
            homeLayout = itemView.findViewById(R.id.movie_layout_home);
            tvTitleHome = itemView.findViewById(R.id.tv_title_home);
            tvSubtitleHome = itemView.findViewById(R.id.tv_subtitle_home);
            tvDescriptionHome = itemView.findViewById(R.id.tv_desc_home);
            tvRatingHome = itemView.findViewById(R.id.tv_rating_home);
            ivCoverHome = itemView.findViewById(R.id.iv_cover_home);
        }
    }

}
