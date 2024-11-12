package edu.example.dam2024.features.superhero.data.remote

import edu.example.dam2024.app.di.RemoteModule
import edu.example.dam2024.app.domain.ErrorApp
import edu.example.dam2024.features.superhero.di.SuperheroModule
import edu.example.dam2024.features.superhero.domain.models.Superhero
import org.koin.core.annotation.Single

@Single
class SuperheroApiRemoteDataSource(private val superheroService: SuperheroService) {

    private val apiCall = SuperheroModule().provideSuperheroService(
        retrofit = RemoteModule().provideRetrofit(
            okHttpClient = RemoteModule().provideOkHttpClient(
                loggingInterceptor = RemoteModule().provideLoggingInterceptor()
            ),
        )
    )


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
        val response = apiCall.getSuperheroes()
        return if (response.isSuccessful) {
            val superheroes = response.body()!!.map { it.toModel() }
            Result.success(superheroes)
        } else {
            // hay un error
            TODO()
        }
    }


    suspend fun getSuperhero(id: String): Superhero {
        val response = apiCall.getSuperhero(id)
        return if (response.isSuccessful) {
            response.body()!!.toModel()
        } else {
            TODO()
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