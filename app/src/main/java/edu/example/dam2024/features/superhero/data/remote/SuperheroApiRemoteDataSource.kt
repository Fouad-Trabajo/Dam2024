package edu.example.dam2024.features.superhero.data.remote

import edu.example.dam2024.app.data.remote.apiCall
import edu.example.dam2024.app.di.RemoteModule
import edu.example.dam2024.app.domain.ErrorApp
import edu.example.dam2024.features.superhero.di.SuperheroModule
import edu.example.dam2024.features.superhero.domain.models.Superhero
import org.koin.core.annotation.Single

@Single
class SuperheroApiRemoteDataSource(private val superheroService: SuperheroService) {


    // los modelos ApiModel no deben llegar al DataRepistory NUNCA
    suspend fun getSuperheroes(): Result<List<Superhero>> {
        //return apiCall(superheroApiService.requestSuperhero(superheroId))
        return apiCall { superheroService.getSuperheroes() }.map { superheroService ->
            superheroService.map { it.toModel() }
        }
    }


    /*
        suspend fun getSuperheroes(): Result<List<Superhero>> {
            return apiCall { superheroService.getSuperheroes() }
                .map { superheroApiList ->
                    superheroApiList.map { it.toModel() }
                }
        }

     */

    /*
        suspend fun getSuperhero(id: String): Superhero {
            val response = superheroService.getSuperhero(id)
            return if (response.isSuccessful) {
                response.body()!!.toModel()
            } else {
                TODO()
            }
        }

     */
}