package com.example.wikianimetest.Api


import com.example.wikianimetest.model.Recommandation
import com.google.gson.Gson
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request


fun main() {
    AnimeAPI.loadAllAnime()

}
object AnimeAPI{

    val MEDIA_TYPE_JSON = "application/json; charset=utf-8".toMediaType()
    val gson = Gson()
    val client = OkHttpClient()

    private const val URL_SERVER = "http://10.0.2.2:8080"

    /*fun getOneAnime(id : Int): GetAnimeBean{
        val json = sendGetAnime("/$id")
        return gson.fromJson(json, GetAnimeBean::class.java)
    }*/

    fun recommandationAll() : Recommandation {
        val json = sendGetRecommandation(url = "/recommendations")
        return gson.fromJson(json, Recommandation::class.java)
    }

    fun loadAllAnime(): List<Recommandation> {
        var json = sendGet("$URL_SERVER/wikianime/recommendations")
        val test = gson.fromJson(json, Array<Recommandation>::class.java).toList()
        println(test)
        return test
    }


    fun sendGet(url: String): String {
        println("url : $url")
        val request = Request.
        Builder().
        url(url).
        get().
        build()

        return client.newCall(request).execute().use { //it:Response
            if (!it.isSuccessful) {
                throw Exception("Réponse du serveur incorrect :${it.code}")
            }
            it.body.string()
        }
    }

    // A UTILISER PLUS TARD

    //
    //    fun searchAnime(name : String?) : AnimeBean{
    //        val json = sendGet("/search?q=$name")
    //        val data = gson.fromJson(json, AnimeBean::class.java)
    //        return data
    //    }

    // Get Anime
    fun sendGetAnime(url: String): String {
        val finalURL = "https://myanimelist.p.rapidapi.com/anime$url"
        println("finalURL : $finalURL")
        val request = Request.Builder()
            .url(finalURL)
            .get()
            .addHeader("X-RapidAPI-Key", "4b489b3069msh8c317283701726ap1b7f4bjsnf47f1833e5cc")
            .addHeader("X-RapidAPI-Host", "myanimelist.p.rapidapi.com")
            .build()

        return client.newCall(request).execute().use { //it:Response
            if (!it.isSuccessful) {
                throw Exception("Réponse du serveur incorrect :${it.code}")
            }
            it.body.string()
        }
    }




    fun sendGetRecommandation(url: String): String {
        val finalURL = "https://myanimelist.p.rapidapi.com/v2/anime$url"
        println("finalURL : $finalURL")
        val request = Request.Builder()
            .url(finalURL)
            .get()
            .addHeader("X-RapidAPI-Key", "4b489b3069msh8c317283701726ap1b7f4bjsnf47f1833e5cc")
            .addHeader("X-RapidAPI-Host", "myanimelist.p.rapidapi.com")
            .build()

        return client.newCall(request).execute().use { //it:Response
            if (!it.isSuccessful) {
                throw Exception("Réponse du serveur incorrect :${it.code}")
            }
            it.body.string()
        }
    }
}

/* fun main() {
    var test1 = AnimeAPI.recommandationAll()
    println(test1.recommendations[0].recommendation.myanimelist_id)
    println(AnimeAPI.getOneAnime(test1.recommendations[0].recommendation.myanimelist_id))

} */