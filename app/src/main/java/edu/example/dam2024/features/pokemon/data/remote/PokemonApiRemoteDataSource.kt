import edu.example.dam2024.features.pokemon.data.remote.api.PokemonApiClient
import edu.example.dam2024.features.pokemon.domain.Pokemon
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PokemonApiRemoteDataSource {

    private val pokemonApiClient = PokemonApiClient()

    suspend fun getPokemons(limit: Int = 20, offset: Int = 0): List<Pokemon> { // Añadido limit y offset con valores por defecto
        return withContext(Dispatchers.IO) {
            // Llamada a la API para obtener la lista de Pokémon con paginación
            val response = pokemonApiClient.pokemonApiService.getPokemons(limit, offset)
            val pokemonListItems = response.body()?.results ?: emptyList()

            // Convertir cada PokemonListItem en un objeto Pokemon
            pokemonListItems.mapNotNull { pokemonItem ->
                // Extraer el ID del Pokémon desde la URL
                val id = pokemonItem.url.trimEnd('/').split('/').last()

                // Llamar al endpoint para obtener los detalles del Pokémon
                val pokemonResponse = pokemonApiClient.pokemonApiService.getPokemon(id)
                pokemonResponse.body()
            }
        }
    }

    suspend fun getPokemon(id: String): Pokemon? {
        return withContext(Dispatchers.IO) {
            val response = pokemonApiClient.pokemonApiService.getPokemon(id)
            response.body()
        }
    }
}
