package com.takehome.opentabletakehome.service;

import com.takehome.opentabletakehome.models.ReviewsInfoModel;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by nivesuresh on 7/24/19.
 */

public interface NyTimesService {
    @GET("reviews/dvd-picks.json?")
    Observable<ReviewsInfoModel> getReviews(@Query("order") String order, @Query("api-key") String apiKey,
                                            @Query("offset") int offset);

}