package com.example.backwikianime.apirest

import com.example.backwikianime.beans.RecommandationListBean
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request
import org.springframework.stereotype.Service

@Service
class RecommandationAPI {

    val gson = Gson()
    val client = OkHttpClient()

    fun recommandationAll(): RecommandationListBean {
        try {
            val json = sendGetRecom(url = "/recommendations")
            return gson.fromJson(json, RecommandationListBean::class.java)
        } catch (e: Exception) {
            println("Une erreur s'est produite lors de la conversion du JSON en objet RecommendationListBean : ${e.message}")
            throw e
        }
    }


    // Méthode pour envoyer une requête GET et récupérer la réponse JSON
    fun sendGetRecom(url: String): String {
        val finalURL = "https://myanimelist.p.rapidapi.com/v2/anime$url"
        val request = Request.Builder()
            .url(finalURL)
            .get()
            .addHeader("X-RapidAPI-Key", "4b489b3069msh8c317283701726ap1b7f4bjsnf47f1833e5cc")
            .addHeader("X-RapidAPI-Host", "myanimelist.p.rapidapi.com")
            .build()

        return client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) {
                throw Exception("Réponse du serveur incorrect :${response.code}")
            }
            response.body!!.string()
        }
    }




}
