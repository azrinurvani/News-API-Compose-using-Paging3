package com.azrinurvani.newsapicompose.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.azrinurvani.newsapicompose.domain.model.NewsArticle

//list article card vertical
@Composable
fun NewsListVertical(
    modifier: Modifier = Modifier,
//    state: HeadlineScreenState,
    articles : LazyPagingItems<NewsArticle>,
    onCardClicked : (NewsArticle?) -> Unit,
    onRetry : () -> Unit,
){

    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(count = articles.itemCount) { index ->
            NewsCard (
                article = articles[index],
                modifier = modifier,
                onCardClick = onCardClicked
            )
        }
    }
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 12.dp),
        contentAlignment = Alignment.Center
    ){
        if(articles.loadState.refresh is LoadState.Loading){
            CircularProgressIndicator()
        }
        if(articles.loadState.refresh is LoadState.Error){
            val e =  articles.loadState.refresh as LoadState.Error
//            var message = ""
//
//            when (val throwable = e.error) {
//                is UnknownHostException -> {
//                    message = "No Internet Connection, please check your Internet Connection"
//                }
//
//                is HttpException -> {
//                    val errorCode = throwable.response.code
//                    if (errorCode == 401){
//                        message = "401 Unauthorized Error"
//                    }
//                    if (errorCode == 403){
//                        message = "403 Forbidden, your token expired"
//                    }
//                    if (errorCode == 404){
//                        message = "404 Not Found"
//                    }
//                    if (errorCode == 502){
//                        message = "502 Internal Server error"
//                    }
//                }
//                else -> {
//                    message = e.error.message.toString()
//                }
//            }
            RetryContent(
                modifier = modifier.align(Alignment.Center),
                error = e.error.message.toString(),
                onRetry = onRetry
            )
        }
//        if (state.error != null){
//            RetryContent(
//                modifier = modifier,
//                error = state.error,
//                onRetry = onRetry
//            )
//        }
    }

}