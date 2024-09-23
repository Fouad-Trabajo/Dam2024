package edu.example.dam2024.features.superhero.data

import edu.example.dam2024.features.superhero.data.remote.SuperheroMockRemoteDataSource
import edu.example.dam2024.features.superhero.domain.models.Superhero
import edu.example.dam2024.features.superhero.domain.SuperheroRepository

class SuperheroDataRepository(private val mockRemoteDataSource: SuperheroMockRemoteDataSource) :
    SuperheroRepository {

        override fun getSuperheroes(): List<Superhero>{
            return mockRemoteDataSource.getSuperheroes()
        }
}