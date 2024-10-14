package edu.example.dam2024.features.pokemon.domain

data class Pokemon(
    val id: String,
    val name: String,
    val types: List<Type>,
    val abilities: List<Ability>,
    val stats: List<Stat>
)

data class Type(
    val slot: String, // posición del tipo
    val type: TypeDetails
)

data class TypeDetails(
    val name: String,
    val url: String
)

data class Ability(
    val ability: AbilityDetails,
    val isHidden: String, // indica si la habilidad está oculta
    val slot: String // posición de la habilidad
)

data class AbilityDetails(
    val name: String,
    val url: String
)

data class Stat(
    val baseStat: String, // valor base de la estadística
    val effort: String, // puntos de esfuerzo ganados al derrotar al Pokémon
    val stat: StatDetails
)

data class StatDetails(
    val name: String,
    val url: String
)

data class PokemonListResponse(
    val count: String, // número total de Pokémon
    val next: String?, // URL para la siguiente página de resultados
    val previous: String?, // URL para la página anterior
    val results: List<PokemonListItem>
)

data class PokemonListItem(
    val name: String,
    val url: String
)
