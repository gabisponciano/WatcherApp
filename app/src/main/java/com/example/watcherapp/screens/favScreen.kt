package com.example.watcherapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.watcherapp.components.MyNavigationDrawer
import com.example.watcherapp.ui.theme.background

@Composable
fun favScreen(navController: NavHostController){

    Column (modifier = Modifier
        .fillMaxSize()
        .background(background))
    {
    }
}

//@Preview
//@Composable
//fun favScreenPreview(){
//    favScreen()
//}