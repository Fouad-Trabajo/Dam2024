package edu.example.dam2024.features.superhero.data

import edu.example.dam2024.features.superhero.data.local.SuperheroXmlLocalDataSource
import edu.example.dam2024.features.superhero.data.remote.SuperheroMockRemoteDataSource
import edu.example.dam2024.features.superhero.domain.SuperheroRepository
import edu.example.dam2024.features.superhero.domain.models.Superhero

class SuperheroDataRepository(
    private val superheroXmlLocalDataSource: SuperheroXmlLocalDataSource,
    private val superheroMockRemoteDataSource: SuperheroMockRemoteDataSource
) : SuperheroRepository {

    override fun getSuperheroes(): List<Superhero> {
        val superheroFromLocal = superheroXmlLocalDataSource.getSuperheroes()
        if (superheroFromLocal.isEmpty()) {
            val superheroesFromRemote = superheroMockRemoteDataSource.getSuperheroes()
            superheroXmlLocalDataSource.saveAll(superheroesFromRemote)
            return superheroesFromRemote
        } else {
            return superheroFromLocal
        }
    }

    override fun getSuperhero(id: String): Superhero? {
        val superheroFromLocal = superheroXmlLocalDataSource.findById(id)
        if (superheroFromLocal == null) {
            superheroMockRemoteDataSource.getSuperhero(id)?.let {
                superheroXmlLocalDataSource.save(it)
                return it
            }
        }
        return superheroFromLocal
    }
}