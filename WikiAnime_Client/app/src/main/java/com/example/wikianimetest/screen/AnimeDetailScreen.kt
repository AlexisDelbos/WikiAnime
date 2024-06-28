package com.example.wikianimetest.screen


import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import com.example.wikianimetest.R
import com.example.wikianimetest.ui.theme.WikiAnimeTestTheme
import com.example.wikianimetest.viewmodel.AnimeViewModel

//Code affiché dans la Preview, thème claire, thème sombre
@Preview(showBackground = true, showSystemUi = true)
@Preview(showBackground = true, showSystemUi = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun AnimeDetailPreview() {
    WikiAnimeTestTheme {
        Surface {
            AnimeDetailScreen(10, animeViewModel = AnimeViewModel())
        }
    }
}


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun AnimeDetailScreen(
    id: Int?,
    navHostController: NavHostController? = null,
    animeViewModel: AnimeViewModel
) {

    val anime = animeViewModel.myList.find { it.id == id }
    val scrollState = rememberScrollState()
    var animateDescriptionState by remember{ mutableStateOf(false) }


    Column(
        modifier = Modifier
            // Taille complète
            .fillMaxSize()
            // Scroll
            .verticalScroll(scrollState)
            // Couleur de fond
            .background(Color.Black) // Utilisation d'une couleur de fond légèrement grisée
    ) {
            if (anime != null) {
                GlideImage(
                    model = anime.pictureUrl,
                    contentDescription = "photo anime",
                    loading = placeholder(R.mipmap.ic_launcher_round),
                    failure = placeholder(R.mipmap.ic_launcher),
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .height(300.dp)
                        .fillMaxWidth()
                )
            }
        Spacer(modifier = Modifier.height(25.dp))
            if (anime != null) {
                Text(
                    text = anime.title,
                    modifier = Modifier.padding(8.dp),
                    textAlign = TextAlign.Left,
                    style = TextStyle(color = Color.Green, fontSize = 30.sp),

                    )
            }


        Spacer(modifier = Modifier.height(16.dp))


            Text(
                text = "Synopsis",
                modifier = Modifier.padding(8.dp),
                textAlign = TextAlign.Left,
                style = TextStyle(color = Color.Green, fontSize = 20.sp, lineHeight = 30.sp),

                )

        Divider( // Ajoute une barre de délimitation
            color = Color.DarkGray,
            thickness = 2.dp,
            modifier = Modifier.padding(vertical = 8.dp) // Padding vertical autour de la barre
        )



            if (anime != null) {
                Text(
                    text = anime.description,
                    modifier = Modifier.clickable {
                        animateDescriptionState = !animateDescriptionState
                    }.animateContentSize()
                        .padding(8.dp),
                    textAlign = TextAlign.Left,
                    style = TextStyle(color = Color.White, fontSize = 16.sp, lineHeight = 30.sp),
                    maxLines = if (animateDescriptionState) Int.MAX_VALUE else 3,
                    overflow = TextOverflow.Ellipsis
                    )

            }

        Spacer(modifier = Modifier.height(16.dp))




            if (anime != null) {
                Text(
                    text = "Auteur de l'anime",
                    modifier = Modifier.padding(8.dp),
                    textAlign = TextAlign.Left,
                    style = TextStyle(color = Color.Green, fontSize = 20.sp, lineHeight = 30.sp),

                    )

            }
        Divider( // Ajoute une barre de délimitation
            color = Color.DarkGray,
            thickness = 2.dp,
            modifier = Modifier.padding(vertical = 8.dp) // Padding vertical autour de la barre
        )





            if (anime != null) {
                Text(
                    text = anime.authorName,
                    modifier = Modifier.padding(8.dp),
                    textAlign = TextAlign.Left,
                    style = TextStyle(color = Color.White,fontSize = 16.sp, lineHeight = 30.sp),

                    )

            }

    }
}
