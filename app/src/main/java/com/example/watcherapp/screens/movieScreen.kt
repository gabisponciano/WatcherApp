package com.example.watcherapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.SubcomposeAsyncImage
import com.example.watcherapp.components.MyNavigationDrawer
import com.example.watcherapp.components.Navegacao
import com.example.watcherapp.network.data.Movie
//import com.example.watcherapp.components.HomeTopAppBar
//import com.example.watcherapp.network.movie.Movie
import com.example.watcherapp.network.movie.MovieUiState
import com.example.watcherapp.network.movie.MovieViewModel
import com.example.watcherapp.ui.theme.background


@Composable
fun MovieShow(
    viewModel: MovieViewModel = viewModel<MovieViewModel>(),
    navController: NavHostController
) {
    when (val state = viewModel.movieUiState) {
        is MovieUiState.Loading -> LoadingScreen()
        is MovieUiState.Success -> movieScreen(movies = state.movies)
        is MovieUiState.Error -> ErrorScreen()
    }
}

@Composable
fun LoadingScreen() {
    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
        CircularProgressIndicator()
    }
}

@Composable
fun ErrorScreen() {
    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
        Text("Erro ao carregar")
    }
}

@Composable
fun movieScreen(movies: List<Movie>) {

    var id by remember { mutableStateOf("") }
    if (id != "") {
        Navegacao(tipo = "detailsMovie",id)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(background),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            contentAlignment = Alignment.TopCenter
        ) {
            LazyVerticalGrid(columns = GridCells.Adaptive(minSize = 160.dp)) {
                items(movies) { movie ->
                    Card(
                        modifier = Modifier
                            .padding(7.dp)
                            .height(270.dp)
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(5.dp))
                            .clickable { id = movie.id.toString() }
                    ) {
                        MovieItem(movie)
                    }
                }
            }
        }
    }
}

@Composable
fun MovieItem(movie: Movie) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        SubcomposeAsyncImage(
            model = movie.imageUrl,
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


//@Preview
//@Composable
//fun moviePreview(){
//    MovieShow()
//}