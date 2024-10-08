package com.azrinurvani.newsapicompose.domain.use_case

import androidx.paging.PagingData
import com.azrinurvani.newsapicompose.domain.model.NewsArticle
import com.azrinurvani.newsapicompose.domain.repository.HeadlineRepository
import kotlinx.coroutines.flow.Flow

class FetchSearchNewsArticleUseCase(
    private val repository: HeadlineRepository
) {
    operator fun invoke(
        searchQuery : String
    ): Flow<PagingData<NewsArticle>> = repository.searchForNews(searchQuery)
}