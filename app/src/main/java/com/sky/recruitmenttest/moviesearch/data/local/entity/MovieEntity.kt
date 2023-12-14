package com.sky.recruitmenttest.moviesearch.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MovieEntity(
    val genre: String = "",
    val title: String = "",
    val poster: String = "",
    @PrimaryKey val id: Int? = null
)
