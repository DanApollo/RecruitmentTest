package com.sky.recruitmenttest.moviesearch.di

import android.app.Application
import androidx.room.Room
import com.sky.recruitmenttest.moviesearch.data.local.MovieDao
import com.sky.recruitmenttest.moviesearch.data.local.MovieDatabase
import com.sky.recruitmenttest.moviesearch.data.remote.MovieApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApiService(): MovieApi {
        return Retrofit.Builder()
            .baseUrl(MovieApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieApi::class.java)
    }

    @Provides
    @Singleton
    fun provideMovieDatabase(app: Application): MovieDatabase {
        return Room.databaseBuilder(
            app, MovieDatabase::class.java, "movie_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideDao(db: MovieDatabase): MovieDao {
        return db.dao
    }
}
