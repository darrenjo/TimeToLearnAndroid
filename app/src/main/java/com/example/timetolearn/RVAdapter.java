package com.example.timetolearn;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import java.io.InputStream;
import java.util.ArrayList;
public class RVAdapter extends RecyclerView.Adapter<RVAdapter.MovieViewHolder> {
    private ArrayList<MovieData> movieList;
    private Context context;
    public interface OnClicked{
        void onClick (MovieData movieData);
    }
    private RVAdapter.OnClicked onClick;
    public RVAdapter(ArrayList<MovieData> movieList, Context context, OnClicked
            onClick) {
        this.movieList = movieList;
        this.context = context;
        this.onClick = onClick;
    }
    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int
            viewType) {
        View view =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item,parent,false);
        return new MovieViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        holder.bind(movieList.get(position), onClick);
    }
    @Override
    public int getItemCount() {
        return movieList.size();
    }
    public static class MovieViewHolder extends RecyclerView.ViewHolder{
        private CardView cv;
        private TextView movieName, movieYear;
        ImageView movieImage;
        private MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.cv);
            movieName = itemView.findViewById(R.id.movie_name);
            movieYear = itemView.findViewById(R.id.movie_year);
            movieImage = itemView.findViewById(R.id.movie_image);
        }
        private void bind(final MovieData movieData, final OnClicked onClick){
            movieName.setText(movieData.getName());
            movieYear.setText(movieData.getYear());
            new DownloadImageTask(movieImage).execute(movieData.getImage_url());
            cv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onClick.onClick(movieData);
                }
            });
        }
        private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
            ImageView bmImage;
            public DownloadImageTask(ImageView bmImage) {
                this.bmImage = bmImage;
            }
            protected Bitmap doInBackground(String... urls) {
                String urldisplay = urls[0];
                Bitmap mIcon11 = null;
                try {
                    InputStream in = new java.net.URL(urldisplay).openStream();

                    mIcon11 = BitmapFactory.decodeStream(in);

                } catch (Exception e) {
                    Log.e("Error", e.getMessage());

                    e.printStackTrace();

                }
                return mIcon11;
            }
            protected void onPostExecute(Bitmap result) {
                bmImage.setImageBitmap(result);
            }
        }
    }
}