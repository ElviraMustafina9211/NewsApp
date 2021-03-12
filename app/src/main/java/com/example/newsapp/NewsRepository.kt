package com.example.newsapp

import io.reactivex.Single

interface NewsRepository {
    fun getArticles(): Single<News>
}