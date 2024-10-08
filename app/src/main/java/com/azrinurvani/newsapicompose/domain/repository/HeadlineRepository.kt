package com.azrinurvani.newsapicompose.domain.repository

import androidx.paging.PagingData
import com.azrinurvani.newsapicompose.domain.model.NewsArticle
import kotlinx.coroutines.flow.Flow

interface HeadlineRepository {

    fun getHeadlineArticles(category : String) : Flow<PagingData<NewsArticle>>

}