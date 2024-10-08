package com.azrinurvani.newsapicompose.presentation.headline

import com.azrinurvani.newsapicompose.domain.model.NewsArticle

data class HeadlineScreenState(
    val isLoading : Boolean = false,
//    val articles : PagingData<NewsArticle> = PagingData.empty(),
    val error : String? = null,
    val isSearchVisible : Boolean = false,
    val selectedArticle: NewsArticle? = null,
    val category : String = "General",
    val searchQuery : String = ""
)