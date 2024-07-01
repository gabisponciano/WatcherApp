package com.example.watcherapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.watcherapp.R
import com.example.watcherapp.screens.MovieShow
import com.example.watcherapp.screens.Tv_Show
import com.example.watcherapp.screens.descriptionScreen
import com.example.watcherapp.screens.favScreen
import com.example.watcherapp.screens.homeScreen
import com.example.watcherapp.ui.theme.componentsBackground
import com.example.watcherapp.ui.theme.redComponent
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyNavigationDrawer(navController: NavHostController) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Text("Home", modifier = Modifier.padding(16.dp))
                HorizontalDivider()
                NavigationDrawerItem(
                    label = { Text(text = "Filmes") },
                    selected = false,
                    onClick = { navController.navigate("movies") }
                )
                NavigationDrawerItem(
                    label = { Text(text = "Séries") },
                    selected = false,
                    onClick = { navController.navigate("shows") }
                )
            }
        },
    ) {
        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = componentsBackground,
                        titleContentColor = MaterialTheme.colorScheme.primary,
                    ),
                    title = {
                        Image(painterResource(R.drawable.popcorn) , contentDescription = null,
                            modifier = Modifier.size(46.dp)
                            )

                    },
                    navigationIcon = {
                        IconButton(onClick = {
                            scope.launch {
                                drawerState.apply {
                                    if (isClosed) open() else close()
                                }
                            }
                        }) {
                            Icon(Icons.Filled.Menu, contentDescription = "Navigation Icon",
                                tint = Color.White,
                                modifier = Modifier.size(42.dp)
                                )
                        }
                    },
                    actions = {
                        IconButton(onClick = { navController.navigate("favs") }
                        ) {
                            Icon(Icons.Filled.Favorite, contentDescription = "Action Icon",
                                tint = redComponent,
                                modifier = Modifier.size(42.dp)
                                )
                        }
                    },
                    scrollBehavior = scrollBehavior,
                )
            }
        ) { contentPadding ->
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "movies"){
                composable("home"){
                    homeScreen()
                }
                composable("movies"){
                    MovieShow(navController)
                }
                composable("shows"){
                    Tv_Show()
                }
                composable("favs"){
                    favScreen(navController = navController)
                }
                composable("description"){
                    descriptionScreen()
                }
                composable("video"){
                    VideoPlayer(idVideo = "8IhNq0ng-wk")
                }
            }

        }
    }
}

//@Preview
//@Composable
//fun PreviewTopBar(){
//        MyNavigationDrawer()
//
//}