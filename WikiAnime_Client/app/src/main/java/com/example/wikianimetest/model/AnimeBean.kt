package com.example.wikianimetest.model



// Recommandation qu'on appelle de la BDD donc pas besoin d'un bean exact de l'API

data class Recommandations (
    val recommendations: List<Recommandation>
)
data class Recommandation(
    val authorName: String,
    val authorUrl: String,
    val description: String,
    val id: Int,
    val liked: Boolean,
    val myanimelistId: Int,
    val myanimelistUrl: String,
    val pictureUrl: String,
    val recommendationAge: String,
    val title: String
)








data class RecommandationBean(
    val amount_recommendations: Int,
    val recommendations: List<Recommendation>
)

data class Recommendation(
    val author: Author,
    val description: String,
    val liked: Liked,
    val recommendation: RecommendationX,
    val recommendation_age: String
)



data class Author(
    val name: String,
    val url: String
)

data class Liked(
    val myanimelist_id: Int,
    val myanimelist_url: String,
    val picture_url: String,
    val title: String
)

data class RecommendationX(
    val myanimelist_id: Int,
    val myanimelist_url: String,
    val picture_url: String,
    val title: String
)


// Search Anime

class SearchAnimeBean : ArrayList<SearchAnimeBeanItem>()

data class SearchAnimeBeanItem(
    val description: String,
    val myanimelist_id: Int,
    val myanimelist_url: String,
    val picture_url: String,
    val title: String
)


// Get Anime

data class GetAnimeBean(
    val myanimelist_id: Int? = null,
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

