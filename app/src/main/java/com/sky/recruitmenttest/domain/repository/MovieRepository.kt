package com.sky.recruitmenttest.domain.repository

import com.sky.recruitmenttest.data.models.MovieDto

interface MovieRepository {

    suspend fun getMovies(): List<MovieDto>
}
