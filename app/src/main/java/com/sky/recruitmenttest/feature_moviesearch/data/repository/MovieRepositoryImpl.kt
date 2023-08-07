package com.sky.recruitmenttest.feature_moviesearch.data.repository

import com.sky.recruitmenttest.core.util.Resource
import com.sky.recruitmenttest.feature_moviesearch.data.local.MovieDao
import com.sky.recruitmenttest.feature_moviesearch.data.remote.MovieApi
import com.sky.recruitmenttest.feature_moviesearch.domain.model.Movie
import com.sky.recruitmenttest.feature_moviesearch.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val api: MovieApi,
    private val dao: MovieDao
) : MovieRepository {

    override suspend fun getMovies(): Flow<Resource<List<Movie>>> = flow {
        emit(Resource.Loading())

        val movies = dao.getMovies().map { it.toMovie() }
        emit(Resource.Loading(data = movies))

        try {
            val remoteMovies = api.getMovies()
            dao.deleteMovies()
            dao.insertMovies(remoteMovies.map { it.toMovieEntity() })
        } catch (e: HttpException) {
            emit(Resource.Error(
                message = "Something went wrong.",
                data = movies
            ))
        } catch (e: IOException) {
            emit(Resource.Error(
                message = "Could not reach server.",
                data = movies
            ))
        }

        val newMovies = dao.getMovies().map { it.toMovie() }
        emit(Resource.Success(newMovies))
    }
}
