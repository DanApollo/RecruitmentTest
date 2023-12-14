package com.sky.recruitmenttest.moviesearch.di

import com.sky.recruitmenttest.moviesearch.data.repository.MovieRepositoryImpl
import com.sky.recruitmenttest.moviesearch.domain.repository.MovieRepository
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
