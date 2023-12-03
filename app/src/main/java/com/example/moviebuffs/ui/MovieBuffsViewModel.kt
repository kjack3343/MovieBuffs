package com.example.moviebuffs.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviebuffs.ui.network.MovieBuffsApi
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface MovieBuffsUiState {
    data class Success(val movies: String) : MovieBuffsUiState
    data object Error : MovieBuffsUiState
    data object Loading : MovieBuffsUiState
}
class MovieBuffsViewModel : ViewModel() {
    /** The mutable State that stores the status of the most recent request */
    var movieBuffsUiState: MovieBuffsUiState by mutableStateOf(MovieBuffsUiState.Loading)
        private set

    init {
        getMovieBuffsMovies()
    }


    private fun getMovieBuffsMovies() {
        viewModelScope.launch {
            movieBuffsUiState = try{
                val result = MovieBuffsApi.retrofitService.getMovies()[0]
                MovieBuffsUiState.Success(
                    "   First Mars image URL : ${result.bigImage}"
                )
            } catch (e: IOException) {
                MovieBuffsUiState.Error
            }
}}}