package com.example.newsapp

import io.reactivex.Single

class NewsRepositoryImpl (private val newsApi: NewsApi) : NewsRepository {

    override fun getArticles(): Single<News> {
        return newsApi.news
    }
}