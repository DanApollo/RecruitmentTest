package com.sky.recruitmenttest.di

import com.sky.recruitmenttest.data.remote.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
// Singleton module lives for duration of application lifetime.
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    // Only single instance is created for repositories.
    @Singleton
    fun provideApiService(): ApiService {
        return Retrofit.Builder()
            .baseUrl("https://api.npoint.io/759fdfa82d6f33522e11/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

}