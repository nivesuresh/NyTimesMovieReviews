package com.takehome.opentabletakehome.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by nivesuresh on 7/24/19.
 */

public class ReviewsInfoModel {
    @SerializedName("status")
    String status;

    @SerializedName("copyright")
    String copyright;

    @SerializedName("has_more")
    boolean has_more;

    @SerializedName("num_results")
    int num_results;

    @SerializedName("results")
    List<ResultsModel> results;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public boolean isHas_more() {
        return has_more;
    }

    public void setHas_more(boolean has_more) {
        this.has_more = has_more;
    }

    public int getNum_results() {
        return num_results;
    }

    public void setNum_results(int num_results) {
        this.num_results = num_results;
    }

    public List<ResultsModel> getResults() {
        return results;
    }

    public void setResults(List<ResultsModel> results) {
        this.results = results;
    }
}
