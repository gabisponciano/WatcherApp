package com.example.watcherapp.network.description

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.watcherapp.network.data.MovieSerial
import com.example.watcherapp.network.movie.MovieApiService

import kotlinx.coroutines.launch

sealed interface MovieDescriptionUiState {
    object Loading : MovieDescriptionUiState
    data class Success(val movieDetails: MovieSerial) : MovieDescriptionUiState
    object Error : MovieDescriptionUiState
}

class MovieDescriptionViewModel(val movieId:String) : ViewModel() {
    var moviedescriptionUiState: MovieDescriptionUiState by mutableStateOf(MovieDescriptionUiState.Loading)
        private set

    init {
        getMovieDetails(movieId)
    }

    private fun getMovieDetails(movieId: String) {
        viewModelScope.launch {
            Log.i("Id", "O valor de i é: $movieId")
            moviedescriptionUiState = MovieDescriptionUiState.Loading
            try {
                val response = MovieApiService.RetrofitInstance.apiService.getMovieDetails(movieId)
                moviedescriptionUiState = MovieDescriptionUiState.Success(response)
                Log.i("result","O resultado é ${response}")
            } catch (e: Exception) {
                moviedescriptionUiState = MovieDescriptionUiState.Error
            }
        }
    }
}