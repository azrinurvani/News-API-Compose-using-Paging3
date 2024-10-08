package com.azrinurvani.newsapicompose.domain.use_case

import androidx.paging.PagingData
import com.azrinurvani.newsapicompose.domain.model.NewsArticle
import com.azrinurvani.newsapicompose.domain.repository.HeadlineRepository
import kotlinx.coroutines.flow.Flow

class FetchNewsArticleUseCase(
    private val repository: HeadlineRepository
) {

    operator fun invoke(
        category : String
    ): Flow<PagingData<NewsArticle>> = repository.getHeadlineArticles(category)
}