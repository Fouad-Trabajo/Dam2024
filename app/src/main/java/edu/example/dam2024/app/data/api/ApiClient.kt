package edu.example.dam2024.app.data.api

import edu.example.dam2024.features.pokemon.data.remote.PokemonApiService
import edu.example.dam2024.features.superhero.data.remote.SuperheroApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    // Define las URL base para tus APIs
    private const val BASE_URL_SUPERHERO = "https://akabab.github.io/superhero-api/api/"
    const val BASE_URL_POKEMON = "https://pokeapi.co/api/v2/"

    // Un mapa para almacenar servicios
    private val serviceMap = mutableMapOf<String, Any>()

    // Método genérico para crear el cliente Retrofit
    private fun <T> createService(baseUrl: String, serviceClass: Class<T>): T {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(serviceClass)
    }

    // Método para obtener un servicio, creando uno nuevo si no existe
    private fun <T : Any> provideService(baseUrl: String, serviceClass: Class<T>): T {
        return serviceMap[baseUrl] as? T ?: createService(baseUrl, serviceClass).also {
            serviceMap[baseUrl] = it
        }
    }

    // Métodos específicos para obtener tus servicios
    fun provideSuperheroService(): SuperheroApiService {
        return provideService(BASE_URL_SUPERHERO, SuperheroApiService::class.java)
    }

    fun providePokemonService(): PokemonApiService {
        return provideService(BASE_URL_POKEMON, PokemonApiService::class.java)
    }
}
