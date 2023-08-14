package com.sky.recruitmenttest.feature_moviesearch.data.local.entity

import com.sky.recruitmenttest.feature_moviesearch.domain.model.Movie

class MovieEntityToDomainMapper {
    fun mapToDomain(toBeTransformed: MovieEntity): Movie {
        return Movie(
            genre = toBeTransformed.genre,
            title = toBeTransformed.title,
            poster = toBeTransformed.poster
        )
    }
}