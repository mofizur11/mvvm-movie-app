package com.ideasoft.mvvmmovieapp.View.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.ideasoft.mvvmmovieapp.R;
import com.ideasoft.mvvmmovieapp.Service.Model.Result;

import java.util.List;

public class TopMovieListAdapter extends RecyclerView.Adapter<TopMovieListAdapter.MyViewHolder> {

    private Context mContext;
    private List<Result> mList;

    public TopMovieListAdapter(Context mContext, List<Result> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.movie_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.mTitle.setText(mList.get(position).getTitle());
        holder.mRated.setText(mList.get(position).getVoteAverage().toString());
        holder.mReleaseDate.setText(mList.get(position).getReleaseDate());

        Glide.with(mContext).load("https://image.tmdb.org/t/p/w500"+mList.get(position).getPosterPath()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView mTitle, mRated, mReleaseDate;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            mTitle = itemView.findViewById(R.id.movieName);
            mRated = itemView.findViewById(R.id.movieRating);
            mReleaseDate = itemView.findViewById(R.id.movieRelease);

        }
    }
}
