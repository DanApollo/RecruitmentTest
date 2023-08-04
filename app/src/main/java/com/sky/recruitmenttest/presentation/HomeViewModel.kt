package com.sky.recruitmenttest.presentation

import androidx.lifecycle.ViewModel
import com.sky.recruitmenttest.data.models.MovieDto
import com.sky.recruitmenttest.domain.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: MovieRepository
) : ViewModel() {
    private val _homeUIState = MutableStateFlow(HomeUIState())
    val homeUIState: StateFlow<HomeUIState> = _homeUIState.asStateFlow()

    fun onSearchBarChange(search: String) {
        _homeUIState.update { it.copy(search = search) }
        movieFilter()
    }

    private fun movieFilter() {
        if (homeUIState.value.search.isNotEmpty()) {
            val tempFilteredMovies = mutableListOf<MovieDto>()
            val keyWordArray = homeUIState.value.search.trim().split(" ").toTypedArray()
            for (item in homeUIState.value.movies) {
                var match = true
                for (keyWord in keyWordArray) {
                    if (!item.title.contains(keyWord, ignoreCase = true) && !item.genre.contains(keyWord, ignoreCase = true)) {
                        match = false
                    }
                }
                if (match) {
                    tempFilteredMovies.add(item)
                }
            }
            _homeUIState.update { it.copy(filteredMovies = tempFilteredMovies) }
        } else {
            _homeUIState.update { it.copy(filteredMovies = homeUIState.value.movies) }
        }
    }

    fun getMovies(
    ) = CoroutineScope(Dispatchers.IO).launch {
        try {
            val movies = repository.getMovies()
            _homeUIState.update { it.copy(movies = movies, filteredMovies = movies) }
        } catch (e: Exception) {
        }
    }
}

data class HomeUIState(
    val search: String = "",
    val movies: List<MovieDto> = listOf(),
    val filteredMovies: List<MovieDto> = listOf()
)
