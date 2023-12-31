package com.sky.recruitmenttest.feature_moviesearch.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.sky.recruitmenttest.feature_moviesearch.data.local.entity.MovieEntity

data class MovieDto(
    @SerializedName("Genre")
    val genre: String = "",
    @SerializedName("Title")
    val title: String = "",
    @SerializedName("Poster")
    val poster: String = ""
) {
    fun toMovieEntity(): MovieEntity {
        return MovieEntity(
            genre = genre,
            title = title,
            poster = poster
        )
    }
}
