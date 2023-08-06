package com.sky.recruitmenttest.domain.repository

import com.sky.recruitmenttest.data.models.Movie

interface MovieRepository {

    suspend fun getMovies(): List<Movie>
}
