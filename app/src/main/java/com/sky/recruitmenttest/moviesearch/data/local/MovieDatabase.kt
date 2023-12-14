package com.sky.recruitmenttest.moviesearch.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sky.recruitmenttest.moviesearch.data.local.entity.MovieEntity

@Database(
    entities = [MovieEntity::class],
    version = 1
)
abstract class MovieDatabase: RoomDatabase() {

    abstract val dao: MovieDao
}
