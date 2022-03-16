package com.ideasoft.mvvmmovieapp.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.ideasoft.mvvmmovieapp.Service.Model.Result;
import com.ideasoft.mvvmmovieapp.Service.Repository.MovieRepository;

import java.util.List;

public class MovieListViewModel extends AndroidViewModel {

    private MovieRepository mRepo;


    public MovieListViewModel(@NonNull Application application) {
        super(application);
        mRepo = MovieRepository.getInstance(application);
    }

    public LiveData<List<Result>> getTopRatedMovieLists(){
        return mRepo.getTopRatedMovieLists();
    }
}
