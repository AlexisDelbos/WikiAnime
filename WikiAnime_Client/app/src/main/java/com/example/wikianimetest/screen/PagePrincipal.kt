package com.example.wikianimetest.screen

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import com.example.wikianimetest.R
import com.example.wikianimetest.Routes
import com.example.wikianimetest.component.NavBar
import com.example.wikianimetest.model.Recommandation
import com.example.wikianimetest.ui.theme.WikiAnimeTestTheme
import com.example.wikianimetest.viewmodel.AnimeViewModel

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

        }
    }
}

@Composable
fun HomeScreen(
    navHostController: NavHostController? = null,
    animeViewModel: AnimeViewModel
) {
    LaunchedEffect(key1 = "") {
        animeViewModel.loadList()
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Text(
            text = " Wiki-Anime",
            fontSize = 35.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
            style = MaterialTheme.typography.titleLarge.copy(color = Color.Green), // Appliquer la couleur verte
        )
        Spacer(modifier = Modifier.height(30.dp))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp), // La disposition verticale avec un espacement de 8dp entre les éléments
            modifier = Modifier.weight(1f) // Un modificateur pour spécifier le poids de la colonne
        ) {
            items(animeViewModel.myList.size / 2) { index ->
                val firstAnime = animeViewModel.myList[index * 2] // Prend le premier anime du groupe actuel
                val secondAnime = animeViewModel.myList[index * 2 + 1] // Prend le deuxième anime du groupe actuel
                Row(modifier = Modifier.fillMaxWidth()) { // Crée une rangée qui remplit toute la largeur disponible
                    RecommandationItem( // Affiche le premier anime
                        data = firstAnime,
                        onPictureClick = { navHostController?.navigate(Routes.AnimeDetailScreen.withObject(firstAnime)) },
                        animeViewModel = animeViewModel,
                        modifier = Modifier.weight(1f) // Utilise le poids pour occuper la même quantité d'espace que le deuxième anime
                    )
                    RecommandationItem( // Affiche le deuxième anime
                        data = secondAnime,
                        onPictureClick = { navHostController?.navigate(Routes.AnimeDetailScreen.withObject(secondAnime)) },
                        animeViewModel = animeViewModel,
                        modifier = Modifier.weight(1f) // Utilise le poids pour occuper la même quantité d'espace que le premier anime
                    )
                }
            }
        }


        Spacer(modifier = Modifier.height(16.dp)) // Espacement entre la liste et la barre de navigation
        NavBar(modifier = Modifier.height(56.dp), navController = navHostController ) // La barre de navigation a une hauteur fixe de 56.dp
    }
}


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun RecommandationItem(
    modifier: Modifier = Modifier,
    data: Recommandation, // Les données de l'anime à afficher
    onPictureClick: () -> Unit, // Action à effectuer lors du clic sur l'image de l'anime
    animeViewModel: AnimeViewModel // ViewModel associé à l'anime
) {
    Column(
        modifier = modifier
            .padding(8.dp), // Ajoute un padding de 8dp autour de la colonne
        horizontalAlignment = Alignment.CenterHorizontally // Centre les éléments horizontalement dans la colonne
    ) {
        GlideImage(
            model = data.pictureUrl, // URL de l'image à charger
            contentDescription = "Image Anime", // Description de l'image pour l'accessibilité
            loading = placeholder(R.mipmap.ic_launcher_round),
            failure = placeholder(R.mipmap.ic_launcher),
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .height(300.dp) // Hauteur de l'image
                .fillMaxWidth() // Remplit toute la largeur disponible
                .clickable { onPictureClick.invoke() } // Rend l'image cliquable, invoque onPictureClick lors du clic
        )
        Text( // Affiche le titre de l'anime
            text = data.title.take(30), // Prend les 30 premiers caractères du titre
            modifier = Modifier.padding(8.dp)
                .clickable { onPictureClick.invoke() },
            style = MaterialTheme.typography.titleMedium.copy(color = Color.Green), // Style du texte
            textAlign = TextAlign.Center // Centre le texte horizontalement
        )
    }
}








/*

// SearchAnimeBean
@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun AnimeItem(modifier: Modifier = Modifier, animeBean: AnimeBean) {

    var expended by remember { mutableStateOf(false) }

    Row(modifier = modifier.background(MaterialTheme.colorScheme.surfaceVariant)) {

//Permission Internet nécessaire
        GlideImage(
            model = animeBean.picture_url,
            //Dans string.xml
            //contentDescription = getString(R.string.picture_of_cat),
            //En dur
            contentDescription = "une photo de chat",
            // Image d'attente. Permet également de voir l'emplacement de l'image dans la Preview
            loading = placeholder(R.mipmap.ic_launcher_round),
            // Image d'échec de chargement
            failure = placeholder(R.mipmap.ic_launcher),
            contentScale = ContentScale.Fit,
            //même autres champs qu'une Image classique
            modifier = Modifier
                .heightIn(max = 100.dp) //Sans hauteur il prendra tous l'écran
                .widthIn(max = 100.dp)

        )


        Column(modifier = Modifier.padding(5.dp)) {
            animeBean.title?.let {
                Text(
                    text = it,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                )
            }
            Spacer(Modifier.size(8.dp))
            Text(
                text = "Description : ${animeBean.description}",
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .clickable {
                        expended = !expended
                    }
                    .animateContentSize()
            )
        }
    }

}
*/