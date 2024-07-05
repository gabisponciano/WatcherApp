package com.example.watcherapp.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.watcherapp.network.models.Moviee

import com.example.watcherapp.network.movie.IMAGE_URL
import com.example.watcherapp.network.movie.MovieUiState
import com.example.watcherapp.network.movie.MovieViewModel
import com.example.watcherapp.ui.theme.background


@Composable
fun MovieScreen(
    innerPadding: Dp,
    navController: NavController,
    movieViewModel: MovieViewModel,
    movieUiState: MovieUiState,
    modifier: Modifier = Modifier
) {
    Surface(modifier = modifier
        .fillMaxSize()
        .padding(top = innerPadding)) {
        when (movieUiState) {
            is MovieUiState.Success -> {
                LazyColumnMedia(navController, movieViewModel)
            }
            is MovieUiState.Error -> {}
            is MovieUiState.Loading -> {}
        }
    }
}


@SuppressLint("UnrememberedMutableState", "MutableCollectionMutableState")
@Composable
fun LazyColumnMedia(
    navController: NavController,
    movieViewModel: MovieViewModel,
) {

    var page: Int by mutableIntStateOf(1)


    val scrollState = rememberLazyGridState()

    val isItemReachEndScroll by remember {
        derivedStateOf {
            scrollState.layoutInfo.visibleItemsInfo.lastOrNull()?.index == scrollState.layoutInfo.totalItemsCount - 1
        }
    }

    LaunchedEffect(key1 = isItemReachEndScroll, block = {
        page++
        movieViewModel.getPopularMovies(page)
    })

    LazyVerticalGrid(
        state = scrollState,
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
        modifier = Modifier
            .fillMaxSize()
            .background(background),
    ) {
        itemsIndexed(movieViewModel.movieListResponse) { _, item ->
            Card(movie = item, navController = navController)
        }
    }
}


@Composable
fun Card(
    movie: Moviee,
    navController: NavController,
) {
    AsyncImage(
        modifier = Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(8.dp))
            .clickable {
                navController.currentBackStackEntry?.savedStateHandle?.set(
                    key = "media",
                    value = movie
                )
                navController.navigate("detailsmovie/${movie.id}")
            },
        model = ImageRequest.Builder(context = LocalContext.current)
            .data("$IMAGE_URL${movie.poster}")
            .crossfade(true).build(),
        contentDescription = movie.name,
        contentScale = ContentScale.Crop,
    )
}