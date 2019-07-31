package com.takehome.opentabletakehome.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.takehome.opentabletakehome.R;
import com.takehome.opentabletakehome.base.AppComponent;
import com.takehome.opentabletakehome.base.BaseActivity;
import com.takehome.opentabletakehome.base.DaggerNewsComponent;
import com.takehome.opentabletakehome.base.IPresenter;
import com.takehome.opentabletakehome.base.NewsModule;
import com.takehome.opentabletakehome.models.ResultsModel;
import com.takehome.opentabletakehome.network.InternetListener;
import com.takehome.opentabletakehome.network.NetworkUtil;
import com.takehome.opentabletakehome.service.NyTimesService;
import com.takehome.opentabletakehome.service.RetrofitClientInstance;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by nivesuresh on 7/25/19.
 */

public class NewsActivity extends BaseActivity implements NewsView, InternetListener {
    @Inject
    IPresenter presenter;

    private NewsAdapter adapter;
    private NyTimesService service;
    private RecyclerView cardView;
    private boolean loading = true;
    private int previousTotal = 0;

    @Override
    protected void setupComponent(AppComponent appComponent) {

        DaggerNewsComponent.builder()
                .appComponent(appComponent)
                .newsModule(new NewsModule(this, this))
                .build()
                .inject(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        cardView = findViewById(R.id.card_view);

        final LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        cardView.setLayoutManager(llm);

        RetrofitClientInstance.setInternetListener(this);

        presenter.getFirstPageResults();

        cardView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);

            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                int totalItemCount = llm.getItemCount();
                int visibleItemCount = recyclerView.getChildCount();
                int firstVisibleItemPosition = llm.findFirstVisibleItemPosition();

                if(loading) {
                    if(totalItemCount > previousTotal) {
                        loading = false;
                        previousTotal = totalItemCount;
                    }
                }

                if(!loading
                        && NetworkUtil.isOnline(NewsActivity.this)
                        && presenter.hasMore()
                        && visibleItemCount + firstVisibleItemPosition >= totalItemCount
                        && firstVisibleItemPosition >= 0) {
                    presenter.getNextResults();
                    loading = true;
                }
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        RetrofitClientInstance.removeInternetListener();
    }

    @Override
    public void updateResults(List<ResultsModel> resultsList) {
        generateDataList(resultsList);
    }

    /**
     * This method is so that we don't set the adapter everytime we paginate.
     * That takes us back to the top every time we load more data from server.
     */
    @Override
    public void addToResults() {
        adapter.notifyDataSetChanged();
    }

    private void generateDataList(List<ResultsModel> resultsList) {
        adapter = new NewsAdapter(this, resultsList);
        cardView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onInternetUnavailable() {
        View view = findViewById(R.id.constraint_layout);
        Snackbar.make(view, R.string.no_internet, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void onCacheUnavailable() {
        View view = findViewById(R.id.constraint_layout);
        Snackbar.make(view, R.string.no_content_available, Snackbar.LENGTH_SHORT).show();
    }
}
