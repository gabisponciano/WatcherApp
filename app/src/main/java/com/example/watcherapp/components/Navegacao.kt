package com.example.watcherapp.components

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.watcherapp.screens.MovieShow
import com.example.watcherapp.screens.Tv_Show
import com.example.watcherapp.screens.descriptionScreen
import com.example.watcherapp.screens.favScreen
import com.example.watcherapp.screens.homeScreen

@Composable
fun Navegacao(tipo : String) {
    var destino = tipo
    if (destino == "") { destino = "shows"}

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = destino){
        composable("home"){
            homeScreen()
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
        /*
        composable("description/{id}") { backStackEntry ->
            descriptionScreen(
                navController,
                backStackEntry.arguments?.getString("id") ?: ""
            )
        }
         */

        composable("description"){
            descriptionScreen(navController = navController)
        }


        composable("video"){
            VideoPlayer(idVideo = "8IhNq0ng-wk")
        }
    }
}