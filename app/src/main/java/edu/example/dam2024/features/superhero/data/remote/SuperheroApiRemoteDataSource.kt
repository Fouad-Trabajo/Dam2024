package edu.example.dam2024.features.superhero.data.remote

import edu.example.dam2024.app.data.remote.apiCall
import edu.example.dam2024.app.domain.ErrorApp
import edu.example.dam2024.features.superhero.domain.models.Superhero
import org.koin.core.annotation.Single

@Single
class SuperheroApiRemoteDataSource(private val superheroService: SuperheroService) {


    // los modelos ApiModel no deben llegar al DataRepistory NUNCA
    suspend fun getSuperheroesMAl(): Result<List<Superhero>> {
        //return apiCall(superheroApiService.requestSuperhero(superheroId))
        val response = superheroService.getSuperheroes()
        return if (response.isSuccessful) {
            val superheroes = response.body()!!.map { it.toModel() }
            Result.success(superheroes)
        } else {
            // hay un error
            Result.failure(ErrorApp.ServerErrorApp)
        }
    }

    suspend fun getSuperheroes(): Result<List<Superhero>> {
        return apiCall {
            superheroService.getSuperheroes()
        }.map { responseList ->
            responseList.map { it.toModel() } // Convierte cada elemento a tu modelo de dominio
        }
    }

    suspend fun getSuperhero(id: String): Superhero {
        val response = superheroService.getSuperhero(id)
        return if (response.isSuccessful) {
            response.body()!!.toModel()
        } else {
            TODO()
        }
    }
}