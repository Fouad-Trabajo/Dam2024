package edu.example.dam2024.features.superhero.data.remote

import edu.example.dam2024.features.superhero.data.remote.api.SuperheroApiClient
import edu.example.dam2024.features.superhero.domain.models.Superhero


class SuperheroApiRemoteDataSource {

    private val superheroApiClient = SuperheroApiClient()

    suspend fun getSuperheroes(): List<Superhero> {
        val response = superheroApiClient.superheroApiService.getSuperheroes()
        return response.body() ?: emptyList()
    }

    suspend fun getSuperhero(id: String): Superhero? {
        val response = superheroApiClient.superheroApiService.getSuperhero(id)
        return response.body()
    }
}