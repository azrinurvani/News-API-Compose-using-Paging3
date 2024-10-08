package com.azrinurvani.newsapicompose.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.paging.compose.collectAsLazyPagingItems
import com.azrinurvani.newsapicompose.presentation.headline.HeadlineScreen
import com.azrinurvani.newsapicompose.presentation.headline.HeadlineViewModel

@Composable
fun NavGraphSetup(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Routes.HeadlineScreen
    ){
        composable<Routes.HeadlineScreen> {
            val headlineViewModel : HeadlineViewModel = hiltViewModel()
            val articles = headlineViewModel.newsArticle.collectAsLazyPagingItems()
            HeadlineScreen(
                articles = articles,
                state = headlineViewModel.state,
                onEvent = headlineViewModel::onEvent
            )
        }
    }
}