package com.example.watcherapp.network

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.HttpException

sealed interface movieUiState{
    data class Success(val movies: String) : movieUiState
    object Error : movieUiState
    object Loading : movieUiState
}
class MarsViewModel : ViewModel() {

    var marsUiState: movieUiState by mutableStateOf(movieUiState.Loading)
        private set

    init {
        getMovieslist()
    }

    fun getMovieslist() {
        viewModelScope.launch {
            movieUiState = movieUiState.Loading
            movieUiState = try {
                val listResult = MovieApi.retrofitService.getMovies()
                movieUiState.Success(
                    "Success: ${listResult.size} os filmes foram enviados"
                )
            //} catch (e: IOException) {
                //movieUiState.Error
            } catch (e: HttpException) {
                movieUiState.Error
            }
        }
    }
}