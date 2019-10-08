package com.example.movie.adapters;

import android.widget.ImageView;

import com.example.movie.models.Movie;

public interface MovieItemClickListener {

    void onMovieClick(Movie movie, ImageView movieImageView);
    //We'll need the imgView to make the shared animation between the two activity

}
