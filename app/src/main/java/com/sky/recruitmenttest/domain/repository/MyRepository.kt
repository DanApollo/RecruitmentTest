package com.sky.recruitmenttest.domain.repository

import com.sky.recruitmenttest.data.models.Movie

interface MyRepository {
    suspend fun getMovies(): List<Movie>
}