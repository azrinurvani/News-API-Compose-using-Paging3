package com.azrinurvani.newsapicompose.di

import android.util.Log
import com.azrinurvani.newsapicompose.BuildConfig
import com.azrinurvani.newsapicompose.data.HeadlinesApiService
import com.azrinurvani.newsapicompose.data.repository.HeadlineRepositoryImpl
import com.azrinurvani.newsapicompose.domain.repository.HeadlineRepository
import com.azrinurvani.newsapicompose.domain.use_case.FetchNewsArticleUseCase
import com.azrinurvani.newsapicompose.domain.use_case.FetchSearchNewsArticleUseCase
import com.azrinurvani.newsapicompose.domain.use_case.HeadlineUseCases
import com.azrinurvani.newsapicompose.util.Constants.CALL_TIMEOUT
import com.azrinurvani.newsapicompose.util.Constants.CONNECT_TIMEOUT
import com.azrinurvani.newsapicompose.util.Constants.READ_TIMEOUT
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideOkHttpClient() : OkHttpClient {
        val interceptor = HttpLoggingInterceptor { message ->
            Log.d("News-API", "log: $message")
        }.apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        return OkHttpClient.Builder()
            .addInterceptor(
                interceptor
            ).connectTimeout(
                timeout = CONNECT_TIMEOUT,
                TimeUnit.SECONDS
            )
            .readTimeout(
                timeout = READ_TIMEOUT,
                TimeUnit.SECONDS
            )
            .callTimeout(
                timeout = CALL_TIMEOUT,
                TimeUnit.SECONDS
            )
            .build()
    }

    @Provides
    fun provideRetrofitBuilder(httpClient: OkHttpClient) : Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(httpClient)
            .build()
    }

    @Provides
    fun provideHeadlineApi(retrofit : Retrofit) : HeadlinesApiService {
        return retrofit.create(HeadlinesApiService::class.java)
    }

    @Provides
    fun provideHeadlineRepository(
        headlineApi : HeadlinesApiService
    ) : HeadlineRepository {
        return HeadlineRepositoryImpl(headlineApi)
    }

    @Provides
    fun provideHeadlineUseCases(
        headlineRepository : HeadlineRepository
    ) : HeadlineUseCases {
        return HeadlineUseCases(
            fetchNewsArticleUseCase = FetchNewsArticleUseCase(
                headlineRepository
            ),
            fetchSearchNewsArticleUseCase = FetchSearchNewsArticleUseCase(
                headlineRepository
            )
        )
    }

}