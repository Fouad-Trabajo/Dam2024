package edu.example.dam2024.features.superhero.presentation

import android.content.Context
import edu.example.dam2024.features.superhero.data.SuperheroDataRepository
import edu.example.dam2024.features.superhero.data.local.SuperheroXmlLocalDataSource
import edu.example.dam2024.features.superhero.data.remote.SuperheroMockRemoteDataSource
import edu.example.dam2024.features.superhero.domain.GetSuperheroesUseCase
import edu.example.dam2024.features.superhero.domain.GetSuperheroUseCase

class SuperheroFactory(private val context: Context) {

    //Todas estas dependencias, deben seguir un orden claro

    private val superheroMockRemoteDataSource = SuperheroMockRemoteDataSource()
    private val superheroXmlLocalDataSource = SuperheroXmlLocalDataSource(context)
    private val superheroDataRepository =
        SuperheroDataRepository(superheroXmlLocalDataSource, superheroMockRemoteDataSource) //orden
    private val getSuperheroesUseCase = GetSuperheroesUseCase(superheroDataRepository)
    private val getSuperheroUseCase = GetSuperheroUseCase(superheroDataRepository)

    fun buildViewModel(): SuperheroesViewModel {
        return SuperheroesViewModel(getSuperheroUseCase)
    }
    fun buildDetailViewModel(): SuperheroDetailViewModel{
        return SuperherodetailViewModel(getSuperheroUseCase)
    }
}