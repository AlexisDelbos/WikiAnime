package com.example.backwikianime.beans



    data class RecommandationListBean(
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
        val title: String,
        val picture_url: String,
        val myanimelist_url: String,
        val myanimelist_id: Int
    )

    data class RecommendationX(
        val myanimelist_id: Int,
        val myanimelist_url: String,
        val picture_url: String,
        val title: String
    )
