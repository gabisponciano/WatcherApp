package com.example.watcherapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.watcherapp.ui.theme.background

@Composable
fun showsScreen(){
    Column (modifier = Modifier
        .fillMaxSize()
        .background(background)){

    }
}

@Preview
@Composable
fun showsPreview(){
    showsScreen()
}