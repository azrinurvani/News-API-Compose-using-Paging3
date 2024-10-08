package com.azrinurvani.newsapicompose.util

import com.azrinurvani.newsapicompose.BuildConfig

object Constants {

    val API_KEY = BuildConfig.NEWS_API_KEY
    val CONNECT_TIMEOUT = 120L
    val READ_TIMEOUT = 120L
    val CALL_TIMEOUT = 120L

    val ITEMS_PER_PAGE = 10
}