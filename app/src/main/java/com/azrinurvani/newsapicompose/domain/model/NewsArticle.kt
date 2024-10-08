package com.azrinurvani.newsapicompose.domain.model

data class NewsArticle(
//    val id : String,
    val author : String?,
    val content : String,
    val description : String,
    val publishedAt : String,
    val sourceName : String, //sourceName
    val title : String,
    val url : String,
    val urlToImage : String?,
    val category : String
)
