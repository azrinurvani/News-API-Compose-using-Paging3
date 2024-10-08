package com.azrinurvani.newsapicompose.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.azrinurvani.newsapicompose.presentation.navigation.NavGraphSetup
import com.azrinurvani.newsapicompose.presentation.theme.NewsAPIComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            NewsAPIComposeTheme {
                val navController = rememberNavController()
                NavGraphSetup(
                    navController = navController
                )
            }
        }
    }
}
