package gekaradchenko.gmail.com.mvvmretrofitdemo.viewmodel;

import android.app.Application;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import gekaradchenko.gmail.com.mvvmretrofitdemo.model.MovieRepository;
import gekaradchenko.gmail.com.mvvmretrofitdemo.model.Result;

public class MainActivityViewModel extends AndroidViewModel {

    private MovieRepository movieRepository;
    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        movieRepository = new MovieRepository(application);
    }
    public LiveData<List<Result>> getAllMovieData(){


        return movieRepository.getMutableLiveData();
    }
}