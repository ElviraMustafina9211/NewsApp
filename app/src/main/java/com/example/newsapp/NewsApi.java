package com.example.newsapp;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface NewsApi {
    @GET("search?q=debate&tag=politics/politics&from-date=2014-01-01&api-key=test")
    Single<News> getNews();
}