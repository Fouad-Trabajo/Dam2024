package edu.example.dam2024.features.pokemon.data

import edu.example.dam2024.features.pokemon.data.local.PokemonXmlLocalDataSource
import edu.example.dam2024.features.pokemon.data.remote.PokemonMockRemoteDataSource
import edu.example.dam2024.features.pokemon.domain.Pokemon
import edu.example.dam2024.features.pokemon.domain.PokemonRepository

class PokemonDataRepository(
    private val pokemonXmlLocalDataSource: PokemonXmlLocalDataSource,
    private val pokemonMockRemoteDataSource: PokemonMockRemoteDataSource
): PokemonRepository {
    override fun getPokemons(): List<Pokemon>{
        val pokemonFromLocal = pokemonXmlLocalDataSource.getPokemons()
        if (pokemonFromLocal.isEmpty()){
            val pokemonFromRemote = pokemonMockRemoteDataSource.getPokemons()
            pokemonXmlLocalDataSource.saveAll(pokemonFromRemote)
            return pokemonFromRemote
        }else{
            return pokemonFromLocal
        }
    }

    override fun getPokemon(id: String): Pokemon?{
        val pokemonFromLocal = pokemonXmlLocalDataSource.findById(id)
        if(pokemonFromLocal == null){
            pokemonMockRemoteDataSource.getPokemon(id)?.let{
                pokemonXmlLocalDataSource.save(it)
                return it
            }
        }
        return pokemonFromLocal
    }
}