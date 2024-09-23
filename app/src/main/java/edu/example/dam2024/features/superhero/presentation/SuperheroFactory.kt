package edu.example.dam2024.features.superhero.presentation

import edu.example.dam2024.features.superhero.data.SuperheroDataRepository
import edu.example.dam2024.features.superhero.data.remote.SuperheroMockRemoteDataSource
import edu.example.dam2024.features.superhero.domain.GetSuperheroesUseCase

class SuperheroFactory {

    fun buildViewModel(): SuperheroViewModel {
        return SuperheroViewModel(
            GetSuperheroesUseCase(SuperheroDataRepository(SuperheroMockRemoteDataSource())))
    }
}