package com.sky.recruitmenttest

import com.sky.recruitmenttest.feature_moviesearch.data.local.entity.MovieEntity
import com.sky.recruitmenttest.feature_moviesearch.data.local.entity.MovieEntityToDomainMapper
import org.junit.Test
import org.junit.Assert.*

class MovieEntityToDomainMapperTest {
    private val mapper = MovieEntityToDomainMapper()

    @Test
    fun `Given a movie entity when mapping to domain then assert the domain object is the expected`() {
        val movieEntity = MovieEntity(
            title = "title",
            genre = "genre",
            poster = "poster"
        )
        val domainMovie = mapper.mapToDomain(movieEntity)
        assertEquals("title", domainMovie.title)
        assertEquals("genre", domainMovie.genre)
        assertEquals("poster", domainMovie.poster)
    }
}
