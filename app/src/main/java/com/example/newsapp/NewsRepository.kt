package com.example.newsapp

import io.reactivex.Single

class NewsRepository (private val newsApi: NewsApi) {

    fun getArticles(): Single<News> {
        return newsApi.news
    }
}