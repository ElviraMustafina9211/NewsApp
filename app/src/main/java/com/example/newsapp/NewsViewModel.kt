package com.example.newsapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class NewsViewModel(private val newsRepository: NewsRepository) : ViewModel() {

    private val _articles: MutableLiveData<List<Article>>  = MutableLiveData<List<Article>>()
    var articles: LiveData<List<Article>> = _articles

    init {
        println("jopa")
    }

    private var disposable: Disposable? = null
    override fun onCleared() {
        super.onCleared()
        disposable?.dispose()
    }

    fun getArticles() {
        disposable = newsRepository
                .getArticles()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ news: News -> _articles.setValue(news.response.results) }
                ) { println("oshibka") }
    }
}