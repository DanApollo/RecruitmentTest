package com.sky.recruitmenttest.feature_moviesearch.data.local.entity

import com.sky.recruitmenttest.feature_moviesearch.domain.model.Movie
import javax.inject.Inject

class MovieEntityToDomainMapper @Inject constructor() {
    fun mapToDomain(toBeTransformed: MovieEntity): Movie {
        return Movie(
            genre = toBeTransformed.genre,
            title = toBeTransformed.title,
            poster = toBeTransformed.poster
        )
    }
}