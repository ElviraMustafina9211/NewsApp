package com.example.newsapp

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn (ApplicationComponent::class)
object AppModule {

    @Provides
    fun newsRepository(newsApi: NewsApi): NewsRepository {
        return NewsRepository(newsApi)
    }

    @Provides
    fun newsViewModelFactory(newsRepository: NewsRepository): NewsViewModelFactory {
        return NewsViewModelFactory(newsRepository)
    }

    @Provides
    fun newsApi(): NewsApi {
        val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl("https://content.guardianapis.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        return retrofit.create(NewsApi::class.java)
    }
}