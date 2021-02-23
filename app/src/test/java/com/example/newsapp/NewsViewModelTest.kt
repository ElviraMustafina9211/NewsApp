package com.example.newsapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import io.mockk.every
import io.mockk.mockk
import io.reactivex.Single
import org.assertj.core.api.Assertions.assertThat
import org.junit.Rule
import org.junit.Test

class NewsViewModelTest {

    @Rule
    @JvmField
    var testSchedulerRule = RxImmediateSchedulerRule()

    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    @Test
    fun constructor_dataRetrieved() {
        // Arrange
        val expectedArticles = listOf(Article())

        val expectedNews = News().apply {
            response = NewsResponse().apply {
                results = expectedArticles
            }
        }

        val expectedSingle = Single.just(expectedNews)
        val mockRepository = mockk<NewsRepository> {
            every { getArticles() } returns expectedSingle
        }
        val newsViewModel = NewsViewModel(mockRepository)

        // Act
        newsViewModel.getArticles()

        // Assert
        assertThat(newsViewModel.articles.value).isEqualTo(expectedArticles)
    }

    @Test
    fun `constructor failed to retrieve data`() {
        // Arrange
        val expectedArticles = null
        val expectedSingle = Single.error<News>(Throwable("jopa kota"))
        val mockRepository = mockk<NewsRepository> {
            every { getArticles() } returns expectedSingle
        }

        // Act
        val newsViewModel = NewsViewModel(mockRepository)

        // Assert
        assertThat(newsViewModel.articles.value).isEqualTo(expectedArticles)
    }
}