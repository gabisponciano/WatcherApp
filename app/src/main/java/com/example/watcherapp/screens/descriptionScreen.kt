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
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.watcherapp.R
import com.example.watcherapp.components.MyNavigationDrawer
import com.example.watcherapp.components.Screen
import com.example.watcherapp.components.saveButton
import com.example.watcherapp.components.trailerButton
import com.example.watcherapp.ui.theme.background
import com.example.watcherapp.ui.theme.greenComponent

@Composable
fun descriptionScreen(navController: NavHostController){
    Column (modifier = Modifier
        .fillMaxSize()
        .paint(painterResource(R.drawable.movie)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color.Black.copy(alpha = 0.9f),
                            Color.Black.copy(0.7f)
                        )
                    )
                ),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier.height(500.dp),
                contentAlignment = Alignment.TopCenter
            ) {
                Column(
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier.fillMaxSize()

                ) {
                    Text(
                        text = "Escolha Perfeita",
                        fontSize = 42.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier.padding(15.dp)
                    )
                    Row(horizontalArrangement = Arrangement.SpaceBetween) {
                        Text(
                            text = "2012",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Thin,
                            color = Color.White,
                            modifier = Modifier.padding(15.dp)

                        )

                        Text(
                            text = "12.156",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = greenComponent,
                            modifier = Modifier.padding(15.dp)

                        )

                        Text(
                            text = "|",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal,
                            color = Color.White,
                            modifier = Modifier.padding(15.dp)
                        )

                        Text(
                            text = "112mim",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Thin,
                            color = Color.White,
                            modifier = Modifier.padding(15.dp)

                        )
                    }

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp)
                    ) {
                        Column {
                            Text(
                                text = "Mostre seu valor!",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = "Obrigada a ir para a faculdade contra a vontade, a rebelde Beca não se interessa em participar de atividades extracurriculares, até surgir a oportunidade de ingressar no grupo musical Barden Bella e competir no Campeonato Regional de Música.",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Normal,
                                color = Color.White

                            )
                        }

                    }

                    Row(modifier = Modifier.padding(15.dp)) {
                        trailerButton()
                        Spacer(modifier = Modifier.width(12.dp))
                        saveButton()
                    }
                }

            }
        }
    }
}

//@Preview
//@Composable
//fun descriptionPreview(){
//    descriptionScreen()
//}