package com.sky.recruitmenttest.moviesearch.data.remote.dto

import com.sky.recruitmenttest.moviesearch.data.local.entity.MovieEntity
import javax.inject.Inject

class MovieDtoToMovieEntityMapper @Inject constructor() {
    fun mapToEntity(toBeTransformed: MovieDto): MovieEntity {
        return MovieEntity(
            genre = toBeTransformed.genre,
            title = toBeTransformed.title,
            poster = toBeTransformed.poster
        )
    }
}