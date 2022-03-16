package com.ideasoft.mvvmmovieapp.Service.Network;

import com.ideasoft.mvvmmovieapp.Service.Model.MovieModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiServices {

    @GET("3/movie/top_rated?api_key=1d8809763a81fb44fcdebe9e1cf55f58")
    Call<MovieModel> getTopRatedMovieList();
}
