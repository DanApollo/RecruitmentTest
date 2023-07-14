package com.sky.recruitmenttest.views.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.sky.recruitmenttest.data.models.Movie

@Composable
fun MovieTile(movie: Movie) {
        Card(
            modifier = Modifier
                .size(height = 180.dp, width = 100.dp)
                .padding(all = 5.dp),
            border = BorderStroke(2.dp, Color.Red)
        ) {
            Column() {
                Text(text = movie.title)
                Text(text = movie.genre)
            }
        }
}