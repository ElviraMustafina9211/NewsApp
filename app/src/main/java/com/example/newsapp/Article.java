package com.example.newsapp;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Article {
    @SerializedName("webTitle")
    String webTitle;

    @SerializedName("sectionName")
    String sectionName;

    @SerializedName("webPublicationDate")
    Date webPublicationDate;

    @SerializedName("webUrl")
    String webUrl;

    @Override
    public String toString() {
        return "Article{" +
                "webTitle='" + webTitle + '\'' +
                ", sectionName='" + sectionName + '\'' +
                ", webPublicationDate=" + webPublicationDate +
                ", webUrl='" + webUrl + '\'' +
                '}';
    }
}
