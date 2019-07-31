package com.takehome.opentabletakehome.mvp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.takehome.opentabletakehome.R;
import com.takehome.opentabletakehome.models.ResultsModel;

import java.util.List;

/**
 * Created by nivesuresh on 7/25/19.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    List<ResultsModel> resultsList;
    Context context;

    public NewsAdapter(Context context, List<ResultsModel> resultsList) {
        this.resultsList = resultsList;
        this.context = context;
    }

    class NewsViewHolder extends RecyclerView.ViewHolder {

        private TextView display_title;
        private TextView mpaa_rating;
        private TextView headline;
        private TextView summary_short;
        private TextView publication_date_byline;
        private ImageView multimedia;

        NewsViewHolder(View mView) {
            super(mView);

            display_title = mView.findViewById(R.id.display_title);
            mpaa_rating = mView.findViewById(R.id.mpaa_rating);
            headline = mView.findViewById(R.id.headline);
            summary_short = mView.findViewById(R.id.summary_short);
            publication_date_byline = mView.findViewById(R.id.publication_date_byline);
            multimedia = mView.findViewById(R.id.multimedia);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.news_item, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        ResultsModel model = resultsList.get(position);

        holder.display_title.setText(model.getDisplay_title());
        if(!model.getMpaa_rating().isEmpty())
            holder.mpaa_rating.setText(String.format(context.getResources().getString(R.string.rated),model.getMpaa_rating()));
        holder.headline.setText(model.getHeadline());
        holder.summary_short.setText(model.getSummary_short());
        holder.publication_date_byline.setText(String.format(context.getResources().getString(R.string.published_date_name), model.getByline(), model.getPublication_date()));

        if(model.getMultimedia().getSrc() != null || !model.getMultimedia().getSrc().isEmpty()) {
            Picasso.get().load(model.getMultimedia().getSrc()).into(holder.multimedia);
        } else {
            holder.multimedia.setImageResource(R.drawable.ic_launcher_foreground);
        }

    }

    @Override
    public int getItemCount() {
        return resultsList.size();
    }
}