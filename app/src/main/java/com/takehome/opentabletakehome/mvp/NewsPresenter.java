package com.takehome.opentabletakehome.mvp;

import android.content.Context;

import com.takehome.opentabletakehome.R;
import com.takehome.opentabletakehome.base.IPresenter;
import com.takehome.opentabletakehome.models.ResultsModel;
import com.takehome.opentabletakehome.models.ReviewsInfoModel;
import com.takehome.opentabletakehome.service.NyTimesService;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by nivesuresh on 7/25/19.
 */

public class NewsPresenter implements IPresenter {
    private NewsView newsView;
    private NyTimesService service;
    public boolean hasMore = false;
    int offset = 0;
    private Context context;
    private List<ResultsModel> resultsModel = new ArrayList<>();

    public NewsPresenter(Context context, NewsView newsView, NyTimesService service) {
        this.newsView = newsView;
        this.service = service;
        this.context = context;
    }

    @Override
    public boolean hasMore() {
        return hasMore;
    }

    @Override
    public void getFirstPageResults() {
        getObservable().subscribeWith(getObserver());
    }

    @Override
    public void getNextResults() {
        getObservable().subscribeWith(getNextObserver());
    }

    public Observable<ReviewsInfoModel> getObservable(){
        return service.getReviews("by-date",
                        context.getString(R.string.api_key),
                        offset)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public DisposableObserver<ReviewsInfoModel> getObserver(){
        return new DisposableObserver<ReviewsInfoModel>() {

            @Override
            public void onNext(@NonNull ReviewsInfoModel reviewsInfoResponse) {
                hasMore = reviewsInfoResponse.isHas_more();
                offset += reviewsInfoResponse.getNum_results();
                resultsModel.addAll(reviewsInfoResponse.getResults());
                newsView.updateResults(resultsModel);
            }

            @Override
            public void onError(@NonNull Throwable e) {
            }

            @Override
            public void onComplete() {

            }
        };
    }

    /**
     * Pretty similar method to getObserver(), but instead of calling for the
     * method that sets the adapter, we're just notifying the adapter with
     * the newest additions
     */
    public DisposableObserver<ReviewsInfoModel> getNextObserver(){
        return new DisposableObserver<ReviewsInfoModel>() {

            @Override
            public void onNext(@NonNull ReviewsInfoModel reviewsInfoResponse) {
                hasMore = reviewsInfoResponse.isHas_more();
                offset += reviewsInfoResponse.getNum_results();
                resultsModel.addAll(reviewsInfoResponse.getResults());
                newsView.addToResults();
            }

            @Override
            public void onError(@NonNull Throwable e) {
            }

            @Override
            public void onComplete() {

            }
        };
    }
}
