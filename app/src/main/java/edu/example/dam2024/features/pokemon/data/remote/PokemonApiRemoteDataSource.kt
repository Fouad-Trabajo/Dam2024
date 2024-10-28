package edu.example.dam2024.features.pokemon.data.remote

import edu.example.dam2024.features.pokemon.domain.Pokemon
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PokemonApiRemoteDataSource(private val pokemonApiService: PokemonApiService) {


    suspend fun getPokemons(limit: Int = 1000, offset: Int = 0): List<Pokemon> {
        return withContext(Dispatchers.IO) {
            val response = pokemonApiService.getPokemons(limit, offset)
            val pokemonListItems = response.body()?.results ?: emptyList()

            pokemonListItems.mapNotNull { pokemonItem ->
                val id = pokemonItem.url.trimEnd('/').split('/').last()
                val pokemonResponse = pokemonApiService.getPokemon(id)
                pokemonResponse.body()
            }
        }
    }

    suspend fun getTotalPokemons(): String {
        return withContext(Dispatchers.IO) {
            val response = pokemonApiService.getAllPokemons()
            response.count // Asegúrate de que 'count' sea el campo correcto
        }
    }

    // Implementar este método para que funcione correctamente el getPokemon en el repositorio
    suspend fun getPokemon(id: String): Pokemon? {
        return withContext(Dispatchers.IO) {
            val response = pokemonApiService.getPokemon(id)
            response.body()  // Devuelve el Pokémon obtenido por su ID
        }
    }
}
