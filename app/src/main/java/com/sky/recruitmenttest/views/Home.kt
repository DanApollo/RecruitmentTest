package com.sky.recruitmenttest.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.sky.recruitmenttest.ui.theme.RecruitmentTestTheme
import com.sky.recruitmenttest.feature_moviesearch.presentation.HomeViewModel
import com.sky.recruitmenttest.views.components.MovieTile
import kotlinx.coroutines.flow.collectLatest

@Composable
fun Home(
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state = viewModel.homeUIState.collectAsState()
    val scaffoldState = remember { SnackbarHostState() }

    LaunchedEffect(key1 = true) {
        viewModel.getMovies()
    }
    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest { event ->
            when(event) {
                is HomeViewModel.UIEvent.ShowSnackbar -> {
                    scaffoldState.showSnackbar(
                        message = event.message
                    )
                }
            }
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = state.value.search,
            onValueChange = { viewModel.onSearchBarChange(it) },
            placeholder = {
                Text(text = "Search...")
            },
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(count = 3)
        ) {
            items(
                state.value.filteredMovies.size
            ) { i ->
                MovieTile(movie = state.value.filteredMovies[i])
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    RecruitmentTestTheme {
        Home()
    }
}
