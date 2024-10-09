package com.azrinurvani.newsapicompose.presentation.headline_screen

import com.azrinurvani.newsapicompose.domain.model.NewsArticle

data class HeadlineScreenState(
//    val isLoading : Boolean = false, //loading dan error telah di handle di di paging3
//    val articles : PagingData<NewsArticle> = PagingData.empty(),
//    val error : String? = null,
    val isSearchVisible : Boolean = false,
    val selectedArticle: NewsArticle? = null,
    val category : String = "General",
    val searchQuery : String = ""
)