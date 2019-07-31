package com.takehome.opentabletakehome.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by nivesuresh on 7/24/19.
 */

public class MultimediaModel {
    @SerializedName("type")
    String type;

    @SerializedName("src")
    String src;

    @SerializedName("width")
    int width;

    @SerializedName("height")
    int height;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
