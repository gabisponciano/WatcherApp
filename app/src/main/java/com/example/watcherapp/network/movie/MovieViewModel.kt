package com.example.watcherapp.network.movie

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.watcherapp.network.data.Movie
import kotlinx.coroutines.launch

sealed interface MovieUiState {
    object Loading : MovieUiState
    data class Success(val movies: List<Movie>) : MovieUiState
    object Error : MovieUiState
}

class MovieViewModel : ViewModel() {
    var movieUiState: MovieUiState by mutableStateOf(MovieUiState.Loading)
        private set

    init {
        getPopularMovies()
    }

    private fun getPopularMovies() {
        viewModelScope.launch {
            movieUiState = MovieUiState.Loading
            try {
                val response = MovieApiService.RetrofitInstance.apiService.getPopularMovies()
                movieUiState = MovieUiState.Success(response.results)
            } catch (e: Exception) {
                movieUiState = MovieUiState.Error
            }
        }
    }
}