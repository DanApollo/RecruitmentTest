package com.sky.recruitmenttest.feature_moviesearch.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sky.recruitmenttest.core.util.Resource
import com.sky.recruitmenttest.feature_moviesearch.domain.model.Movie
import com.sky.recruitmenttest.feature_moviesearch.domain.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: MovieRepository,
) : ViewModel() {
    private val _homeUIState = MutableStateFlow(HomeUIState())
    val homeUIState: StateFlow<HomeUIState> = _homeUIState.asStateFlow()

    private val _movies = mutableStateOf(listOf<Movie>())
    val movies: State<List<Movie>> = _movies

    private var searchJob: Job? = null

    fun onSearchBarChange(search: String) {
        _homeUIState.update { it.copy(search = search) }
        searchJob?.cancel()
        searchJob = viewModelScope.launch {
            delay(500L)
            if (homeUIState.value.search.isNotEmpty()) {
                _homeUIState.update {
                    it.copy(
                        movies = filterMovies(
                            homeUIState.value.search,
                            homeUIState.value.movies
                        )
                    )
                }
            } else {
                getMovies()
            }
        }
    }

    private fun filterMovies(searchTerm: String, movies: List<Movie>): List<Movie> {
        val filteredMovies = mutableListOf<Movie>()
        val keyWordArray = searchTerm.trim().split(" ").toTypedArray()
        for (item in movies) {
            var match = true
            for (keyWord in keyWordArray) {
                if (!item.title.contains(
                        keyWord,
                        ignoreCase = true
                    ) && !item.genre.contains(keyWord, ignoreCase = true)
                ) {
                    match = false
                }
            }
            if (match) {
                filteredMovies.add(item)
            }
        }
        return filteredMovies
    }

    fun getMovies(
    ) = CoroutineScope(Dispatchers.IO).launch {
        repository.getMovies()
            .onEach { result ->
                when (result) {
                    is Resource.Success -> {
                        _homeUIState.update {
                            it.copy(
                                movies = result.data ?: emptyList(),
                            )
                        }
                    }

                    is Resource.Error -> {
                        _homeUIState.update {
                            it.copy(
                                movies = result.data.orEmpty(),
                                message = result.message.orEmpty(),
                            )
                        }
                    }

                    is Resource.Loading -> {
                        _homeUIState.update {
                            it.copy(
                                movies = result.data ?: emptyList(),
                            )
                        }
                    }
                }
            }.launchIn(this)
    }
}

data class HomeUIState(
    val search: String = "",
    val movies: List<Movie> = listOf(),
    val message: String = "",
)
