package com.example.watcherapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.watcherapp.components.MyNavigationDrawer
import com.example.watcherapp.ui.theme.background

@Composable
fun favScreen(){

    Column (modifier = Modifier
        .fillMaxSize()
        .background(background))
    {
        MyNavigationDrawer()
    }
}

@Preview
@Composable
fun favScreenPreview(){
    favScreen()
}