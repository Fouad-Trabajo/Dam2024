package edu.example.dam2024.features.pokemon.domain

interface PokemonRepository {

    fun getPokemon(id: String): Pokemon?
    fun getPokemons(): List<Pokemon>
}