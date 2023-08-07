package com.sky.recruitmenttest.feature_moviesearch.data.remote

import com.sky.recruitmenttest.feature_moviesearch.data.remote.dto.MovieDto
import retrofit2.http.GET

interface MovieApi {

    @GET("./")
    suspend fun getMovies(): List<MovieDto>

    companion object {
        const val BASE_URL = "https://api.npoint.io/759fdfa82d6f33522e11/"
    }
}
