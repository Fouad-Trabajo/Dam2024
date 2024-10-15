package edu.example.dam2024.features.superhero.data.remote

import edu.example.dam2024.features.superhero.domain.models.Superhero


class SuperheroApiRemoteDataSource {

    val superheroApiClient = SuperheroApiClient()

    fun getSuperheroes(): List<Superhero> {
        superheroApiClient.retrofit
        val response = superheroApiClient.superheroApiService.getSuperheroes()
        return response.body() ?: emptyList()
    }

    fun getSuperhero(id: String): Superhero? {
        superheroApiClient.retrofit
        val response = superheroApiClient.superheroApiService.getSuperhero(id)
        return response.body()
    }
}