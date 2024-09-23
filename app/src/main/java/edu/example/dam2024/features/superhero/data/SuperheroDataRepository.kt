package edu.example.dam2024.features.superhero.data

import edu.example.dam2024.features.superhero.data.remote.SuperheroMockRemoteDataSource
import edu.example.dam2024.features.superhero.domain.SuperheroRepository
import edu.example.dam2024.features.superhero.domain.models.Superhero

class SuperheroDataRepository(private val mockRemoteDataSource: SuperheroMockRemoteDataSource):
SuperheroRepository{
    override fun getSuperheroes(): List<Superhero> {
        return mockRemoteDataSource.getSuperheroes()
    }

    override fun getSuperhero(id: String): Superhero? {
        return mockRemoteDataSource.getSuperhero(id)
    }
}