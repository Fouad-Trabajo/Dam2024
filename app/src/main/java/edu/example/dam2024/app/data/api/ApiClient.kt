package edu.example.dam2024.app.data.api

import edu.example.dam2024.features.pokemon.data.remote.PokemonApiService
import edu.example.dam2024.features.superhero.data.remote.SuperheroApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private const val BASE_URL_SUPERHERO = "https://akabab.github.io/superhero-api/api/"
    const val BASE_URL_POKEMON = "https://pokeapi.co/api/v2/"

    private fun provideRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL_POKEMON)
            .addConverterFactory(GsonConverterFactory.create()).build()
        //Es muy importante añadir el converter
    }

    fun provideSuperheroService(): SuperheroApiService {
        return provideRetrofit().create(SuperheroApiService::class.java)
    }

    fun providePokemonService(): PokemonApiService {
        return provideRetrofit().create(PokemonApiService::class.java)
    }
}