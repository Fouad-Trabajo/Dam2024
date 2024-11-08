package edu.example.dam2024.features.superhero.data.remote

import edu.example.dam2024.app.domain.ErrorApp
import edu.example.dam2024.features.superhero.domain.models.Superhero
import org.koin.core.annotation.Single

@Single
class SuperheroApiRemoteDataSource(private val superheroApiService: SuperheroApiService) {


    // los modelos ApiModel no deben llegar al DataRepistory NUNCA
    suspend fun getSuperheroes(): Result<List<Superhero>> {
        //return apiCall(superheroApiService.requestSuperhero(superheroId))
        val response = superheroApiService.getSuperheroes()
        return if (response.isSuccessful) {
            val superheroes = response.body()!!.map { it.toModel() }
            Result.success(superheroes)
        } else {
            // hay un error
            Result.failure(ErrorApp.ServerErrorApp)
        }
    }

    suspend fun getSuperhero(id: String): Superhero {
        val response = superheroApiService.getSuperhero(id)
        return if (response.isSuccessful) {
            response.body()!!.toModel()
        } else {
            TODO()
        }
    }
}