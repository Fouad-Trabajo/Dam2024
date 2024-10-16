package edu.example.dam2024.features.pokemon.domain

import edu.example.dam2024.features.movies.domain.models.Movie

class GetPokemonUseCase(private val pokemonRepository: PokemonRepository) {

    suspend operator fun invoke(id: String): Pokemon? {
        return pokemonRepository.getPokemon(id)
    }
}