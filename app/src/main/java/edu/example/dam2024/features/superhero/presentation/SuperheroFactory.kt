package edu.example.dam2024.features.superhero.presentation

import edu.example.dam2024.features.superhero.data.SuperheroDataRepository
import edu.example.dam2024.features.superhero.data.remote.SuperheroMockRemoteDataSource
import edu.example.dam2024.features.superhero.domain.GetSuperheroesUseCase
import edu.example.dam2024.features.superheroe.domain.GetSuperheroUseCase

class SuperheroFactory {

    fun buildViewModel(): SuperheroViewModel {
        val superheroRepository = SuperheroDataRepository(SuperheroMockRemoteDataSource())
        return SuperheroViewModel(
            getSuperheroesUseCase = GetSuperheroesUseCase(superheroRepository),
            getSuperheroUseCase = GetSuperheroUseCase(superheroRepository)
        )
    }
}