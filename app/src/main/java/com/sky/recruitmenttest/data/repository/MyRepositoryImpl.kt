package com.sky.recruitmenttest.data.repository

import com.sky.recruitmenttest.data.remote.ApiService
import com.sky.recruitmenttest.domain.repository.MyRepository
import javax.inject.Inject

class MyRepositoryImpl @Inject constructor(
    private val api: ApiService
): MyRepository {

    override suspend fun getMovies() {
        api.getMovies()
    }

}