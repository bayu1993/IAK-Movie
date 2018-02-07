package com.ngodingbareng.android.iakmovie.activity;

import android.annotation.SuppressLint;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ngodingbareng.android.iakmovie.R;

public class MovieDetailActivity extends AppCompatActivity {
    public static String EXTRA_OVERVIEW = "extra_overview";
    public static String EXTRA_RATING = "extra_rating";
    public static String EXTRA_VOTE = "extra_vote";
    public static String EXTRA_COVER = "extra_cover";
    public static String EXTRA_POSTER = "extra_poster";
    public static String EXTRA_TITLE = "extra_title";
    public static String EXTRA_RELEASE = "extra_release";

    TextView tvTitle,tvRelease,tvRating,tvVote,tvOverview;
    ImageView ivPoster, ivCover;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        Toolbar toolbarnew = findViewById(R.id.tool_barnew);
        setSupportActionBar(toolbarnew);
        ActionBar menu = getSupportActionBar();
        assert menu != null;
        menu.setDisplayShowHomeEnabled(true);
        menu.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Movie Detail");


        ivCover = findViewById(R.id.iv_cover_detail);
        ivPoster= findViewById(R.id.iv_poster);

        tvRelease = findViewById(R.id.tv_release);
        tvRating = findViewById(R.id.tv_rating_detail);
        tvVote = findViewById(R.id.tv_vote);
        tvOverview = findViewById(R.id.tv_overview);
        tvTitle = findViewById(R.id.tv_title_detail);

        String overview = getIntent().getStringExtra(EXTRA_OVERVIEW);
        String rating   = getIntent().getStringExtra(EXTRA_RATING);
        String vote     = getIntent().getStringExtra(EXTRA_VOTE);
        String release  = getIntent().getStringExtra(EXTRA_RELEASE);
        String title    = getIntent().getStringExtra(EXTRA_TITLE);
        String cover    = getIntent().getStringExtra(EXTRA_COVER);
        String poster   = getIntent().getStringExtra(EXTRA_POSTER);

        Glide.with(MovieDetailActivity.this)
                .load("https://image.tmdb.org/t/p/w500"+cover)
                .into(ivCover);
        Glide.with(MovieDetailActivity.this)
                .load("https://image.tmdb.org/t/p/w500"+poster)
                .into(ivPoster);

        tvOverview.setText(overview);
        tvRating.setText(rating);
        tvVote.setText(vote);
        tvRelease.setText("Release : "+release);
        tvTitle.setText(title);
    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
