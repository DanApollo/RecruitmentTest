package com.sky.recruitmenttest.domain.mapper

import com.sky.recruitmenttest.data.models.Movie
import com.sky.recruitmenttest.presentation.models.MovieDTO

interface MovieToPresentationMapper {

    fun mapToPresentation(toBeTransformed: Movie): MovieDTO
}
