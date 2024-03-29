package com.takehome.opentabletakehome.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by nivesuresh on 7/24/19.
 */

public class LinkModel {
    @SerializedName("type")
    String type;

    @SerializedName("url")
    String url;

    @SerializedName("suggested_link_text")
    String suggested_link_text;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSuggested_link_text() {
        return suggested_link_text;
    }

    public void setSuggested_link_text(String suggested_link_text) {
        this.suggested_link_text = suggested_link_text;
    }
}
