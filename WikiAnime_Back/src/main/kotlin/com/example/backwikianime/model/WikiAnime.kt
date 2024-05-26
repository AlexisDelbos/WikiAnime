package com.example.backwikianime.model

import com.example.backwikianime.apirest.RecommandationAPI
import com.example.backwikianime.beans.Recommendation
import jakarta.persistence.*
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service


@Entity
@Table(name = "recommendations")
data class RecommendationBean(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,
    val liked: Boolean? = null,
    val title: String? = null,
    @Column(name = "picture_url")
    val pictureUrl: String? = null,
    @Column(name = "myanimelist_url")
    val myanimelistUrl: String? = null,
    @Column(name = "myanimelist_id")
    val myanimelistId: Int? = null,
    val description: String? = null,
    @Column(name = "author_name")
    val authorName: String? = null,
    @Column(name = "author_url")
    val authorUrl: String? = null,
    @Column(name = "recommendation_age")
    val recommendationAge: String? = null
) {
}

@Repository
interface RecommendationRepository  : JpaRepository<RecommendationBean, Int> {

}
@Service
class RecommandationService(val recommandationAPI: RecommandationAPI, val animeRep :RecommendationRepository) {

    // Fonction pour récupérer toutes les recommandations d'anime depuis la base de données
    fun allAnime() = animeRep.findAll()
    fun getRecoAnime(url: String) {
        // Appel à la méthode de l'API externe pour récupérer toutes les recommandations d'anime
        val listAnime = recommandationAPI.recommandationAll()

        for (recommendationBean in listAnime.recommendations) {
            // Convertit chaque recommandation d'anime au format de bean souhaité
            val recommendation = convertToRecommendation(recommendationBean)
            // Enregistre la recommandation d'anime convertie dans la base de données
            animeRep.save(recommendation)
        }
    }

    // Fonction pour convertir une recommandation d'anime au format souhaité
    private fun convertToRecommendation(recommendationBean: Recommendation): RecommendationBean {
        return RecommendationBean(
            liked = recommendationBean.liked.title == "yes",
            title = recommendationBean.recommendation.title,
            pictureUrl = recommendationBean.liked.picture_url,
            myanimelistUrl = recommendationBean.liked.myanimelist_url,
            myanimelistId = recommendationBean.liked.myanimelist_id,
            description = recommendationBean.description,
            authorName = recommendationBean.author.name,
            authorUrl = recommendationBean.author.url,
            recommendationAge = recommendationBean.recommendation_age
        )
    }





















}


