package com.sky.recruitmenttest.data.models

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("Genre")
    val genre: String = "",
    @SerializedName("Title")
    val title: String = "",
    @SerializedName("Poster")
    val poster: String = ""
)
