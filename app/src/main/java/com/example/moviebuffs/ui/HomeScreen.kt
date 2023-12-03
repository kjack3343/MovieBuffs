package com.example.moviebuffs.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.moviebuffs.R
import com.example.moviebuffs.ui.theme.MovieBuffsTheme

@Composable
fun HomeScreen(
    movieBuffsUiState: MovieBuffsUiState, modifier: Modifier = Modifier
) {
    when (movieBuffsUiState) {
            is MovieBuffsUiState.Loading -> LoadingScreen(modifier = modifier.fillMaxSize())
            is MovieBuffsUiState.Success -> ResultScreen(
                movieBuffsUiState.movies, modifier = modifier.fillMaxWidth())
        is MovieBuffsUiState.Error -> ErrorScreen(modifier = modifier.fillMaxSize())
    }
}
@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Image(
        modifier = modifier.size(200.dp),
        painter = painterResource(R.drawable.loading_img__1_),
        contentDescription = stringResource(R.string.loading)
    )
}

@Composable
fun ErrorScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.ic_connection_error__1_), contentDescription = ""
        )
        Text(text = stringResource(R.string.loading_failed), modifier = Modifier.padding(16.dp))
    }
}
/**
 * ResultScreen displaying number of photos retrieved.
 */
@Composable
fun ResultScreen(movies: String, modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
    ) {
        Text(text = movies)
    }
}

@Preview(showBackground = true)
@Composable
fun ResultScreenPreview() {
    MovieBuffsTheme {
        ResultScreen("Placeholder result text")
    }
}