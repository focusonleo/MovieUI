package com.example.movie.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.movie.models.Movie;
import com.example.movie.adapters.MovieAdapter;
import com.example.movie.adapters.MovieItemClickListener;
import com.example.movie.R;
import com.example.movie.models.Slide;
import com.example.movie.adapters.SliderPagerAdapter;
import com.example.movie.utils.DataSource;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class HomeActivity extends AppCompatActivity implements MovieItemClickListener {

    private List<Slide> lstSlides;
    private ViewPager sliderpager;
    private TabLayout indicator;
    private RecyclerView MoviesRV, moviesRvWeek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniViews();
        iniSlider();
        iniPopularMovies();
        iniWeekMovies();


    }

    private void iniWeekMovies() {

        MovieAdapter weekMovieAdapter = new MovieAdapter(this,DataSource.getMovieWeek(),this);
        moviesRvWeek.setAdapter(weekMovieAdapter);
        moviesRvWeek.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

    }

    private void iniPopularMovies() {
        //RecyclerView setUp
        //ini data

        MovieAdapter movieAdapter = new MovieAdapter(this, DataSource.getPopularMovies(),this);
        MoviesRV.setAdapter(movieAdapter);
        //make the view horizontal
        MoviesRV.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false));
    }

    private void iniSlider() {
        //prepare a list of slides
        lstSlides = new ArrayList<>();
        lstSlides.add(new Slide(R.drawable.assest1, "Motivation \ncoming soon"));
        lstSlides.add(new Slide(R.drawable.asset2, "Motivation \ncoming soon"));
        lstSlides.add(new Slide(R.drawable.assest3, "Motivation \ncoming soon"));
        lstSlides.add(new Slide(R.drawable.asset2, "Motivation \ncoming soon"));

        SliderPagerAdapter adapter = new SliderPagerAdapter(this, lstSlides);

        sliderpager.setAdapter(adapter);

        //Setup timer
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new SliderTimer(),4000,4000);

        indicator.setupWithViewPager(sliderpager, true);
    }

    private void iniViews() {
        sliderpager = findViewById(R.id.slider_pager);
        indicator = findViewById(R.id.indicator);
        MoviesRV = findViewById(R.id.Rv_movies);
        moviesRvWeek = findViewById(R.id.rv_movies_week);
    }

    @Override
    public void onMovieClick(Movie movie, ImageView movieImageView) {

        //Here we send movie information to detail activity
        //Also we'll create the transition animation between the two activity

        Intent intent = new Intent(this, MovieDetailActivity.class);
        //Send movie information to detailActivity
        intent.putExtra("title",movie.getTitle());
        intent.putExtra("imgURL",movie.getThumbnail());
        intent.putExtra("imgCover",movie.getCoverPhoto());

        //let create the animation
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(HomeActivity.this, movieImageView, "sharedName");

        startActivity(intent,options.toBundle());

        //i'll make a simple test if the click works
        Toast.makeText(this,"item clicked  : " + movie.getTitle(),Toast.LENGTH_SHORT).show();
    }


    class SliderTimer extends TimerTask {

        @Override
        public void run() {

            HomeActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (sliderpager.getCurrentItem() < lstSlides.size() - 1){
                        sliderpager.setCurrentItem(sliderpager.getCurrentItem() + 1);
                    }
                    else {
                        sliderpager.setCurrentItem(0);
                    }
                }
            });
        }
    }
}
