package com.azrinurvani.newsapicompose.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
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
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        if(articles.loadState.refresh is LoadState.Loading){
            CircularProgressIndicator()
        }
        if(articles.loadState.refresh is LoadState.Error){
            RetryContent(
                modifier = modifier,
                error = "Error loading articles data",
                onRetry = onRetry
            )
        }
    }

}