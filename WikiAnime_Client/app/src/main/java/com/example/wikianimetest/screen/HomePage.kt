package com.example.wikianimetest.screen

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.wikianimetest.R
import com.example.wikianimetest.Routes
import com.example.wikianimetest.ui.theme.Pink40


@Preview(showBackground = true, showSystemUi = true)
@Preview(showBackground = true, showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HomePagePreview() {
    // Modifier pour remplir l'écran avec le fond bleu foncé
    Surface() {
        HomePage()

    }
}


@Composable
fun HomePage(navController: NavController? = null, ) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(50.dp))

        // Logo de l'application
        Image(
            painter = painterResource(id = R.drawable.bienvenue), // Assurez-vous de remplacer "R.drawable.bienvenue" par votre propre ressource d'image
            contentDescription = "Bievenue",
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f), // Assurez-vous que l'aspect ratio de l'image est préservé
            contentScale = ContentScale.FillWidth // Étirer l'image pour remplir toute la largeur


        )

        Spacer(modifier = Modifier.height(60.dp))

        // Style de texte pour le nom de l'application

            Text(
                text = "Bienvenue sur l'application",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            )

        Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Wiki-Anime",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            )


            Button(

                onClick = {
                    navController?.navigate(Routes.PagePrincipal.route)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp, horizontal = 96.dp),
                border = BorderStroke(width = 1.dp, brush = Brush.linearGradient(listOf( Color.Blue,Pink40) )),
                colors = ButtonDefaults.buttonColors(Color.Transparent)
            ) {
                Text(text = stringResource(id = R.string.welcome))
            }



    }
}