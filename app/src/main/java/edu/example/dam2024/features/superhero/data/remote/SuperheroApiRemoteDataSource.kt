package edu.example.dam2024.features.superhero.data.remote

import edu.example.dam2024.features.superhero.data.remote.api.SuperheroApiService
import edu.example.dam2024.features.superhero.domain.models.Superhero


class SuperheroApiRemoteDataSource(private val superheroApiService: SuperheroApiService) {


    suspend fun getSuperheroes(): List<Superhero> {
        val response = superheroApiService.getSuperheroes()
        return if (response.isSuccessful) {
             response.body()!!
        }else{
             emptyList()
        }
    }

    suspend fun getSuperhero(id: String): Superhero? {
        val response = superheroApiService.getSuperhero(id)
        return response.body()
    }
}