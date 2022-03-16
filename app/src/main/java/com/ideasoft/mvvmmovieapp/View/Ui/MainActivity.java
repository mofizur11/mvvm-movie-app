package com.ideasoft.mvvmmovieapp.View.Ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.ideasoft.mvvmmovieapp.R;
import com.ideasoft.mvvmmovieapp.Service.Model.Result;
import com.ideasoft.mvvmmovieapp.View.Adapter.TopMovieListAdapter;
import com.ideasoft.mvvmmovieapp.ViewModel.MovieListViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MovieListViewModel mViewModel;
    private TopMovieListAdapter movieListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        mViewModel = new ViewModelProvider(this).get(MovieListViewModel.class);
        mViewModel.getTopRatedMovieLists().observe(this, new Observer<List<Result>>() {
            @Override
            public void onChanged(List<Result> results) {

                movieListAdapter = new TopMovieListAdapter(MainActivity.this,results);
                recyclerView.setAdapter(movieListAdapter);
            }
        });
    }
}