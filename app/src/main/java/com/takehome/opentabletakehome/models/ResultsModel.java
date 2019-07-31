package com.takehome.opentabletakehome.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by nivesuresh on 7/24/19.
 */

public class ResultsModel {
    @SerializedName("display_title")
    String display_title;

    @SerializedName("mpaa_rating")
    String mpaa_rating;

    @SerializedName("critics_pick")
    int critics_pick;

    @SerializedName("byline")
    String byline;

    @SerializedName("headline")
    String headline;

    @SerializedName("summary_short")
    String summary_short;

    @SerializedName("publication_date")
    String publication_date;

    @SerializedName("opening_date")
    String opening_date;

    @SerializedName("date_updated")
    String date_updated;

    @SerializedName("link")
    LinkModel link;

    @SerializedName("multimedia")
    MultimediaModel multimedia;

    public String getDisplay_title() {
        return display_title;
    }

    public void setDisplay_title(String display_title) {
        this.display_title = display_title;
    }

    public String getMpaa_rating() {
        return mpaa_rating;
    }

    public void setMpaa_rating(String mpaa_rating) {
        this.mpaa_rating = mpaa_rating;
    }

    public int getCritics_pick() {
        return critics_pick;
    }

    public void setCritics_pick(int critics_pick) {
        this.critics_pick = critics_pick;
    }

    public String getByline() {
        return byline;
    }

    public void setByline(String byline) {
        this.byline = byline;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getSummary_short() {
        return summary_short;
    }

    public void setSummary_short(String summary_short) {
        this.summary_short = summary_short;
    }

    public String getPublication_date() {
        return publication_date;
    }

    public void setPublication_date(String publication_date) {
        this.publication_date = publication_date;
    }

    public String getOpening_date() {
        return opening_date;
    }

    public void setOpening_date(String opening_date) {
        this.opening_date = opening_date;
    }

    public String getDate_updated() {
        return date_updated;
    }

    public void setDate_updated(String date_updated) {
        this.date_updated = date_updated;
    }

    public LinkModel getLink() {
        return link;
    }

    public void setLink(LinkModel link) {
        this.link = link;
    }

    public MultimediaModel getMultimedia() {
        return multimedia;
    }

    public void setMultimedia(MultimediaModel multimedia) {
        this.multimedia = multimedia;
    }
}
