package com.sky.recruitmenttest.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sky.recruitmenttest.ui.theme.RecruitmentTestTheme
import com.sky.recruitmenttest.viewmodels.HomeViewModel
import com.sky.recruitmenttest.views.components.SimpleFlowRow

@Composable
fun Home() {
    val viewModel = viewModel<HomeViewModel>()
    val state = viewModel.homeUIState.collectAsState()
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = state.value.search,
            onValueChange = { viewModel.onSearchBarChange(it) },
            placeholder = {
                Text(text = "Search")
            },
        )
        SimpleFlowRow(
            verticalGap = 30.dp,
            horizontalGap = 20.dp,
            alignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp)
        ) {
            for (i in 1..50) {
                Box(modifier = Modifier
                    .size(height = 180.dp, width = 100.dp)
                    .background(color = Color.Black))
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