package com.example.watcherapp.network.details

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.watcherapp.network.data.MediaItem
import com.example.watcherapp.network.movie.MovieApiService
import com.example.watcherapp.network.tvShow.RetrofitInstance
import kotlinx.coroutines.launch

sealed interface MovieDetailsUiState {
    object Loading : MovieDetailsUiState
    data class Success(val medias: MutableList<MediaItem>) : MovieDetailsUiState
    object Error : MovieDetailsUiState
}

class MediaViewModel : ViewModel(){
    //var listMedia:List<MediaItem> by mutableStateOf (listOf() )
    var mediaUiState: MovieDetailsUiState by mutableStateOf(MovieDetailsUiState.Loading)
        private set
    init {
        getMediaItems()
    }

    private fun getMediaItems(){
        viewModelScope.launch {
            mediaUiState = MovieDetailsUiState.Loading
            try {
                val movies = MovieApiService.RetrofitInstance.apiService.getPopularMovies().results
                val shows = RetrofitInstance.apiService.getPopularTvShows().results

                val combinedList = mutableListOf<MediaItem>()
                combinedList.addAll(movies)
                combinedList.addAll(shows)

                mediaUiState = MovieDetailsUiState.Success(combinedList)
            }catch (e: Exception){
                mediaUiState = MovieDetailsUiState.Error
            }
        }
    }
}
