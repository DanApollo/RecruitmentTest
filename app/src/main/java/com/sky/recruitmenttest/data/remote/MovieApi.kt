package com.sky.recruitmenttest.data.remote

import com.sky.recruitmenttest.data.remote.dto.MovieDto
import retrofit2.http.GET

interface MovieApi {

    @GET("./")
    suspend fun getMovies(): List<MovieDto>
}
