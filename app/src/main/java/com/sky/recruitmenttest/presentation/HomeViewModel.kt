package com.sky.recruitmenttest.presentation

import androidx.lifecycle.ViewModel
import com.sky.recruitmenttest.domain.repository.MyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: MyRepository
): ViewModel() {
    private val _homeUIState = MutableStateFlow(HomeUIState())
    val homeUIState: StateFlow<HomeUIState> = _homeUIState.asStateFlow()

    fun onSearchBarChange(search: String) {
        _homeUIState.update { it.copy(search = search) }
    }

    fun getMovies() {
    }
}

data class HomeUIState(
    val search: String = "",
)