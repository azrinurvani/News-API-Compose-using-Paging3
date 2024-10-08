package com.azrinurvani.newsapicompose.domain.use_case

data class HeadlineUseCases(
    val fetchNewsArticleUseCase: FetchNewsArticleUseCase,
    val fetchSearchNewsArticleUseCase: FetchSearchNewsArticleUseCase
    //add new use case here
)
