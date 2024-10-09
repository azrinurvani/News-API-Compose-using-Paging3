package com.azrinurvani.newsapicompose.presentation.headline_screen

import com.azrinurvani.newsapicompose.domain.model.NewsArticle

sealed class HeadlineScreenEvent {

    data class OnNewsCardArticleClicked(val article: NewsArticle?) : HeadlineScreenEvent()
    data class OnCategoryChange(val category: String) : HeadlineScreenEvent()
    data class OnSearchQueryChange(val searchQuery: String) : HeadlineScreenEvent()
    data object OnSearchIconClicked : HeadlineScreenEvent()
    data object OnCloseIconClicked : HeadlineScreenEvent()
}