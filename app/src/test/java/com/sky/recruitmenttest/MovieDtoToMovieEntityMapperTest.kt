package com.sky.recruitmenttest

import com.sky.recruitmenttest.moviesearch.data.remote.dto.MovieDto
import com.sky.recruitmenttest.moviesearch.data.remote.dto.MovieDtoToMovieEntityMapper
import org.junit.Assert.*
import org.junit.Test

class MovieDtoToMovieEntityMapperTest {
    private val mapper = MovieDtoToMovieEntityMapper()

    @Test
    fun `Given a movie DTO when mapping to a movie Entity then assert the Entity object is the expected`() {
        val movieDto = MovieDto(
            title = "title",
            genre = "genre",
            poster = "poster"
        )
        val movieEntity = mapper.mapToEntity(movieDto)
        assertEquals("title", movieEntity.title)
        assertEquals("genre", movieEntity.genre)
        assertEquals("poster", movieEntity.poster)
    }
}
