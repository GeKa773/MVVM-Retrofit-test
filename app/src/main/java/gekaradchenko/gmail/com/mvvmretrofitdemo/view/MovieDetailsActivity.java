package gekaradchenko.gmail.com.mvvmretrofitdemo.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import gekaradchenko.gmail.com.mvvmretrofitdemo.R;
import gekaradchenko.gmail.com.mvvmretrofitdemo.databinding.ActivityMovieDetailsBinding;
import gekaradchenko.gmail.com.mvvmretrofitdemo.model.Result;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class MovieDetailsActivity extends AppCompatActivity {
    private Result result;
//    private ImageView posterImageView;
//    private String posterPath;
//    private TextView titleTextView;
//    private TextView voteCountTextView;
//    private TextView overviewTextView;

    private ActivityMovieDetailsBinding activityMovieDetailsBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        activityMovieDetailsBinding = DataBindingUtil.setContentView(this,
                R.layout.activity_movie_details);

//        posterImageView = findViewById(R.id.posterImageView);
//        titleTextView = findViewById(R.id.titleTextView);
//        voteCountTextView = findViewById(R.id.voteCountTextView);
//        overviewTextView = findViewById(R.id.overviewTextView);

        Intent intent = getIntent();

        if (intent != null && intent.hasExtra("movieData")) {

            result = intent.getParcelableExtra("movieData");

            activityMovieDetailsBinding.setResult(result);

//            Toast.makeText(this, result.getOriginalTitle(), Toast.LENGTH_LONG).show();
//            posterPath = result.getPosterPath();
//            String imagePath = "https://image.tmdb.org/t/p/w500/" + posterPath;
//            Glide.with(this)
//                    .load(imagePath)
//                    .placeholder(R.drawable.progress_circle)
//                    .into(posterImageView);
//
//            titleTextView.setText(result.getOriginalTitle());
//            voteCountTextView.setText(result.getVoteCount()+"");
//            overviewTextView.setText(result.getOverview());
        }
    }
}