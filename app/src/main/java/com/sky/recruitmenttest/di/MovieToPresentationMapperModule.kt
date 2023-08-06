package com.sky.recruitmenttest.di

import com.sky.recruitmenttest.domain.mapper.MovieToPresentationMapper
import com.sky.recruitmenttest.presentation.mapper.MovieToPresentationMapperImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class MovieToPresentationMapperModule {

    @Binds
    @Singleton
    abstract fun bindMovieToPresentation(
        movieToPresentationMapperImpl: MovieToPresentationMapperImpl
    ): MovieToPresentationMapper
}
