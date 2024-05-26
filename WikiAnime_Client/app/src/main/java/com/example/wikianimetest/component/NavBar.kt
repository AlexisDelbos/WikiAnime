package com.example.wikianimetest.component

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.wikianimetest.Routes
import com.example.wikianimetest.ui.theme.WikiAnimeTestTheme

@Preview(showBackground = true, showSystemUi = true)
@Preview(showBackground = true, showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HomeScreenPreview() {
    //Il faut remplacer NomVotreAppliTheme par le thème de votre application
    //Utilisé par exemple dans MainActivity.kt sous setContent {...}
    WikiAnimeTestTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
//            //Jeu de donnée pour la Preview
//            // mainViewModel.myList.addAll(pictureList)
//            AnimeViewModel.searchText.value = "BC"
//            mainViewModel.errorMessage.value = "Un message d'erreur"
//            mainViewModel.runInProgress.value = true
            NavBar(modifier = Modifier.fillMaxWidth(),null)
        }
    }
}



@Composable
fun NavBar(modifier: Modifier, navController: NavController?) {


    // Obtenir la destination actuelle
    val currentRoute = navController?.currentDestination?.route

    println("currentRoute = $currentRoute")
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.Black), // Appliquer le fond noir à la Row
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        NavButton(
            icon = Icons.Default.Home,
            label = "Accueil",
            onClick = { navController?.navigate(Routes.PagePrincipal.route) },
            isSelected = currentRoute == Routes.PagePrincipal.route
        )
        NavButton(
            icon = Icons.Default.Search,
            label = "Search",
            onClick = { navController?.navigate(Routes.AnimeDetailScreen.route) },
            isSelected = currentRoute == Routes.AnimeDetailScreen.route
        )
        NavButton(
            icon = Icons.Default.Favorite,
            label = "Favorites",
            onClick = { navController?.navigate(Routes.HomePage.route) },
            isSelected = currentRoute == Routes.HomePage.route
        )
    }
}

@Composable
fun NavButton(icon: ImageVector, label: String, onClick: () -> Unit, isSelected: Boolean) {
    val textColor = if (isSelected) Color.Green else Color.White
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .clickable(onClick = onClick)
            .padding(8.dp)
    ) {
        Icon(icon, contentDescription = null, tint = textColor)
        Text(
            text = label,
            color = textColor,
            style = TextStyle(color = textColor)
        )
    }
}