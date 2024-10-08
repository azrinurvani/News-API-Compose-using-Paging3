//package com.azrinurvani.newsapicompose.di
//
//import com.azrinurvani.newsapicompose.data.HeadlinesApiService
//import com.azrinurvani.newsapicompose.data.repository.HeadlineRepositoryImpl
//import com.azrinurvani.newsapicompose.domain.repository.HeadlineRepository
//import com.azrinurvani.newsapicompose.domain.use_case.FetchNewsArticleUseCase
//import com.azrinurvani.newsapicompose.domain.use_case.HeadlineUseCases
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.components.SingletonComponent
//import retrofit2.Retrofit
//
//@Module(
//    includes = [NetworkModule::class]
//)
//@InstallIn(SingletonComponent::class)
//object HeadlineModule {
//
//
//    @Provides
//    fun provideHeadlineApi(retrofit : Retrofit) : HeadlinesApiService{
//        return retrofit.create(HeadlinesApiService::class.java)
//    }
//
//    @Provides
//    fun provideHeadlineRepository(
//        headlineApi : HeadlinesApiService
//    ) : HeadlineRepository{
//        return HeadlineRepositoryImpl(headlineApi)
//    }
//
//    @Provides
//    fun provideHeadlineUseCases(
//        headlineRepository : HeadlineRepository
//    ) : HeadlineUseCases{
//        return HeadlineUseCases(
//            fetchNewsArticleUseCase = FetchNewsArticleUseCase(
//                headlineRepository
//            )
//        )
//    }
//}