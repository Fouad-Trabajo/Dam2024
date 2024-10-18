import edu.example.dam2024.features.pokemon.data.remote.api.PokemonApiService
import edu.example.dam2024.features.pokemon.domain.Pokemon
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PokemonApiRemoteDataSource(private val pokemonApiService: PokemonApiService) {


    suspend fun getPokemons(limit: Int = 20, offset: Int = 0): List<Pokemon> {
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

    // Implementar este método para que funcione correctamente el getPokemon en el repositorio
    suspend fun getPokemon(id: String): Pokemon? {
        return withContext(Dispatchers.IO) {
            val response = pokemonApiService.getPokemon(id)
            response.body()  // Devuelve el Pokémon obtenido por su ID
        }
    }
}
