package com.sky.recruitmenttest.data.repository

import com.sky.recruitmenttest.data.remote.dto.MovieDto
import com.sky.recruitmenttest.data.remote.MovieApi
import com.sky.recruitmenttest.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val api: MovieApi
) : MovieRepository {

    override suspend fun getMovies(): List<MovieDto> {
        return api.getMovies()
    }
}
