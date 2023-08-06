package com.sky.recruitmenttest.presentation.mapper

import com.sky.recruitmenttest.data.models.Movie
import com.sky.recruitmenttest.domain.mapper.MovieToPresentationMapper
import com.sky.recruitmenttest.presentation.models.MovieDTO
import javax.inject.Inject

class MovieToPresentationMapperImpl @Inject constructor(
) : MovieToPresentationMapper {

    override fun mapToPresentation(toBeTransformed: Movie): MovieDTO {
        return MovieDTO(
            genre = toBeTransformed.genre,
            title = toBeTransformed.title,
            poster = toBeTransformed.poster
        )
    }
}
