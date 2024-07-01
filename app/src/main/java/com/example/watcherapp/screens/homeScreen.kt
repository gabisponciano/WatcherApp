package com.example.watcherapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import com.example.watcherapp.network.movie.Movie
import com.example.watcherapp.network.movie.MovieUiState
import com.example.watcherapp.network.movie.MovieViewModel
import com.example.watcherapp.network.tvShow.TvShow
import com.example.watcherapp.network.tvShow.TvShowUiState
import com.example.watcherapp.network.tvShow.TvShowViewModel
import com.example.watcherapp.ui.theme.background

@Composable
fun homeScreen(){
    Column (modifier = Modifier
        .fillMaxSize()
        .background(background)){
        Tv_Show()

    }
}

@Preview
@Composable
fun homeScreenPreview(){
    homeScreen()
}