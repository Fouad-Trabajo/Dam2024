package edu.example.dam2024.features.superhero.data

import edu.example.dam2024.features.superhero.data.local.SuperheroXmlLocalDataSource
import edu.example.dam2024.features.superhero.data.remote.SuperheroApiRemoteDataSource
import edu.example.dam2024.features.superhero.data.remote.SuperheroMockRemoteDataSource
import edu.example.dam2024.features.superhero.domain.SuperheroRepository
import edu.example.dam2024.features.superhero.domain.models.Superhero

class SuperheroDataRepository(
    private val superheroXmlLocalDataSource: SuperheroXmlLocalDataSource,
    private val superheroApiRemoteDataSource: SuperheroApiRemoteDataSource
) : SuperheroRepository {

    override suspend fun getSuperheroes(): List<Superhero> {
        val superheroFromLocal = superheroXmlLocalDataSource.getSuperheroes()
        if (superheroFromLocal.isEmpty()) {
            val superheroesFromRemote = superheroApiRemoteDataSource.getSuperheroes()
            superheroXmlLocalDataSource.saveAll(superheroesFromRemote)
            return superheroesFromRemote
        } else {
            return superheroFromLocal
        }
    }

    override suspend fun getSuperhero(id: String): Superhero? {
        val superheroFromLocal = superheroXmlLocalDataSource.findById(id)
        return if (superheroFromLocal == null || superheroFromLocal.id !=id) {
            val superheroFromRemote = superheroApiRemoteDataSource.getSuperhero(id)
            superheroFromRemote?.let {
                superheroXmlLocalDataSource.save(it)
            }
            superheroFromRemote
        }else{
            superheroFromLocal
        }

    }
}