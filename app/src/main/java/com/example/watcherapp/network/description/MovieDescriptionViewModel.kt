package com.example.watcherapp.network.description

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.watcherapp.network.data.DetailsMovie
import com.example.watcherapp.network.movie.MovieApiService
import com.example.watcherapp.network.movie.MovieDetailResponse
import kotlinx.coroutines.launch

sealed interface MovieDescriptionUiState {
    object Loading : MovieDescriptionUiState
    data class Success(val movieDetails: DetailsMovie) : MovieDescriptionUiState
    object Error : MovieDescriptionUiState
}

class MovieDescriptionViewModel(val movieId:Int) : ViewModel() {
    var moviedescriptionUiState: MovieDescriptionUiState by mutableStateOf(MovieDescriptionUiState.Loading)
        private set

    init {
        getMovieDetails(movieId)
    }

    private fun getMovieDetails(movieId: Int) {
        viewModelScope.launch {
            Log.i("Id", "O valor de i é: $movieId")
            moviedescriptionUiState = MovieDescriptionUiState.Loading
            try {
                val response = MovieApiService.RetrofitInstance.apiService.getMovieDetails(movieId)
                moviedescriptionUiState = MovieDescriptionUiState.Success(response.result)
                Log.i("result","O resultado é ${response.result}")
            } catch (e: Exception) {
                moviedescriptionUiState = MovieDescriptionUiState.Error
            }
        }
    }
}