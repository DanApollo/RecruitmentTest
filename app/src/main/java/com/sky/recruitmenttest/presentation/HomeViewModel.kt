package com.sky.recruitmenttest.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import com.sky.recruitmenttest.data.models.Movie
import com.sky.recruitmenttest.domain.repository.MyRepository
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
    private val repository: MyRepository
) : ViewModel() {
    private val _homeUIState = MutableStateFlow(HomeUIState())
    val homeUIState: StateFlow<HomeUIState> = _homeUIState.asStateFlow()

    fun onSearchBarChange(search: String) {
        _homeUIState.update { it.copy(search = search) }
    }

    fun getMovies(

    ) = CoroutineScope(Dispatchers.IO).launch {
        try {
            val movies = repository.getMovies()
            _homeUIState.update { it.copy(movies = movies) }
        } catch (e: Exception) {
            Log.d("hey", e.localizedMessage)
        }
    }
}

data class HomeUIState(
    val search: String = "",
    val movies: List<Movie> = listOf()
)
