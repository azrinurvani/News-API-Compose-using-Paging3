package com.azrinurvani.newsapicompose.data

import com.azrinurvani.newsapicompose.data.remote.dto.NewsRemoteDto
import com.azrinurvani.newsapicompose.util.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface HeadlinesApiService {

    companion object{
        const val HEADLINE_END_POINT = "/v2/top-headlines"
        const val SEARCH_END_POINT = "/v2/everything"
    }

    @GET(HEADLINE_END_POINT)
    suspend fun getHeadlines(
        @Query("apiKey") key: String = API_KEY,
        @Query("category") category: String,
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int
    ) : NewsRemoteDto

    @GET(SEARCH_END_POINT)
    suspend fun searchForNews(
        @Query("apiKey") apiKey: String = API_KEY,
        @Query("q") query: String,
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int
    ): NewsRemoteDto


}