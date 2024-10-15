package edu.example.dam2024.features.superhero.data.remote

import edu.example.dam2024.features.superhero.domain.models.Superhero
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface SuperheroApiService {


    @GET("all.json")
    suspend fun getSuperheroes(): Response<List<Superhero>>

    @GET("id/{superHeroId}.json")
    suspend fun getSuperhero(@Path("superheroId") superheroId: String): Response<Superhero>


}