package com.sky.recruitmenttest.domain.repository

import com.sky.recruitmenttest.data.remote.dto.MovieDto

interface MovieRepository {

    suspend fun getMovies(): List<MovieDto>
}
