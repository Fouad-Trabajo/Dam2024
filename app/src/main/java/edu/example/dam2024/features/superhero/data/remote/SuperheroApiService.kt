package edu.example.dam2024.features.superhero.data.remote

import android.telecom.Call
import edu.example.dam2024.features.superhero.domain.models.SuperheroApi
import okhttp3.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url


interface SuperheroApiService {


    @GET("all.json")
    fun getSuperheroes(@Url url: String): Response<SuperheroApi>

    @GET("id/{superHeroId}.json")
    fun getSuperhero(@Path("superheroId") superheroId: Int): Call<SuperheroApi>


}