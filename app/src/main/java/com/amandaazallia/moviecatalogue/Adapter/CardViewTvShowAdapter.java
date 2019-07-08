package com.amandaazallia.moviecatalogue.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.amandaazallia.moviecatalogue.R;
import com.amandaazallia.moviecatalogue.TVShow;
import com.amandaazallia.moviecatalogue.TVShowDetailActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class CardViewTvShowAdapter extends RecyclerView.Adapter<CardViewTvShowAdapter.CardViewViewHolder> {

    private Context context;
    private ArrayList<TVShow> listTvShow;

    public CardViewTvShowAdapter(Context context) {
        this.context = context;
    }
    public ArrayList<TVShow> getListTvShow() {
        return listTvShow;
    }

    public void setListTvShow(ArrayList<TVShow> listTvShow) {
        this.listTvShow = listTvShow;
    }


    @NonNull
    @Override
    public CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cardview_tv_show, viewGroup, false);
        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewViewHolder cardViewViewHolder, int position) {
        TVShow tvShow = getListTvShow().get(position);
        Glide.with(context)
                .load(tvShow.getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(cardViewViewHolder.imgPhoto);

        cardViewViewHolder.tvTitle.setText(tvShow.getTitle());
        cardViewViewHolder.tvDateReleased.setText(tvShow.getDate_released());
        cardViewViewHolder.tvUserScore.setText(tvShow.getUser_score());
        cardViewViewHolder.tvRuntime.setText(tvShow.getRuntime());

    }

    @Override
    public int getItemCount() {
        return getListTvShow().size();
    }

    class CardViewViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imgPhoto;
        TextView tvTitle, tvRuntime, tvDateReleased, tvUserScore;

        CardViewViewHolder(@NonNull final View itemView) {
            super(itemView);

            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvTitle = itemView.findViewById(R.id.tv_item_title);
            tvDateReleased = itemView.findViewById(R.id.tv_item_dateReleased);
            tvUserScore = itemView.findViewById(R.id.tv_item_userScore);
            tvRuntime = itemView.findViewById(R.id.tv_item_runtime);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            TVShow tvShow = getListTvShow().get(position);

            tvShow.setTitle(tvShow.getTitle());
            tvShow.setOverview(tvShow.getOverview());

            Intent moveWithObjectIntent = new Intent(itemView.getContext(), TVShowDetailActivity.class);
            moveWithObjectIntent.putExtra(TVShowDetailActivity.EXTRA_TV_SHOW, tvShow);
            context.startActivity(moveWithObjectIntent);
        }
    }
}
