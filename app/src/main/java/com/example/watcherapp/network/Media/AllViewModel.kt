package com.example.watcherapp.network.Media

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.watcherapp.network.data.MediaItem
import com.example.watcherapp.network.movie.MovieApiService
import com.example.watcherapp.network.tvShow.RetrofitInstance
import com.example.watcherapp.network.tvShow.TvShowApiService
import kotlinx.coroutines.launch

sealed interface MediaUiState {
    object Loading : MediaUiState
    data class Success(val medias: MutableList<MediaItem>) : MediaUiState
    object Error : MediaUiState
}

class MediaViewModel : ViewModel(){
    //var listMedia:List<MediaItem> by mutableStateOf (listOf() )
    var mediaUiState: MediaUiState by mutableStateOf(MediaUiState.Loading)
        private set
    init {
        getMediaItems()
    }

    private fun getMediaItems(){
        viewModelScope.launch {
            mediaUiState = MediaUiState.Loading
            try {
                val movies = MovieApiService.RetrofitInstance.apiService.getPopularMovies().results
                val shows = RetrofitInstance.apiService.getPopularTvShows().results

                val combinedList = mutableListOf<MediaItem>()
                //combinedList.addAll(movies)
                combinedList.addAll(shows)

                mediaUiState = MediaUiState.Success(combinedList)
            }catch (e: Exception){
                mediaUiState = MediaUiState.Error
            }
        }
    }
}