package com.sky.recruitmenttest.views.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.sky.recruitmenttest.presentation.models.MovieDTO

@Composable
fun MovieTile(movie: MovieDTO) {
    Card(
        modifier = Modifier
            .size(height = 180.dp, width = 100.dp)
            .padding(all = 5.dp),
        border = BorderStroke(2.dp, Color.Red)
    ) {
        Box(modifier = Modifier.fillMaxSize()){
            AsyncImage(
                model = movie.poster,
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )
            Column(modifier = Modifier.background(color = Color.White.copy(alpha = 0.7f))) {
                Text(text = movie.title)
                Text(text = movie.genre)
            }
        }
    }
}
