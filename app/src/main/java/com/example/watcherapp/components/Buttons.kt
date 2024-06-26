package com.example.watcherapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.watcherapp.ui.theme.background
import com.example.watcherapp.ui.theme.redComponent
import kotlinx.coroutines.launch


@Composable
fun Screen(){
    Column ( verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(background)
    ) {
        trailerButton()
        saveButton()
    }
}
@Composable
fun saveButton(){
    val snackbarHostState= remember { SnackbarHostState()} //Depois colocar em ViewModel
    val scope = rememberCoroutineScope() //Snackbar precisa de coroutine


    Box(modifier = Modifier
        .width(86.dp)
        .height(32.dp)
        .border(0.8.dp, color = Color.White, RoundedCornerShape(4.dp))
        .background(Color.Transparent)
        .clickable {
            scope.launch {
                snackbarHostState
                    .showSnackbar("Salvo em Favoritos",
                        withDismissAction = true,
                        duration = SnackbarDuration.Long
                        )
            }

        },
        contentAlignment = Alignment.CenterStart
    ){
        Row (verticalAlignment = Alignment.CenterVertically){
            Icon(
                imageVector = Icons.Filled.Favorite,
                contentDescription = "",
                tint = Color.White
            )


            Spacer(Modifier.width(6.dp))

            Text(text = "Salvar",
                color = Color.White,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
            )

        }
        SnackbarHost(
            hostState = snackbarHostState,
            modifier = Modifier.align(Alignment.BottomCenter)
        )

    }

}

@Composable
fun trailerButton(){
        Box(modifier = Modifier
            .width(86.dp)
            .height(32.dp)
            .clip(RoundedCornerShape(5.dp))
            .background(redComponent)
            .fillMaxSize()
            .clickable {

            },
            contentAlignment = Alignment.CenterStart

        ){
            Row (verticalAlignment = Alignment.CenterVertically){
                Icon(
                    imageVector = Icons.Filled.PlayArrow,
                    contentDescription = "",
                    tint = Color.White
                )

                Spacer(Modifier.width(4.dp))

                Text(text = "Trailer",
                    color = Color.White,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                )

            }
            }
        }




@Preview
@Composable
fun buttonPreview(){
    Screen()
}