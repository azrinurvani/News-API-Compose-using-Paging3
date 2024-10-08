package com.azrinurvani.newsapicompose.data.mapper

import com.azrinurvani.newsapicompose.data.remote.dto.ArticleRemoteDto
import com.azrinurvani.newsapicompose.domain.model.NewsArticle

fun ArticleRemoteDto.toDomainModel(category: String?) : NewsArticle{
    return NewsArticle(
        author = this.author,
        content = this.content ?: "",
        title = this.title,
        description = this.description ?: "",
        sourceName = this.source.name,
        url = this.url,
        category = category ?: "",
        urlToImage = this.urlToImage,
        publishedAt = this.publishedAt
    )
}

fun List<ArticleRemoteDto>.toDomainModelList(category: String?) : List<NewsArticle>{
    return this.map { it.toDomainModel(category = category) }
}