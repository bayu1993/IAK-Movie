package com.ngodingbareng.android.iakmovie.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.ngodingbareng.android.iakmovie.R;
import com.ngodingbareng.android.iakmovie.activity.MainActivity;
import com.ngodingbareng.android.iakmovie.activity.MovieDetailActivity;
import com.ngodingbareng.android.iakmovie.adapter.MovieAdapter;
import com.ngodingbareng.android.iakmovie.listener.ItemClickSupport;
import com.ngodingbareng.android.iakmovie.model.Movie;
import com.ngodingbareng.android.iakmovie.model.MovieResponse;
import com.ngodingbareng.android.iakmovie.restfull.ApiClient;
import com.ngodingbareng.android.iakmovie.restfull.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TopRateFragment extends Fragment {
    private RecyclerView rvMovie;
    protected Context context;

    private static final String TAG = MainActivity.class.getSimpleName();
    private final static String API_KEY = "bd6d19dfe2e6c6eaed345e2f8bb52d19";

    public TopRateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View parentView = inflater.inflate(R.layout.fragment_top_rate,container,false);
        rvMovie = parentView.findViewById(R.id.rv_movie_list);
        return parentView;

    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
        if (API_KEY.isEmpty()){
            Toast.makeText(getContext(),"Please obtain your API KEY from themoviedb.org first! ",Toast.LENGTH_SHORT).show();
            return;
        }
        rvMovie.setLayoutManager(new LinearLayoutManager(context));
        ApiInterface apiServices = ApiClient.getClient().create(ApiInterface.class);

        Call<MovieResponse> call = apiServices.getTopRatedMovies(API_KEY);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(@NonNull Call<MovieResponse> call, @NonNull Response<MovieResponse> response) {
                //noinspection ConstantConditions
                final List<Movie> movies = response.body().getResults();
                rvMovie.setAdapter(new MovieAdapter(movies, R.layout.list_item_movie, getContext()));
                ItemClickSupport.addTo(rvMovie).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
                    @Override
                    public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                        showSelectedItem(movies.get(position));
                    }
                });
            }

            @Override
            public void onFailure(@NonNull Call<MovieResponse> call, @NonNull Throwable t) {
                Log.e(TAG,t.toString());
            }
        });

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onDetach() {
        super.onDetach();

    }
    private void showSelectedItem(Movie movie){
        Intent movieIntent = new Intent(getActivity(), MovieDetailActivity.class);
        movieIntent.putExtra(MovieDetailActivity.EXTRA_COVER, movie.getPosterPath());
        movieIntent.putExtra(MovieDetailActivity.EXTRA_POSTER,movie.getBackdropPath());
        movieIntent.putExtra(MovieDetailActivity.EXTRA_RELEASE,movie.getReleaseDate());
        movieIntent.putExtra(MovieDetailActivity.EXTRA_TITLE, movie.getTitle());
        movieIntent.putExtra(MovieDetailActivity.EXTRA_RATING,movie.getVoteAverage().toString());
        movieIntent.putExtra(MovieDetailActivity.EXTRA_VOTE, movie.getVoteCount().toString());
        movieIntent.putExtra(MovieDetailActivity.EXTRA_OVERVIEW,movie.getOverview());
        startActivity(movieIntent);
    }

}
