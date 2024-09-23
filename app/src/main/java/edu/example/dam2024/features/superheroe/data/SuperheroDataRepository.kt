package edu.example.dam2024.features.superheroe.data

import edu.example.dam2024.features.superheroe.data.remote.SuperheroMockRemoteDataSource
import edu.example.dam2024.features.superheroe.domain.models.Superhero
import edu.example.dam2024.features.superheroe.domain.SuperheroRepository

class SuperheroDataRepository(private val mockRemoteDataSource: SuperheroMockRemoteDataSource) :
    SuperheroRepository {

        override fun getSuperheroes(): List<Superhero>{
            return mockRemoteDataSource.getSuperheroes()
        }
}