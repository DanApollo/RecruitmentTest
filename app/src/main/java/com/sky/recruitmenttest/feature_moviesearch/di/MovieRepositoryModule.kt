package com.sky.recruitmenttest.feature_moviesearch.di

import com.sky.recruitmenttest.feature_moviesearch.data.repository.MovieRepositoryImpl
import com.sky.recruitmenttest.feature_moviesearch.domain.repository.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class MovieRepositoryModule {

    @Binds
    @Singleton
    abstract fun bindMovieRepository(
        movieRepositoryImpl: MovieRepositoryImpl
    ): MovieRepository
}
