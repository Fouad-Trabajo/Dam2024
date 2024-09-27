package edu.example.dam2024.features.superhero.data

import edu.example.dam2024.features.superhero.data.local.SuperheroXmlLocalDataSource
import edu.example.dam2024.features.superhero.data.remote.SuperheroMockRemoteDataSource
import edu.example.dam2024.features.superhero.domain.SuperheroRepository
import edu.example.dam2024.features.superhero.domain.models.Superhero

class SuperheroDataRepository(
    private val superheroXmlLocalDataSource: SuperheroXmlLocalDataSource,
    private val superheroMockRemoteDataSource: SuperheroMockRemoteDataSource
) :
    SuperheroRepository {
    override fun getSuperheroes(): List<Superhero> {
        return superheroMockRemoteDataSource.getSuperheroes()
    }

    override fun getSuperhero(id: String): Superhero? {
        return superheroMockRemoteDataSource.getSuperhero(id)
    }
}