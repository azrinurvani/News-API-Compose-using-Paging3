package com.azrinurvani.newsapicompose.presentation.headline_screen

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.azrinurvani.newsapicompose.domain.model.NewsArticle
import com.azrinurvani.newsapicompose.domain.use_case.HeadlineUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HeadlineViewModel @Inject constructor(
    private val headlineUseCases: HeadlineUseCases
) : ViewModel() {

    //newsArticles can't add to HeadlineScreenState as param because need to set LazyPagingItems
    //and LazyPagingItems need coroutine scope to launch
    private val _newsArticles = MutableStateFlow<PagingData<NewsArticle>>(PagingData.empty())
    val newsArticle = _newsArticles

    var state by mutableStateOf(HeadlineScreenState())

    private var searchJob : Job? = null

    fun onEvent(event : HeadlineScreenEvent){
        when (event){
            is HeadlineScreenEvent.OnCategoryChange -> {
                state = state.copy(category = event.category)
                getNewsArticles(category = event.category)
            }
            is HeadlineScreenEvent.OnNewsCardArticleClicked -> {
                state = state.copy(selectedArticle = event.article)
            }
            HeadlineScreenEvent.OnSearchIconClicked -> {
                _newsArticles.value = PagingData.empty()
                state = state.copy(
                    isSearchVisible = true
                )
            }
            HeadlineScreenEvent.OnCloseIconClicked -> {
                state = state.copy(
                    isSearchVisible = false
                )
                getNewsArticles(category = state.category)
            }
            is HeadlineScreenEvent.OnSearchQueryChange -> {
                state = state.copy(
                    searchQuery = event.searchQuery
                )
                searchJob?.cancel()
                searchJob = viewModelScope.launch {
                    delay(1000L) //set delay 1000 ms before retrieve search api
                    searchForNews(
                        searchQuery = state.searchQuery
                    )
                }

            }
        }
    }

    private fun getNewsArticles(category : String){
        viewModelScope.launch {
            try {
                headlineUseCases.fetchNewsArticleUseCase(
                    category = category
                ).cachedIn(viewModelScope)
                .collect{
//                    state = state.copy(
////                        articles = it,
//                        isLoading = false,
//                        error = null
//                    )
                    _newsArticles.value = it
                }
            }catch (e : Exception){
//                state = state.copy(
////                    articles = PagingData.empty(),
//                    isLoading = false,
//                    error = e.message
//                )
                Log.e(javaClass.name, "getNewsArticles: ${e.message}")
            }
        }
    }

    private fun searchForNews(searchQuery : String){
        if (searchQuery.isEmpty()){
            return
        }
        viewModelScope.launch {
            try {
                headlineUseCases.fetchSearchNewsArticleUseCase(
                    searchQuery = searchQuery
                ).collect{
//                    state = state.copy(
//                        isLoading = false,
//                        error = null
//                    )
                    _newsArticles.value = it
                }
            }catch (e: Exception){
//                state = state.copy(
//                    isLoading = false,
//                    error = e.message
//                )
                Log.e(javaClass.name, "getNewsArticles: ${e.message}")
            }
        }
    }

//    val articles : StateFlow<PagingData<NewsArticle>> = headlineUseCases.fetchNewsArticleUseCase(
//        category = "business"
//    )
//        .catch {  exception -> //catch the exception
//            Log.e(javaClass.simpleName, ": ", )
////            _snackBarEvent.send(
////                SnackBarEvent(message = "Something went wrong. ${exception.message}")
////            )
//        }
//        .cachedIn(viewModelScope) //using PagingData always using cachedIn(viewModelScope)
//        .stateIn(
//            scope = viewModelScope,
//            started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5000),
//            initialValue = PagingData.empty()
//        )
}