package edu.example.dam2024.features.superhero.data

import edu.example.dam2024.features.superhero.data.local.SuperheroXmlLocalDataSource
import edu.example.dam2024.features.superhero.data.remote.SuperheroApiRemoteDataSource
import edu.example.dam2024.features.superhero.domain.SuperheroRepository
import edu.example.dam2024.features.superhero.domain.models.Superhero
import org.koin.core.annotation.Single

@Single
class SuperheroDataRepository(
    private val superheroXmlLocalDataSource: SuperheroXmlLocalDataSource,
    private val superheroApiRemoteDataSource: SuperheroApiRemoteDataSource
) : SuperheroRepository {

    override suspend fun getSuperheroesAnterior(): List<Superhero> {
        val superheroFromLocal = superheroXmlLocalDataSource.getSuperheroes()
        if (superheroFromLocal.isEmpty()) {
            val superheroesFromRemote = superheroApiRemoteDataSource.getSuperheroes()
            superheroXmlLocalDataSource.saveAll(superheroesFromRemote)
            return superheroesFromRemote
        } else {
            return superheroFromLocal
        }
    }

    /**
     * ```
    override suspend fun getSuperheroes(): List<Superhero> {
    // Intenta obtener datos desde el almacenamiento local
    val superheroesFromLocal = superheroXmlLocalDataSource.getSuperheroes()

    // Si no hay datos locales, intenta obtenerlos de la API
    return if (superheroesFromLocal.isEmpty()) {
    when (val result = superheroApiRemoteDataSource.getSuperheroes()) {
    is Result.Success -> {
    val superheroes = result.getOrNull() ?: emptyList()
    superheroXmlLocalDataSource.saveAll(superheroes)
    superheroes
    }
    is Result.Failure -> {
    // Maneja el error devolviendo una lista vacía o lanzando una excepción si prefieres
    emptyList()
    }
    }
    } else {
    // Devuelve los datos locales si están disponibles
    superheroesFromLocal
        }
    }
    ```
     */


    override suspend fun getSuperhero(id: String): Superhero? {
        val superheroFromLocal = superheroXmlLocalDataSource.findById(id)
        return if (superheroFromLocal == null) {
            val superheroFromRemote = superheroApiRemoteDataSource.getSuperhero(id)
            superheroFromRemote?.let {
                superheroXmlLocalDataSource.save(it)
            }
            superheroFromRemote
        } else {
            superheroFromLocal
        }

    }
}