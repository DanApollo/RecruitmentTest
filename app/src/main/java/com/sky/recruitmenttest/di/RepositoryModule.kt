package com.sky.recruitmenttest.di

import com.sky.recruitmenttest.data.repository.MovieRepositoryImpl
import com.sky.recruitmenttest.domain.repository.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindMyRepository(
        movieRepositoryImpl: MovieRepositoryImpl
    ): MovieRepository
}
