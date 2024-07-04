package com.example.watcherapp.components

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.watcherapp.network.movie.MoviesViewModel
import com.example.watcherapp.screens.Media_Show
import com.example.watcherapp.screens.MovieScreenShow
import com.example.watcherapp.screens.Tv_Show
import com.example.watcherapp.screens.favScreen


@Composable
fun Navegacao(tipo : String) {
    var destino = tipo
    if (destino == "") { destino = "home"}

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = destino){
        composable("home"){
            Media_Show()
        }
        composable("movies"){
            val moviesViewModel: MoviesViewModel = viewModel<MoviesViewModel>()
            MovieScreenShow(moviesViewModel,navController = navController)
        }
        composable("shows"){
            Tv_Show()
        }
        composable("favs"){
            favScreen(navController = navController)
        }
        composable("detailsmovie"){
            val moviesViewModel: MoviesViewModel = viewModel<MoviesViewModel>()
            val results =
                navController.previousBackStackEntry?.savedStateHandle?.get<String>("moveId")
            if (results != null){
                moviesViewModel.movieListResponse

            }

        }



//        composable("detailsmovie/{movieId}"){ navBackStackEntry ->
//            val movieId  = navBackStackEntry.arguments?.getString("movieId")
//            movieId?.let { movieId->
//                val viewModel = viewModel<MovieDescriptionViewModel>(
//                factory = object : ViewModelProvider.Factory{
//                        override fun <T : ViewModel> create(modelClass: Class<T>): T {
//                            return MovieDescriptionViewModel(movieId.toInt()) as T
//                        }
//                    }
//
//                )
//                Text
//                DetailsMovieShow(navController)
//
//            }
//
//        }
        /*
        composable("description/{id}") { backStackEntry ->
            descriptionScreen(
                navController,
                backStackEntry.arguments?.getString("id") ?: ""
            )
        }
         */

//        composable("description"){
//            descriptionScreen(navController = navController)
//        }

        composable("video"){
            VideoPlayer(idVideo = "8IhNq0ng-wk")
        }
    }
}