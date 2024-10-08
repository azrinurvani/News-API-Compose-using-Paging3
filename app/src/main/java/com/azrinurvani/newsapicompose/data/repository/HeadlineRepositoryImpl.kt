package com.azrinurvani.newsapicompose.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.azrinurvani.newsapicompose.data.HeadlinesApiService
import com.azrinurvani.newsapicompose.data.paging.ArticlePagingSource
import com.azrinurvani.newsapicompose.domain.model.NewsArticle
import com.azrinurvani.newsapicompose.domain.repository.HeadlineRepository
import com.azrinurvani.newsapicompose.util.Constants.ITEMS_PER_PAGE
import kotlinx.coroutines.flow.Flow

class HeadlineRepositoryImpl(
    private val headlineApi : HeadlinesApiService
) : HeadlineRepository {

    override fun getHeadlineArticles(category: String): Flow<PagingData<NewsArticle>> {
        return Pager(
            config = PagingConfig(
                initialLoadSize = 10,
                pageSize = ITEMS_PER_PAGE
            ),
            pagingSourceFactory = {
                ArticlePagingSource(
                    category = category,
                    api = headlineApi
                )
            }
        ).flow
    }
}