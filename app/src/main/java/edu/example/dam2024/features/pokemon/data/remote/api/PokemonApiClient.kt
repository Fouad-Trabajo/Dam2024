package edu.example.dam2024.features.pokemon.data.remote.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PokemonApiClient {

    private val BASE_URL = "https://pokeapi.co/api/v2/"

    private val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()).build()

    val pokemonApiService: PokemonApiService =
        retrofit.create(PokemonApiService::class.java)

}