package com.example.watcherapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.watcherapp.R
import com.example.watcherapp.components.saveButton
import com.example.watcherapp.components.trailerButton
import com.example.watcherapp.network.data.DetailsMovie
import com.example.watcherapp.ui.theme.greenComponent

@Composable
fun DetailsMovieShow( navController: NavHostController){
    Text(text = "Teste")
//    when (val state = viewModel.movieUiState){
//        Loading -> LoadingScreenDes()
//        is MovieDescriptionUiState.Success -> descriptionScreen(moviedetails = state.movieDetails, navController)
//        is MovieDescriptionUiState.Error -> ErrorScreenDes()
//    }
}

//@Composable
//fun LoadingScreenDes() {
//    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
//        CircularProgressIndicator()
//    }
//}
//
//@Composable
//fun ErrorScreenDes() {
//    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
//        Text("Erro ao carregar")
//    }
//}
//@Composable
//fun descriptionScreen(
////    movies: Lis,
//    navController: NavHostController
//){
//    Column (modifier = Modifier
//        .fillMaxSize()
//        .paint(painterResource(R.drawable.movie)),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center
//    ) {
//        Box(
//            modifier = Modifier
//                .fillMaxSize()
//                .background(
//                    brush = Brush.horizontalGradient(
//                        colors = listOf(
//                            Color.Black.copy(alpha = 0.9f),
//                            Color.Black.copy(0.7f)
//                        )
//                    )
//                ),
//            contentAlignment = Alignment.Center
//        ) {
//            Box(
//                modifier = Modifier.height(500.dp),
//                contentAlignment = Alignment.TopCenter
//            ) {
//                Column(
//                    horizontalAlignment = Alignment.Start,
//                    modifier = Modifier.fillMaxSize()
//
//                ) {
//                    Text(
//                        text = moviedetails.title,
//                        fontSize = 42.sp,
//                        fontWeight = FontWeight.Bold,
//                        color = Color.White,
//                        modifier = Modifier.padding(15.dp)
//                    )
//                    Row(horizontalArrangement = Arrangement.SpaceBetween) {
//                        Text(
//                            text = moviedetails.releaseDate,
//                            fontSize = 16.sp,
//                            fontWeight = FontWeight.Thin,
//                            color = Color.White,
//                            modifier = Modifier.padding(15.dp)
//
//                        )
//
//                        Text(
//                            text = moviedetails.popularity.toString(),
//                            fontSize = 16.sp,
//                            fontWeight = FontWeight.Bold,
//                            color = greenComponent,
//                            modifier = Modifier.padding(15.dp)
//
//                        )
//
//                        Text(
//                            text = "|",
//                            fontSize = 16.sp,
//                            fontWeight = FontWeight.Normal,
//                            color = Color.White,
//                            modifier = Modifier.padding(15.dp)
//                        )
//
//                        Text(
//                            text = moviedetails.runtime.toString(),
//                            fontSize = 16.sp,
//                            fontWeight = FontWeight.Thin,
//                            color = Color.White,
//                            modifier = Modifier.padding(15.dp)
//
//                        )
//                    }
//
//                    Box(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(20.dp)
//                    ) {
//                        Column {
//                            Text(
//                                text = moviedetails.tagline,
//                                fontSize = 18.sp,
//                                fontWeight = FontWeight.Bold,
//                                color = Color.White
//                            )
//                            Spacer(modifier = Modifier.height(8.dp))
//                            Text(
//                                text = moviedetails.overview,
//                                fontSize = 16.sp,
//                                fontWeight = FontWeight.Normal,
//                                color = Color.White
//
//                            )
//                        }
//
//                    }
//
//                    Row(modifier = Modifier.padding(15.dp)) {
//                        trailerButton()
//                        Spacer(modifier = Modifier.width(12.dp))
//                        saveButton()
//                    }
//                }
//
//            }
//        }
//    }
//}