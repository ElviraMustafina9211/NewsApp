package com.example.newsapp


object Injector {
    val instance: AppComponent by lazy { DaggerAppComponent.create() }
}