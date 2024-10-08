package com.azrinurvani.newsapicompose.data.paging

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.azrinurvani.newsapicompose.data.HeadlinesApiService
import com.azrinurvani.newsapicompose.data.mapper.toDomainModelList
import com.azrinurvani.newsapicompose.domain.model.NewsArticle

class ArticlePagingSource(
    private val api : HeadlinesApiService,
    private var category : String = ""
): PagingSource<Int, NewsArticle>() {

    override fun getRefreshKey(state: PagingState<Int, NewsArticle>): Int? {
        Log.d(javaClass.name, "getRefreshKey: ${state.anchorPosition}")
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, NewsArticle> {
        val currentPage = params.key ?: STARTING_PAGE_INDEX
        return try{
            val response = api.getHeadlines(
                category = category,
                page = currentPage,
                pageSize = params.loadSize
            )
            val endOfPaginationReached  = response.articles.isEmpty()
            LoadResult.Page(
                data = response.articles.toDomainModelList(category),
                prevKey = if (currentPage == STARTING_PAGE_INDEX) null else currentPage - 1,
                nextKey = if (endOfPaginationReached) null else currentPage + 1
            )
        }catch (e : Exception){
            Log.e(javaClass.name, "LoadResult.Error ${e.message}")
            return LoadResult.Error(e)
        }
    }

    companion object{
        private const val STARTING_PAGE_INDEX = 1
    }
}