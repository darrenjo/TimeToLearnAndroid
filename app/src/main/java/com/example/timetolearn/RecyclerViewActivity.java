package com.example.timetolearn;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
public class RecyclerViewActivity extends AppCompatActivity {
    private ArrayList<MovieData> movieList;
    private static final String WEB_URL = "web_url";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        initializeData();
        RecyclerView rv = findViewById(R.id.rv);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        RVAdapter adapter = new RVAdapter(movieList,
                getApplicationContext(), new RVAdapter.OnClicked() {
            @Override
            public void onClick(MovieData movieData) {
                String url = movieData.getWeb_url();
                Intent intent = new Intent(RecyclerViewActivity.this,
                        MovieOverviewActivity.class);
                intent.putExtra(WEB_URL, url);
                startActivity(intent);
            }
        });
        rv.setAdapter(adapter);
    }
    private void initializeData() {
        movieList = new ArrayList<>();
        movieList.add(new MovieData("The Shawshank Redemption",
                "https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_.jpg",
                "1994","https://www.imdb.com/title/tt0111161/"));

        movieList.add(new MovieData("The Godfather",
                "https://m.media-amazon.com/images/M/MV5BM2MyNjYxNmUtYTAwNi00MTYxLWJmNWYtYzZlODY3ZTk3OTFlXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_SY1000_CR0,0,704,1000_AL_.jpg",
                "1972","https://www.imdb.com/title/tt0068646/"));

        movieList.add(new MovieData("Forrest Gump",
                "https://m.media-amazon.com/images/M/MV5BNWIwODRlZTUtY2U3ZS00Yzg1LWJhNzYtMmZiYmEyNmU1NjMzXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_.jpg",
                "1994","https://www.imdb.com/title/tt0109830/"));
    }
}