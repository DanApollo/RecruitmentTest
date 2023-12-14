package com.sky.recruitmenttest.moviesearch.data.local.entity

import com.sky.recruitmenttest.moviesearch.domain.model.Movie
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