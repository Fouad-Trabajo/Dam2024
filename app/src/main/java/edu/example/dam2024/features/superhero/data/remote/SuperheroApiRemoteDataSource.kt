package edu.example.dam2024.features.superhero.data.remote

import edu.example.dam2024.features.superhero.domain.models.Superhero


class SuperheroApiRemoteDataSource {

    val superheroApiClient = SuperheroApiClient()

    suspend fun getSuperheroes(): List<Superhero> {
        superheroApiClient.retrofit
        val response = superheroApiClient.superheroApiService.getSuperheroes()
        return response.body() ?: emptyList()
    }

    suspend fun getSuperhero(id: String): Superhero? {
        superheroApiClient.retrofit
        val response = superheroApiClient.superheroApiService.getSuperhero(id)
        return response.body()
    }
}