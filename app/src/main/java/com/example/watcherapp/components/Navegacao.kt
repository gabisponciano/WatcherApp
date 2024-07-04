package com.example.watcherapp.components

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.watcherapp.screens.DescriptionMovie_Show
import com.example.watcherapp.screens.Media_Show
import com.example.watcherapp.screens.MovieShow
import com.example.watcherapp.screens.Tv_Show
import com.example.watcherapp.screens.descriptionMovieScreen
import com.example.watcherapp.screens.favScreen


@Composable
fun Navegacao(navController: NavHostController) {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home"){
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
        composable("details"){
            DescriptionMovie_Show( "1022789", navController = navController)
        }
        composable("video"){
            Log.i("ABC", "video")
            VideoPlayer(idVideo = "8IhNq0ng-wk")
        }
    }
}
//        composable(
//            route = "detailsMovie/{idMovie}",
//            arguments = listOf(navArgument(("idMovie")) { type = NavType.StringType } )
//        ){
//            navBackStackEntry ->
//            val id = navBackStackEntry.arguments?.getString(("idMovie"))
//            if (id != null) {
//                DescriptionMovie_Show(id, navController)
//            }
//        }