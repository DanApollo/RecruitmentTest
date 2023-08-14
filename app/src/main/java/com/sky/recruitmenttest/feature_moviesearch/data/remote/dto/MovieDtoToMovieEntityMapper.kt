package com.sky.recruitmenttest.feature_moviesearch.data.remote.dto

import com.sky.recruitmenttest.feature_moviesearch.data.local.entity.MovieEntity

class MovieDtoToMovieEntityMapper {
    fun mapToEntity(toBeTransformed: MovieDto): MovieEntity {
        return MovieEntity(
            genre = toBeTransformed.genre,
            title = toBeTransformed.title,
            poster = toBeTransformed.poster
        )
    }
}