package com.sky.recruitmenttest.feature_moviesearch.presentation

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
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
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

    private val _eventFlow = MutableSharedFlow<UIEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    private var searchJob: Job? = null

    fun onSearchBarChange(search: String) {
        _homeUIState.update { it.copy(search = search) }
        searchJob?.cancel()
        searchJob = viewModelScope.launch {
            delay(500L)
            movieFilter()
        }
    }

    private fun movieFilter() {
        if (homeUIState.value.search.isNotEmpty()) {
            val tempFilteredMovies = mutableListOf<Movie>()
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
        repository.getMovies()
            .onEach { result ->
                when(result) {
                    is Resource.Success -> {
                        _homeUIState.update {
                            it.copy(
                                movies = result.data ?: emptyList(),
                                filteredMovies = result.data ?: emptyList(),
                                isLoading = false
                            )
                        }
                    }
                    is Resource.Error -> {
                        _homeUIState.update {
                            it.copy(
                                movies = result.data ?: emptyList(),
                                filteredMovies = result.data ?: emptyList(),
                                isLoading = false
                            )
                        }
                        _eventFlow.emit(UIEvent.ShowSnackbar(
                            result.message ?: "Unknown error."
                        ))
                    }
                    is Resource.Loading -> {
                        _homeUIState.update {
                            it.copy(
                                movies = result.data ?: emptyList(),
                                filteredMovies = result.data ?: emptyList(),
                                isLoading = true
                            )
                        }
                    }
                }
            }
    }

    sealed class UIEvent {
        data class ShowSnackbar(val message: String): UIEvent()
    }
}

data class HomeUIState(
    val search: String = "",
    val movies: List<Movie> = listOf(),
    val filteredMovies: List<Movie> = listOf(),
    val isLoading: Boolean = false
)
