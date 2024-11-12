package edu.example.dam2024.app.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    // Define las URL base para tus APIs
    private const val BASE_URL_SUPERHERO = "https://akabab.github.io/superhero-api/api/"
    const val BASE_URL_POKEMON = "https://pokeapi.co/api/v2/"

    // Un mapa para almacenar servicios
    private val serviceMap = mutableMapOf<String, Any>()

    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL_POKEMON)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
