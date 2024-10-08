package com.azrinurvani.newsapicompose.presentation.headline_screen

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.paging.compose.LazyPagingItems
import com.azrinurvani.newsapicompose.domain.model.NewsArticle
import com.azrinurvani.newsapicompose.presentation.component.BottomSheetContent
import com.azrinurvani.newsapicompose.presentation.component.CategoryTabRow
import com.azrinurvani.newsapicompose.presentation.component.NewsListVertical
import com.azrinurvani.newsapicompose.presentation.component.NewsTopBar
import com.azrinurvani.newsapicompose.presentation.component.SearchAppBar
import com.azrinurvani.newsapicompose.util.categories
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeadlineScreen(
    modifier: Modifier = Modifier,
    state : HeadlineScreenState,
    onEvent: (HeadlineScreenEvent) -> Unit,
    articles : LazyPagingItems<NewsArticle>,
    onReadFullStoryButtonClick: (String) -> Unit
){

    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    val coroutineScope = rememberCoroutineScope()
    val pagerState = rememberPagerState(
        pageCount = { categories.size }
    )

    val focusRequester = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current

    LaunchedEffect(key1 = pagerState) {
        snapshotFlow {
            pagerState.currentPage
        }.collect{ page ->
            onEvent(HeadlineScreenEvent.OnCategoryChange(category = categories[page]))
        }
    }

    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    var shouldBottomSheetShow by remember { mutableStateOf(false) }

    if (shouldBottomSheetShow){
        ModalBottomSheet(
            onDismissRequest = { shouldBottomSheetShow = false },
            sheetState = sheetState,
            content = {
                state.selectedArticle?.let {
                    BottomSheetContent(
                        article = it,
                        onReadyFullStoryButtonClicked = {
                            onReadFullStoryButtonClick(it.url)
                            coroutineScope.launch {
                                sheetState.hide()
                            }.invokeOnCompletion {
                                if (!sheetState.isVisible) shouldBottomSheetShow = false
                            }
                        }
                    )
                }
            }
        )
    }

    LaunchedEffect(key1 = Unit) {
        if (state.searchQuery.isNotEmpty()){
            onEvent(HeadlineScreenEvent.OnSearchQueryChange(searchQuery = state.searchQuery))
        }
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Crossfade(targetState = state.isSearchVisible) { isVisible ->
            if (isVisible) {
                Column {
                    SearchAppBar(
                        modifier = Modifier.focusRequester(focusRequester),
                        value = state.searchQuery,
                        onValueChange = { newValue ->
                            onEvent(HeadlineScreenEvent.OnSearchQueryChange(newValue))
                        },
                        onCloseIconClicked = {
                            onEvent(HeadlineScreenEvent.OnCloseIconClicked)
                        },
                        onSearchClicked = {
                            keyboardController?.hide()
                            focusManager.clearFocus()
                        }
                    )
                    NewsListVertical(
                        modifier = modifier,
//                        state = state,
                        articles = articles,
                        onCardClicked = { article ->
                            shouldBottomSheetShow = true
                            onEvent(HeadlineScreenEvent.OnNewsCardArticleClicked(article = article))
                        },
                        onRetry = {
                            onEvent(HeadlineScreenEvent.OnSearchQueryChange(searchQuery = state.searchQuery))
                        }
                    )
                }
            } else {
                Scaffold(
                    modifier = Modifier
                        .nestedScroll(scrollBehavior.nestedScrollConnection),
                    topBar = {
                        NewsTopBar(
                            scrollBehavior = scrollBehavior,
                            onSearchIconClicked = {
                                onEvent(HeadlineScreenEvent.OnSearchIconClicked)
                                coroutineScope.launch {
                                    delay(500)
                                    focusRequester.requestFocus()
                                }
                            }
                        )
                    }
                ) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) {
                        CategoryTabRow(
                            pagerState = pagerState,
                            categories = categories,
                            onTabSelected = { index ->
                                coroutineScope.launch {
                                    pagerState.animateScrollToPage(index)
                                }
                            }
                        )
                        HorizontalPager(
                            state = pagerState
                        ){
                            NewsListVertical(
                                modifier = modifier,
//                                state = state,
                                articles = articles,
                                onCardClicked = { article ->
                                    shouldBottomSheetShow = true
                                    onEvent(HeadlineScreenEvent.OnNewsCardArticleClicked(article = article))
                                },
                                onRetry = {
                                    onEvent(HeadlineScreenEvent.OnCategoryChange(category = state.category))
                                }
                            )
                        }

                    }
                }
            }
        }
    }



}

