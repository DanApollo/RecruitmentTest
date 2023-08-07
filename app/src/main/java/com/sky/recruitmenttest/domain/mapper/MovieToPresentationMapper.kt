package com.sky.recruitmenttest.domain.mapper

import com.sky.recruitmenttest.data.remote.dto.MovieDto
import com.sky.recruitmenttest.presentation.models.MovieDTO

interface MovieToPresentationMapper {

    fun mapToPresentation(toBeTransformed: MovieDto): MovieDTO
}
