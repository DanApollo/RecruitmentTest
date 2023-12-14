package com.sky.recruitmenttest.moviesearch.domain.repository

import com.sky.recruitmenttest.core.util.Resource
import com.sky.recruitmenttest.moviesearch.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    suspend fun getMovies(): Flow<Resource<List<Movie>>>
}
