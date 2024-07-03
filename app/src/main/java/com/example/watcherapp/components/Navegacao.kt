package com.example.watcherapp.components

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.watcherapp.screens.DescriptionMovie_Show
import com.example.watcherapp.screens.Media_Show
import com.example.watcherapp.screens.MovieShow
import com.example.watcherapp.screens.Tv_Show
import com.example.watcherapp.screens.descriptionMovieScreen
import com.example.watcherapp.screens.favScreen


@Composable
fun Navegacao(tipo : String, parametro: String? = "") {

    var destino = tipo
    if (destino == "") { destino = "home"}

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = destino){
        composable("home"){
            Media_Show()
        }
        composable("movies"){
            MovieShow(navController = navController)
        }
        composable("shows"){
            Tv_Show()
        }
        composable("favs"){
            favScreen(navController = navController)
        }

        composable("detailsMovie"){
            if (parametro != null) {
                DescriptionMovie_Show(navController = navController, parametro)
            }
        }

    /*
        composable("descriptionMovie/{id}"){
            backStack
            descriptionScreen(navController = navController)
            navController,
            backStackEntry.arguments?.getString("id") ?: parametro
        }

     */




        composable("video"){
            VideoPlayer(idVideo = "8IhNq0ng-wk")
        }
    }
}