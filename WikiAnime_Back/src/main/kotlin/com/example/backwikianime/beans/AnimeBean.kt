package com.example.backwikianime.beans

class AnimeBean {
    class AnimeBeanList : ArrayList<AnimeBean>()

// Search Anime

    data class AnimeBean(
        val title: String,
        val description: String?,
        val picture_url: String?,
        val myanimelist_url: String?,
        val myanimelist_id: Int
    )


// Get Anime

    data class GetAnimeBean(
        val title_ov: String,
        val title_en: String,
        val synopsis: String,
        val alternative_titles: AlternativeTitles,
        val information: Information,
        val statistics: Statistics,
        val characters: List<Character>,
        val picture_url: String
    )

    data class AlternativeTitles(
        val synonyms: String,
        val japanese: String,
        val english: String,
        val german: String,
        val french: String
    )

    data class Character(
        val name: String,
        val picture_url: String,
        val myanimelist_url: String,
        val voice_actor_name: String,
        val voice_actor_picture_url: String,
        val voice_actor_myanimelist_url: String
    )

    data class Information(
        val type: List<Type>,
        val episodes: String,
        val status: String,
        val aired: String,
        val premiered: List<Premiered>,
        val broadcast: String,
        val producers: List<Producer>,
        val licensors: List<Licensor>,
        val studios: List<Studio>,
        val source: String,
        val genre: String,
        val themes: List<Theme>,
        val duration: String,
        val rating: String,
        val genres: List<Genre>,
        val demographic: List<Demographic>
    )

    data class Statistics(
        val score: Double,
        val ranked: Int,
        val popularity: Int,
        val members: Int,
        val favorites: Int
    )

    data class Type(
        val name: String,
        val url: String
    )

    data class Premiered(
        val name: String,
        val url: String
    )

    data class Producer(
        val name: String,
        val url: String
    )

    data class Licensor(
        val name: String,
        val url: String
    )

    data class Studio(
        val name: String,
        val url: String
    )

    data class Theme(
        val name: String,
        val url: String
    )

    data class Genre(
        val name: String,
        val url: String
    )

    data class Demographic(
        val name: String,
        val url: String
    )

}