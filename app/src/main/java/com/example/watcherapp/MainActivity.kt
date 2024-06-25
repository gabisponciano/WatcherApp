package com.example.watcherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.watcherapp.screens.favScreen
import com.example.watcherapp.screens.homeScreen
import com.example.watcherapp.screens.movieScreen
import com.example.watcherapp.screens.showsScreen
import com.example.watcherapp.ui.theme.WatcherAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WatcherAppTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "home"){
                    composable("home"){
                        homeScreen()
                    }
                    composable("movies"){
                        movieScreen()
                    }
                    composable("shows"){
                        showsScreen()
                    }
                    composable("favs"){
                        favScreen()
                    }
                }

            }
        }
    }
}

