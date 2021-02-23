package com.example.newsapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var newsViewModelFactory: NewsViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Injector.instance.inject(this)

        val newsViewModel = ViewModelProvider(this, newsViewModelFactory).get(NewsViewModel::class.java)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val newsAdapter = NewsAdapter()

        newsViewModel.getArticles()

        recyclerView.adapter = newsAdapter
        newsViewModel.articles.observe(this, { articles -> newsAdapter.setArticles(articles) })
    }
}