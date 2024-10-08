package com.azrinurvani.newsapicompose.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NewsRemoteDto(
    @SerialName("articles")
    val articles: List<ArticleRemoteDto> = listOf(),
    @SerialName("status")
    val status: String = "",
    @SerialName("totalResults")
    val totalResults: Int = 0
)

@Serializable
data class ArticleRemoteDto(
    @SerialName("author")
    val author: String = "",
    @SerialName("content")
    val content: String? = null,
    @SerialName("description")
    val description: String? = null,
    @SerialName("publishedAt")
    val publishedAt: String = "",
    @SerialName("source")
    val source: SourceRemoteDto = SourceRemoteDto(),
    @SerialName("title")
    val title: String = "",
    @SerialName("url")
    val url: String = "",
    @SerialName("urlToImage")
    val urlToImage: String? = null
)

@Serializable
data class SourceRemoteDto(
    @SerialName("id")
    val id: String = "",
    @SerialName("name")
    val name: String = ""
)