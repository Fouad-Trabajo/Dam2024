package edu.example.dam2024.features.superhero.data.remote

import edu.example.dam2024.features.superhero.domain.models.Superhero
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface SuperheroService {

    // REST API: POST: Modificar información, GET:Obtener información, DELETE, PUT: Añadir información

    @GET("all.json")
    suspend fun getSuperheroes(): Response<List<SuperheroApiModel>>
    // Estamos usando corrutinas entonces usamos Response, si no usamos corrutinas usamos Call

    @GET("id/{superHeroId}.json")
    suspend fun getSuperhero(@Path("superheroId") superheroId: String): Response<SuperheroApiModel>

}