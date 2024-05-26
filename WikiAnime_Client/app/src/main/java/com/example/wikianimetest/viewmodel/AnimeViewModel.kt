package com.example.wikianimetest.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wikianimetest.Api.AnimeAPI
import com.example.wikianimetest.model.Recommandation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.IOException


class AnimeViewModel : ViewModel() {
    // Liste mutable contenant les recommandations d'anime
    var myList = mutableStateListOf<Recommandation>()

    // Fonction pour charger les données des recommandations d'anime
    fun loadList() {
        // Utilisation d'une coroutine pour effectuer des opérations asynchrones
        viewModelScope.launch(Dispatchers.Default) {
            try {
                // Appel à une fonction asynchrone pour charger les données des animes
                val data = AnimeAPI.loadAllAnime()
                // Coroutine sur le thread principal pour les opérations sur l'interface utilisateur
                launch(Dispatchers.Main) {
                    // Ajout des données chargées à la liste s'il y en a
                    if (data != null) {
                        myList.addAll(data)
                    }
                    // Impression des données chargées et d'un message de confirmation
                    println(data)
                    println("Liste chargée")
                }
            } catch (e: IOException) {
                // Gestion des exceptions en cas d'erreur lors du chargement des données
                e.printStackTrace()
                println("Erreur lors du chargement de la liste")
            }
        }
    }
}


    // var errorMessage = mutableStateOf("")
    // var myList2 = mutableStateListOf<AnimeBean>()
/*
    fun loadFakeData() {
        myList2.add(
            AnimeBean(
                459,
                "One Piece",
                "https://cdn.myanimelist.net/images/anime/1770/97704.jpg",
                "https://myanimelist.net/anime/459/One_Piece_Movie_01",
                "Many years ago, Woonan, a legendary pirate, plundered one-third of the world's gold and stashed it away on his secret island shrouded in mystery. In the present, Luffy and the rest of the Straw Hats c...read more."
            )
        )
        myList2.add(
            AnimeBean(
                52991,
                "Frieren",
                "https://cdn.myanimelist.net/images/anime/1015/138006.jpg",
                "https://myanimelist.net/anime/52991/Sousou_no_Frieren",
                "During their decade-long quest to defeat the Demon King, the members of the hero's party—Himmel himself, the priest Heiter, the dwarf warrior Eisen, and the elven mage Frieren—forge bonds through adve...read more."

            )
        )
        myList2.add(
            AnimeBean(
                20159,
                "Pokemon: The Origin",
                "https://cdn.myanimelist.net/images/anime/7/53701.jpg",
                "https://myanimelist.net/anime/459/One_Piece_Movie_01",
                "Pokémon are marvelous creatures that come in a variety of types and sizes, with abilities, powers, and personalities as diverse as they are numerous. Doctor Yukinari Ookido has dedicated his life to s...read more."
            )
        )
    }

 */
