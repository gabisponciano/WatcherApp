package com.example.watcherapp.network.tvShow

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.watcherapp.network.data.TvShow
import kotlinx.coroutines.launch

sealed interface TvShowUiState {
    object Loading : TvShowUiState
    data class Success(val shows: List<TvShow>) : TvShowUiState
    object Error : TvShowUiState
}

class TvShowViewModel : ViewModel(){
    var tvshowUiState: TvShowUiState by mutableStateOf(TvShowUiState.Loading)
        private set
    init {
        getPopularTvShows()
    }

    private fun getPopularTvShows(){
        viewModelScope.launch {
            tvshowUiState = TvShowUiState.Loading
            try {
                val response = RetrofitInstance.apiService.getPopularTvShows()
                    tvshowUiState = TvShowUiState.Success(response.results)
            }catch (e: Exception){
                tvshowUiState = TvShowUiState.Error
            }
        }
    }
}

