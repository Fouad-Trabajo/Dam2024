package edu.example.dam2024.features.pokemon.domain

class GetPokemonsUseCase(private val pokemonRepository: PokemonRepository) {

    suspend operator fun invoke(url: String): List<Pokemon> {
        return pokemonRepository.getPokemons(url)
    }
}