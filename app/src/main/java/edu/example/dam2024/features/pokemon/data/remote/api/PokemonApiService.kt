package edu.example.dam2024.features.pokemon.data.remote.api

import edu.example.dam2024.features.pokemon.domain.Pokemon
import edu.example.dam2024.features.pokemon.domain.PokemonListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonApiService {

    //@GET("pokemon")
    //suspend fun getPokemons(): Response<PokemonListResponse>

    @GET("pokemon")
    suspend fun getPokemons(@Query("limit") limit: Int, @Query("offset") offset: Int): Response<PokemonListResponse>


    @GET("pokemon/{id}")
    suspend fun getPokemon(@Path("id") id: String): Response<Pokemon>

}