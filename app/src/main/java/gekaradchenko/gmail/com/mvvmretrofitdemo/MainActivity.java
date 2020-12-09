package gekaradchenko.gmail.com.mvvmretrofitdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import gekaradchenko.gmail.com.mvvmretrofitdemo.adapter.ResultAdapter;
import gekaradchenko.gmail.com.mvvmretrofitdemo.model.MovieApiResponse;
import gekaradchenko.gmail.com.mvvmretrofitdemo.model.Result;
import gekaradchenko.gmail.com.mvvmretrofitdemo.service.MovieApiService;
import gekaradchenko.gmail.com.mvvmretrofitdemo.service.RetrofitInstance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.res.Configuration;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Result> results;
    private RecyclerView recyclerView;
    private ResultAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getPopularMovies();
    }

    public void getPopularMovies() {
        MovieApiService movieApiService = RetrofitInstance.getService();
        Call<MovieApiResponse> call = movieApiService.getPopularMovies(getString(R.string.api_key));
        call.enqueue(new Callback<MovieApiResponse>() {
            @Override
            public void onResponse(Call<MovieApiResponse> call, Response<MovieApiResponse> response) {
                MovieApiResponse movieApiResponse = response.body();


                if (movieApiResponse != null && movieApiResponse.getResults() != null) {
                    results = (ArrayList<Result>) movieApiResponse.getResults();
                    fillRecyclerView();
                }
            }

            @Override
            public void onFailure(Call<MovieApiResponse> call, Throwable t) {

            }
        });
    }

    private void fillRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView);
        adapter = new ResultAdapter(this, results);
        if (getResources().getConfiguration().orientation ==
                Configuration.ORIENTATION_PORTRAIT) {
            recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        } else {
            recyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        }
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();


    }
}