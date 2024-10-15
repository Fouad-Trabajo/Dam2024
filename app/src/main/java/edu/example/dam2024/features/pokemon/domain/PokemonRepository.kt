package edu.example.dam2024.features.pokemon.domain

interface PokemonRepository {

    suspend fun getPokemon(id: String): Pokemon?
    suspend fun getPokemons(): List<Pokemon>
}