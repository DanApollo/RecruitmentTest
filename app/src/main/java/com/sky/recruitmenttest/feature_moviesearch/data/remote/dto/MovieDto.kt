package com.sky.recruitmenttest.feature_moviesearch.data.remote.dto

import com.google.gson.annotations.SerializedName

data class MovieDto(
    @SerializedName("Genre")
    val genre: String = "",
    @SerializedName("Title")
    val title: String = "",
    @SerializedName("Poster")
    val poster: String = ""
)
