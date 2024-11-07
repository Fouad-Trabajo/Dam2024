package edu.example.dam2024.features.superhero.presentation

import android.content.Context
import edu.example.dam2024.app.data.api.ApiClient
import edu.example.dam2024.features.superhero.data.SuperheroDataRepository
import edu.example.dam2024.features.superhero.data.local.SuperheroXmlLocalDataSource
import edu.example.dam2024.features.superhero.data.remote.SuperheroApiRemoteDataSource
import edu.example.dam2024.features.superhero.domain.GetSuperheroesUseCase
import edu.example.dam2024.features.superhero.domain.GetSuperheroUseCase

class SuperheroFactory(private val context: Context) {

    //Todas estas dependencias, deben seguir un orden de dependencia

    private val superheroApiService = ApiClient.provideSuperheroService()
    //private val superheroService =
    private val superheroApiRemoteDataSource = SuperheroApiRemoteDataSource(superheroApiService)
    private val superheroXmlLocalDataSource = SuperheroXmlLocalDataSource(context)
    private val superheroDataRepository =
        SuperheroDataRepository(superheroXmlLocalDataSource, superheroApiRemoteDataSource) //orden
    private val getSuperheroesUseCase = GetSuperheroesUseCase(superheroDataRepository)
    private val getSuperheroUseCase = GetSuperheroUseCase(superheroDataRepository)

    fun buildViewModel(): SuperheroesViewModel {
        return SuperheroesViewModel(getSuperheroesUseCase)
    }


    fun buildSuperheroDetailViewModel(): SuperheroDetailViewModel{
        return SuperheroDetailViewModel(getSuperheroUseCase)
    }
}