package edu.example.dam2024.features.superhero.presentation

import edu.example.dam2024.features.superhero.data.SuperheroDataRepository
import edu.example.dam2024.features.superhero.data.remote.SuperheroMockRemoteDataSource
import edu.example.dam2024.features.superhero.domain.GetSuperheroesUseCase
import edu.example.dam2024.features.superhero.domain.GetSuperheroUseCase
import edu.example.dam2024.features.superhero.domain.models.Superhero

class SuperheroFactory {

    private val superheroMockRemoteDataSource = SuperheroMockRemoteDataSource()
    private val superheroDataRepository = SuperheroDataRepository(superheroMockRemoteDataSource)
    private val getSuperheroesUseCase = GetSuperheroesUseCase(superheroDataRepository)
    private val getSuperheroUseCase = GetSuperheroUseCase(superheroDataRepository)

    fun buildViewModel(): SuperheroViewModel {
        return SuperheroViewModel(getSuperheroUseCase, getSuperheroesUseCase)
    }
}