package edu.example.dam2024.features.pokemon.data

import PokemonApiRemoteDataSource
import edu.example.dam2024.features.pokemon.data.local.PokemonXmlLocalDataSource
import edu.example.dam2024.features.pokemon.domain.Pokemon
import edu.example.dam2024.features.pokemon.domain.PokemonRepository

class PokemonDataRepository(
    private val pokemonXmlLocalDataSource: PokemonXmlLocalDataSource,
    private val pokemonApiRemoteDataSource: PokemonApiRemoteDataSource
) : PokemonRepository {

    override suspend fun getPokemons(): List<Pokemon> {
        val pokemonFromLocal = pokemonXmlLocalDataSource.getPokemons()
        if (pokemonFromLocal.isEmpty()) {
            val pokemonFromRemote = pokemonApiRemoteDataSource.getPokemons()
            pokemonXmlLocalDataSource.saveAll(pokemonFromRemote)
            return pokemonFromRemote
        } else {
            return pokemonFromLocal
        }
    }

    override suspend fun getPokemon(id: String): Pokemon? {
        val pokemonFromLocal = pokemonXmlLocalDataSource.findById(id)
        return if (pokemonFromLocal == null) {
            val pokemonFromRemote = pokemonApiRemoteDataSource.getPokemon(id)
            pokemonFromRemote?.let {
                pokemonXmlLocalDataSource.save(it)
            }
            pokemonFromRemote
        } else {
            pokemonFromLocal
        }
    }
}