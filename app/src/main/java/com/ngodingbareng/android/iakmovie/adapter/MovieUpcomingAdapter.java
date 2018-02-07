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
 * Created by dell on 2/6/18.
 */

public class MovieUpcomingAdapter extends RecyclerView.Adapter<MovieUpcomingAdapter.UpcomingViewHolder> {
    private List<Movie> movieList;
    private int rowLayout;
    private Context context;

    public MovieUpcomingAdapter(List<Movie> movieList, int rowLayout, Context context) {
        this.movieList = movieList;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public MovieUpcomingAdapter.UpcomingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new UpcomingViewHolder(v);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(MovieUpcomingAdapter.UpcomingViewHolder holder, int position) {
        holder.tvNewTitle.setText(movieList.get(position).getTitle());
        holder.tvNewSubtitle.setText(movieList.get(position).getReleaseDate());
        holder.tvNewDesc.setText(movieList.get(position).getOverview());
        holder.tvNewRating.setText(movieList.get(position).getVoteAverage().toString());
        Glide.with(context)
                .load("https://image.tmdb.org/t/p/w500"+movieList.get(position).getPosterPath())
                .into(holder.ivNewCover);
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    class UpcomingViewHolder extends RecyclerView.ViewHolder {
        CardView upcomingLayout;
        TextView tvNewTitle;
        TextView tvNewSubtitle;
        TextView tvNewDesc;
        TextView tvNewRating;
        ImageView ivNewCover;

        UpcomingViewHolder(View itemView) {

            super(itemView);
            upcomingLayout = itemView.findViewById(R.id.newmovie_layout);
            tvNewTitle = itemView.findViewById(R.id.tv_title_new);
            tvNewSubtitle = itemView.findViewById(R.id.tv_subtitle_new);
            tvNewDesc = itemView.findViewById(R.id.tv_desc_new);
            tvNewRating = itemView.findViewById(R.id.tv_rating_new);
            ivNewCover = itemView.findViewById(R.id.iv_cover_new);
        }
    }
}
