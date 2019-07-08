package com.amandaazallia.moviecatalogue;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class MovieDetailActivity extends AppCompatActivity {
    public static final String EXTRA_MOVIE = "extra_movie";
    TextView tvTitle, tvDateReleased, tvOverview, tvBudget,
            tvRevenue, tvUserScore, tvRuntime, tvLanguage, tvStatus, tvGenre;

    ImageView imagePoster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        tvTitle = findViewById(R.id.tv_item_title);
        tvStatus = findViewById(R.id.tv_item_status);
        tvUserScore = findViewById(R.id.tv_item_userScore);
        tvBudget = findViewById(R.id.tv_item_budget);
        tvRevenue = findViewById(R.id.tv_item_revenue);
        tvOverview = findViewById(R.id.tv_item_overview);
        tvDateReleased = findViewById(R.id.tv_item_dateReleased);
        tvLanguage = findViewById(R.id.tv_item_language);
        tvRuntime = findViewById(R.id.tv_item_runtime);
        tvGenre = findViewById(R.id.tv_item_genre);
        imagePoster = findViewById(R.id.poster);

        Movies movie = getIntent().getParcelableExtra(EXTRA_MOVIE);

        tvTitle.setText(movie.getTitle());
        tvStatus.setText(movie.getStatus());
        tvUserScore.setText(movie.getUser_score());
        tvBudget.setText(movie.getBudget());
        tvRevenue.setText(movie.getRevenue());
        tvOverview.setText(movie.getOverview());
        tvDateReleased.setText(movie.getYear_in());
        tvLanguage.setText(movie.getOriginal_language());
        tvRuntime.setText(movie.getRuntime());
        tvGenre.setText(movie.getGenre());


        Glide.with(this)
                .load(movie.getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(imagePoster);

    }

}
