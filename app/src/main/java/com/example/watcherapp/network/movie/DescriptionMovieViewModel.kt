package com.example.watcherapp.network.movie

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.watcherapp.network.data.Movie
import kotlinx.coroutines.launch

sealed interface DescritionMovieUiState {
    object Loading : DescritionMovieUiState
    data class Success(val movie: Movie) : DescritionMovieUiState
    object Error : DescritionMovieUiState
}

class DescriptionMovieViewModel : ViewModel() {
    var descritpionMovieUiState: DescritionMovieUiState by mutableStateOf(DescritionMovieUiState.Loading)
        private set

    init { getMovieDetails("1022789") }

    private fun getMovieDetails(param:String) {
        viewModelScope.launch {
            descritpionMovieUiState = DescritionMovieUiState.Loading
            try {
                val response = DescritpionMovieApiService.RetrofitInstance.apiService.getMovieDetails(param)
                descritpionMovieUiState = DescritionMovieUiState.Success(response)
            } catch (e: Exception) {

                descritpionMovieUiState = DescritionMovieUiState.Error
            }
        }
    }
}