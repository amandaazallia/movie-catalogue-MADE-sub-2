package com.amandaazallia.moviecatalogue;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class TVShowDetailActivity extends AppCompatActivity {
    public static final String EXTRA_TV_SHOW = "extra_tvShow";
    TextView tvTitle,tvStatus, tvGenre, tvCrew,tvUserScore,
             tvRuntime, tvLanguage, tvOverview, tvDateReleased;

    ImageView imagePoster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tvshow_detail);

        tvTitle = findViewById(R.id.tv_item_title);
        tvStatus = findViewById(R.id.tv_item_status);
        tvGenre = findViewById(R.id.tv_item_genres);
        tvCrew = findViewById(R.id.tv_item_crew);
        tvUserScore = findViewById(R.id.tv_item_userScore);
        tvRuntime = findViewById(R.id.tv_item_runtime);
        tvLanguage = findViewById(R.id.tv_item_language);
        tvOverview = findViewById(R.id.tv_item_overview);
        tvDateReleased = findViewById(R.id.tv_item_dateReleased);

        imagePoster = findViewById(R.id.poster);

        TVShow tvShow = getIntent().getParcelableExtra(EXTRA_TV_SHOW);

        tvTitle.setText(tvShow.getTitle());
        tvStatus.setText(tvShow.getStatus());
        tvGenre.setText(tvShow.getGenre());
        tvCrew.setText(tvShow.getCrew());
        tvUserScore.setText(tvShow.getUser_score());
        tvRuntime.setText(tvShow.getRuntime());
        tvLanguage.setText(tvShow.getOriginal_language());
        tvOverview.setText(tvShow.getOverview());
        tvDateReleased.setText(tvShow.getDate_released());


        Glide.with(this)
                .load(tvShow.getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(imagePoster);
    }
}
