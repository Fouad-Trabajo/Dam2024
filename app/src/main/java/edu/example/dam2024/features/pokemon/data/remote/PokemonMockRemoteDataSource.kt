package edu.example.dam2024.features.pokemon.data.remote

import edu.example.dam2024.features.pokemon.domain.Ability
import edu.example.dam2024.features.pokemon.domain.AbilityDetails
import edu.example.dam2024.features.pokemon.domain.Pokemon
import edu.example.dam2024.features.pokemon.domain.Stat
import edu.example.dam2024.features.pokemon.domain.StatDetails
import edu.example.dam2024.features.pokemon.domain.Type
import edu.example.dam2024.features.pokemon.domain.TypeDetails

class PokemonMockRemoteDataSource {

        private val pokemons = listOf(
            Pokemon(
                id = "1",
                name = "Pikachu",
                types = listOf(
                    Type(slot = "1", type = TypeDetails(name = "electric", url = "https://pokeapi.co/api/v2/type/13/"))
                ),
                abilities = listOf(
                    Ability(ability = AbilityDetails(name = "static", url = "https://pokeapi.co/api/v2/ability/9/"), isHidden = "flase", slot = "1"),
                    Ability(ability = AbilityDetails(name = "lightning-rod", url = "https://pokeapi.co/api/v2/ability/31/"), isHidden = "true", slot = "3")
                ),
                stats = listOf(
                    Stat(baseStat = "55", effort = "0", stat = StatDetails(name = "speed", url = "https://pokeapi.co/api/v2/stat/6/")),
                    Stat(baseStat = "40", effort = "0", stat = StatDetails(name = "defense", url = "https://pokeapi.co/api/v2/stat/3/"))
                )
            ),
            Pokemon(
                id = "2",
                name = "Charmander",
                types = listOf(
                    Type(slot = "1", type = TypeDetails(name = "fire", url = "https://pokeapi.co/api/v2/type/10/"))
                ),
                abilities = listOf(
                    Ability(ability = AbilityDetails(name = "blaze", url = "https://pokeapi.co/api/v2/ability/66/"), isHidden = "false", slot = "1"),
                    Ability(ability = AbilityDetails(name = "solar-power", url = "https://pokeapi.co/api/v2/ability/94/"), isHidden = "true", slot = "3")
                ),
                stats = listOf(
                    Stat(baseStat = "65", effort = "1", stat = StatDetails(name = "speed", url = "https://pokeapi.co/api/v2/stat/6/")),
                    Stat(baseStat = "52", effort = "0", stat = StatDetails(name = "attack", url = "https://pokeapi.co/api/v2/stat/2/"))
                )
            )
        )

        fun getPokemons(): List<Pokemon> {
            return pokemons
        }

        fun getPokemon(id: String): Pokemon? {
            return pokemons.firstOrNull { pokemon -> pokemon.id == id }
        }
}