package com.azrinurvani.newsapicompose.presentation.navigation

import kotlinx.serialization.Serializable

sealed class Routes {

    @Serializable
    data object HeadlineScreen : Routes()
}