package com.example.newsapp

import io.mockk.every
import io.mockk.just
import io.mockk.runs
import io.mockk.spyk
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class NewsAdapterTest {

    @Test
    fun `compare with others view types`() {
        //Arrange
        val expectedViewType = NewsAdapter.OTHER_TYPE
        val expectedPosition = 0
        val article = Article()
        article.sectionName = "Environment"
        val adapter = spyk(NewsAdapter())
        every { adapter.notifyDataSetChanged() } just runs
        adapter.setArticles(listOf(article))

        //Act
        val actualViewType = adapter.getItemViewType(expectedPosition)

        //Assert
        assertThat(actualViewType).isEqualTo(expectedViewType)
    }

    @Test
    fun `compare with politics view types`() {
        //Arrange
        val expectedViewType = NewsAdapter.POLITICS_TYPE
        val expectedPosition = 0
        val article = Article()
        article.sectionName = "Politics"
        val adapter = spyk(NewsAdapter())
        every { adapter.notifyDataSetChanged() } just runs
        adapter.setArticles(listOf(article))

        //Act
        val actualViewType = adapter.getItemViewType(expectedPosition)

        //Assert
        assertThat(actualViewType).isEqualTo(expectedViewType)
    }

    @Test
    fun `compare with business view types`() {
        //Arrange
        val expectedViewType = NewsAdapter.BUSINESS_TYPE
        val expectedPosition = 0
        val article = Article()
        article.sectionName = "Business"
        val adapter = spyk(NewsAdapter())
        every { adapter.notifyDataSetChanged() } just runs
        adapter.setArticles(listOf(article))

        //Act
        val actualViewType = adapter.getItemViewType(expectedPosition)

        //Assert
        assertThat(actualViewType).isEqualTo(expectedViewType)
    }

    @Test
    fun `compare with opinion view types`() {
        //Arrange
        val expectedViewType = NewsAdapter.OPINION_TYPE
        val expectedPosition = 0
        val article = Article()
        article.sectionName = "Opinion"
        val adapter = spyk(NewsAdapter())
        every { adapter.notifyDataSetChanged() } just runs
        adapter.setArticles(listOf(article))

        //Act
        val actualViewType = adapter.getItemViewType(expectedPosition)

        //Assert
        assertThat(actualViewType).isEqualTo(expectedViewType)
    }
}