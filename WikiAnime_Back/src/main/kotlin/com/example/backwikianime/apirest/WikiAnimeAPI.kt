package com.example.backwikianime.apirest

import com.example.backwikianime.model.RecommandationService
import com.example.backwikianime.model.RecommendationBean
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/wikianime")
class WikiAnimeAPI(val recommandationService: RecommandationService) {

    // Endpoint pour récupérer toutes les recommandations d'anime
    // Accessible via GET http://localhost:8080/wikianime/recommendations
    @GetMapping("/recommendations")
    fun allAnime(): List<RecommendationBean> {
        // Appelle le service pour récupérer toutes les recommandations d'anime
        val list = recommandationService.allAnime()
        // Retourne la liste des recommandations d'anime récupérée
        return list
    }



































}