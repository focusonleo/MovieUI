package com.example.movie.utils;

import com.example.movie.R;
import com.example.movie.models.Movie;

import java.util.ArrayList;
import java.util.List;

public class DataSource {

    public static List<Movie> getPopularMovies(){

        List<Movie> lstMovies = new ArrayList<>();
        lstMovies.add(new Movie("Lagos", R.drawable.four,R.drawable.cover));
        lstMovies.add(new Movie("Walking Zombie",R.drawable.one,R.drawable.cover));
        lstMovies.add(new Movie("Black Women",R.drawable.two,R.drawable.cover));
        lstMovies.add(new Movie("Turn Up",R.drawable.three,R.drawable.cover));
        lstMovies.add(new Movie("Lagos",R.drawable.four,R.drawable.cover));
        lstMovies.add(new Movie("Walking Zombie",R.drawable.one,R.drawable.cover));
        lstMovies.add(new Movie("Black Women",R.drawable.two,R.drawable.cover));
        lstMovies.add(new Movie("Turn Up",R.drawable.three,R.drawable.cover));

        return lstMovies;

    }

    public static List<Movie> getMovieWeek(){

        List<Movie> lstMovies = new ArrayList<>();
        lstMovies.add(new Movie("Turn Up",R.drawable.three,R.drawable.cover));
        lstMovies.add(new Movie("Lagos",R.drawable.four,R.drawable.cover));
        lstMovies.add(new Movie("Walking Zombie",R.drawable.one,R.drawable.cover));
        lstMovies.add(new Movie("Black Women",R.drawable.two,R.drawable.cover));
        lstMovies.add(new Movie("Turn Up",R.drawable.three,R.drawable.cover));
        lstMovies.add(new Movie("Walking Zombie",R.drawable.one,R.drawable.cover));
        lstMovies.add(new Movie("Black Women",R.drawable.two,R.drawable.cover));

        return lstMovies;

    }


}
