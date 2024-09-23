package edu.example.dam2024.features.superheroe.presentation

import edu.example.dam2024.features.superheroe.data.SuperheroDataRepository
import edu.example.dam2024.features.superheroe.data.remote.SuperheroMockRemoteDataSource
import edu.example.dam2024.features.superheroe.domain.GetSuperheroesUseCase

class SuperheroFactory {

    fun buildViewModel(): SuperheroViewModel {
        return SuperheroViewModel(
            GetSuperheroesUseCase(SuperheroDataRepository(SuperheroMockRemoteDataSource())))
    }
}