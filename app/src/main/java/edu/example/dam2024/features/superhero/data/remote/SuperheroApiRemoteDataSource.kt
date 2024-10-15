package edu.example.dam2024.features.superhero.data.remote

import edu.example.dam2024.features.superhero.data.remote.api.SuperheroApiClient
import edu.example.dam2024.features.superhero.domain.models.Superhero

class SuperheroApiRemoteDataSource {

    private val superheroApiClient = SuperheroApiClient()

    suspend fun getSuperheroes(): List<Superhero> {
        val response = superheroApiClient.superheroApiService.getSuperheroes()
        return if (response.isSuccessful) {
            response.body() ?: emptyList()
        } else {
            // Manejo de errores, puedes lanzar una excepción o manejarlo como desees
            emptyList() // o lanzar una excepción
        }
    }

    suspend fun getSuperhero(id: String): Superhero? {
        val response = superheroApiClient.superheroApiService.getSuperhero(id)
        return if (response.isSuccessful) {
            response.body()
        } else {
            // Manejo de errores, puedes lanzar una excepción o manejarlo como desees
            null // o lanzar una excepción
        }
    }
}
