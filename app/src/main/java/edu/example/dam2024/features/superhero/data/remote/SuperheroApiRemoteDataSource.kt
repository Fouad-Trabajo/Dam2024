package edu.example.dam2024.features.superhero.data.remote

import edu.example.dam2024.features.superhero.domain.models.Superhero
import org.koin.core.annotation.Single

@Single
class SuperheroApiRemoteDataSource(private val superheroService: SuperheroService) {


    // los modelos ApiModel no deben llegar al DataRepistory NUNCA
    suspend fun getSuperheroes(): List<Superhero> {
        val response = superheroService.getSuperheroes()
        return if (response.isSuccessful) {
             response.body()!!.map{ it.toModel()}
        }else{
             emptyList()
        }
    }

    suspend fun getSuperhero(id: String): Superhero {
        val response = superheroService.getSuperhero(id)
        return response.body()!!.toModel()
    }
}