package com.sky.recruitmenttest.feature_moviesearch.domain.repository

import com.sky.recruitmenttest.core.util.Resource
import com.sky.recruitmenttest.feature_moviesearch.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    suspend fun getMovies(): Flow<Resource<List<Movie>>>
}
