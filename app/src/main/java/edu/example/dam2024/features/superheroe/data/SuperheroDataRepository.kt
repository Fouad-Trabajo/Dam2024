package edu.example.dam2024.features.superheroe.data

import edu.example.dam2024.features.superheroe.data.remote.SuperheroMockRemoteDataSource
import edu.example.dam2024.features.superheroe.domain.Superhero
import edu.example.dam2024.features.superheroe.domain.SuperheroRepostiory

class SuperheroDataRepository(private val mockRemoteDataSource: SuperheroMockRemoteDataSource) :
    SuperheroRepostiory {

        override fun getSuperheroes(): List<Superhero>{
            return mockRemoteDataSource.getSuperheroes()
        }
}