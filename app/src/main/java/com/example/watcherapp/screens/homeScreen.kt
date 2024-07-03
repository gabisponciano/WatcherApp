package com.example.watcherapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.SubcomposeAsyncImage
import com.example.watcherapp.network.Media.MediaUiState
import com.example.watcherapp.network.Media.MediaViewModel
import com.example.watcherapp.network.data.MediaItem
import com.example.watcherapp.network.data.TvShow
//import com.example.watcherapp.network.movie.Movie
import com.example.watcherapp.network.movie.MovieUiState
import com.example.watcherapp.network.movie.MovieViewModel
//import com.example.watcherapp.network.tvShow.TvShow
import com.example.watcherapp.network.tvShow.TvShowUiState
import com.example.watcherapp.network.tvShow.TvShowViewModel
import com.example.watcherapp.ui.theme.background

@Composable
fun Media_Show(viewModel: MediaViewModel = viewModel<MediaViewModel>()){
    when (val state = viewModel.mediaUiState) {
        is MediaUiState.Loading -> Loading_ScreenMedia()
        is MediaUiState.Success -> mediaScreen(medias = state.medias)
        is MediaUiState.Error -> Error_ScreenMedia()
    }
}

@Composable
fun Loading_ScreenMedia() {
    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
        CircularProgressIndicator()
    }
}

@Composable
fun Error_ScreenMedia() {
    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
        Text("Erro ao carregar")
    }
}

@Composable
fun mediaScreen(medias: List<MediaItem>){
        LazyVerticalGrid(columns = GridCells.Adaptive(minSize = 160.dp)){
            items(medias){ tvmedia ->
                Card (
                    modifier = Modifier
                        .padding(7.dp)
                        .height(270.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(5.dp))
                        .clickable { }
                ){
                    mmItem(tvmedia)
                }
            }
        }
    }

@Composable
fun mmItem(tvmedia: MediaItem) {
    Column (horizontalAlignment = Alignment.CenterHorizontally){
        SubcomposeAsyncImage(
            model = tvmedia.imageUrl,
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .height(270.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(3.dp))
                .background(background)
        )
    }
}