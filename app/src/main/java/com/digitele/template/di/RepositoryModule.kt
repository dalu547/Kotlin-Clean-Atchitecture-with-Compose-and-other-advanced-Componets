package com.digitele.template.di

import com.digitele.template.data.datasource.remote.MyApiService
import com.digitele.template.data.repository.PostRepositoryImpl
import com.digitele.template.domain.repository.PostRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun providePostRepository(api: MyApiService): PostRepository =
        PostRepositoryImpl(api)
}