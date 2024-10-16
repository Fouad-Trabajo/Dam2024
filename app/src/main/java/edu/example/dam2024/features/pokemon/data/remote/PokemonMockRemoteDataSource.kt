package edu.example.dam2024.features.pokemon.data.remote

import edu.example.dam2024.features.pokemon.domain.Ability
import edu.example.dam2024.features.pokemon.domain.AbilityDetails
import edu.example.dam2024.features.pokemon.domain.Pokemon
import edu.example.dam2024.features.pokemon.domain.Stat
import edu.example.dam2024.features.pokemon.domain.StatDetails
import edu.example.dam2024.features.pokemon.domain.Type
import edu.example.dam2024.features.pokemon.domain.TypeDetails

class PokemonMockRemoteDataSource {
/*
    private val pokemons = listOf(
        Pokemon(
            id = "1",
            name = "Bulbasaur",
            types = listOf(
                Type(slot = "1", type = TypeDetails(name = "grass", url = "https://pokeapi.co/api/v2/type/12/")),
                Type(slot = "2", type = TypeDetails(name = "poison", url = "https://pokeapi.co/api/v2/type/4/"))
            ),
            abilities = listOf(
                Ability(ability = AbilityDetails(name = "overgrow", url = "https://pokeapi.co/api/v2/ability/65/"), isHidden = "false", slot = "1"),
                Ability(ability = AbilityDetails(name = "chlorophyll", url = "https://pokeapi.co/api/v2/ability/34/"), isHidden = "true", slot = "3")
            ),
            stats = listOf(
                Stat(baseStat = "45", effort = "1", stat = StatDetails(name = "hp", url = "https://pokeapi.co/api/v2/stat/1/")),
                Stat(baseStat = "49", effort = "0", stat = StatDetails(name = "attack", url = "https://pokeapi.co/api/v2/stat/2/"))
            )
        ),
        Pokemon(
            id = "2",
            name = "Ivysaur",
            types = listOf(
                Type(slot = "1", type = TypeDetails(name = "grass", url = "https://pokeapi.co/api/v2/type/12/")),
                Type(slot = "2", type = TypeDetails(name = "poison", url = "https://pokeapi.co/api/v2/type/4/"))
            ),
            abilities = listOf(
                Ability(ability = AbilityDetails(name = "overgrow", url = "https://pokeapi.co/api/v2/ability/65/"), isHidden = "false", slot = "1"),
                Ability(ability = AbilityDetails(name = "chlorophyll", url = "https://pokeapi.co/api/v2/ability/34/"), isHidden = "true", slot = "3")
            ),
            stats = listOf(
                Stat(baseStat = "60", effort = "1", stat = StatDetails(name = "hp", url = "https://pokeapi.co/api/v2/stat/1/")),
                Stat(baseStat = "62", effort = "1", stat = StatDetails(name = "attack", url = "https://pokeapi.co/api/v2/stat/2/"))
            )
        ),
        Pokemon(
            id = "3",
            name = "Venusaur",
            types = listOf(
                Type(slot = "1", type = TypeDetails(name = "grass", url = "https://pokeapi.co/api/v2/type/12/")),
                Type(slot = "2", type = TypeDetails(name = "poison", url = "https://pokeapi.co/api/v2/type/4/"))
            ),
            abilities = listOf(
                Ability(ability = AbilityDetails(name = "overgrow", url = "https://pokeapi.co/api/v2/ability/65/"), isHidden = "false", slot = "1"),
                Ability(ability = AbilityDetails(name = "chlorophyll", url = "https://pokeapi.co/api/v2/ability/34/"), isHidden = "true", slot = "3")
            ),
            stats = listOf(
                Stat(baseStat = "80", effort = "2", stat = StatDetails(name = "hp", url = "https://pokeapi.co/api/v2/stat/1/")),
                Stat(baseStat = "82", effort = "0", stat = StatDetails(name = "attack", url = "https://pokeapi.co/api/v2/stat/2/"))
            )
        ),
        Pokemon(
            id = "4",
            name = "Charmander",
            types = listOf(
                Type(slot = "1", type = TypeDetails(name = "fire", url = "https://pokeapi.co/api/v2/type/10/"))
            ),
            abilities = listOf(
                Ability(ability = AbilityDetails(name = "blaze", url = "https://pokeapi.co/api/v2/ability/66/"), isHidden = "false", slot = "1"),
                Ability(ability = AbilityDetails(name = "solar-power", url = "https://pokeapi.co/api/v2/ability/94/"), isHidden = "true", slot = "3")
            ),
            stats = listOf(
                Stat(baseStat = "39", effort = "0", stat = StatDetails(name = "hp", url = "https://pokeapi.co/api/v2/stat/1/")),
                Stat(baseStat = "52", effort = "0", stat = StatDetails(name = "attack", url = "https://pokeapi.co/api/v2/stat/2/"))
            )
        ),
        Pokemon(
            id = "5",
            name = "Charmeleon",
            types = listOf(
                Type(slot = "1", type = TypeDetails(name = "fire", url = "https://pokeapi.co/api/v2/type/10/"))
            ),
            abilities = listOf(
                Ability(ability = AbilityDetails(name = "blaze", url = "https://pokeapi.co/api/v2/ability/66/"), isHidden = "false", slot = "1"),
                Ability(ability = AbilityDetails(name = "solar-power", url = "https://pokeapi.co/api/v2/ability/94/"), isHidden = "true", slot = "3")
            ),
            stats = listOf(
                Stat(baseStat = "58", effort = "0", stat = StatDetails(name = "hp", url = "https://pokeapi.co/api/v2/stat/1/")),
                Stat(baseStat = "64", effort = "1", stat = StatDetails(name = "attack", url = "https://pokeapi.co/api/v2/stat/2/"))
            )
        ),
        Pokemon(
            id = "6",
            name = "Charizard",
            types = listOf(
                Type(slot = "1", type = TypeDetails(name = "fire", url = "https://pokeapi.co/api/v2/type/10/")),
                Type(slot = "2", type = TypeDetails(name = "flying", url = "https://pokeapi.co/api/v2/type/3/"))
            ),
            abilities = listOf(
                Ability(ability = AbilityDetails(name = "blaze", url = "https://pokeapi.co/api/v2/ability/66/"), isHidden = "false", slot = "1"),
                Ability(ability = AbilityDetails(name = "solar-power", url = "https://pokeapi.co/api/v2/ability/94/"), isHidden = "true", slot = "3")
            ),
            stats = listOf(
                Stat(baseStat = "78", effort = "3", stat = StatDetails(name = "hp", url = "https://pokeapi.co/api/v2/stat/1/")),
                Stat(baseStat = "84", effort = "0", stat = StatDetails(name = "attack", url = "https://pokeapi.co/api/v2/stat/2/"))
            )
        ),
        Pokemon(
            id = "7",
            name = "Squirtle",
            types = listOf(
                Type(slot = "1", type = TypeDetails(name = "water", url = "https://pokeapi.co/api/v2/type/11/"))
            ),
            abilities = listOf(
                Ability(ability = AbilityDetails(name = "torrent", url = "https://pokeapi.co/api/v2/ability/67/"), isHidden = "false", slot = "1"),
                Ability(ability = AbilityDetails(name = "rain-dish", url = "https://pokeapi.co/api/v2/ability/44/"), isHidden = "true", slot = "3")
            ),
            stats = listOf(
                Stat(baseStat = "44", effort = "0", stat = StatDetails(name = "hp", url = "https://pokeapi.co/api/v2/stat/1/")),
                Stat(baseStat = "48", effort = "0", stat = StatDetails(name = "defense", url = "https://pokeapi.co/api/v2/stat/3/"))
            )
        ),
        Pokemon(
            id = "8",
            name = "Wartortle",
            types = listOf(
                Type(slot = "1", type = TypeDetails(name = "water", url = "https://pokeapi.co/api/v2/type/11/"))
            ),
            abilities = listOf(
                Ability(ability = AbilityDetails(name = "torrent", url = "https://pokeapi.co/api/v2/ability/67/"), isHidden = "false", slot = "1"),
                Ability(ability = AbilityDetails(name = "rain-dish", url = "https://pokeapi.co/api/v2/ability/44/"), isHidden = "true", slot = "3")
            ),
            stats = listOf(
                Stat(baseStat = "59", effort = "1", stat = StatDetails(name = "hp", url = "https://pokeapi.co/api/v2/stat/1/")),
                Stat(baseStat = "63", effort = "1", stat = StatDetails(name = "defense", url = "https://pokeapi.co/api/v2/stat/3/"))
            )
        ),
        Pokemon(
            id = "9",
            name = "Blastoise",
            types = listOf(
                Type(slot = "1", type = TypeDetails(name = "water", url = "https://pokeapi.co/api/v2/type/11/"))
            ),
            abilities = listOf(
                Ability(ability = AbilityDetails(name = "torrent", url = "https://pokeapi.co/api/v2/ability/67/"), isHidden = "false", slot = "1"),
                Ability(ability = AbilityDetails(name = "rain-dish", url = "https://pokeapi.co/api/v2/ability/44/"), isHidden = "true", slot = "3")
            ),
            stats = listOf(
                Stat(baseStat = "79", effort = "3", stat = StatDetails(name = "hp", url = "https://pokeapi.co/api/v2/stat/1/")),
                Stat(baseStat = "83", effort = "0", stat = StatDetails(name = "defense", url = "https://pokeapi.co/api/v2/stat/3/"))
            )
        ),
        Pokemon(
            id = "10",
            name = "Caterpie",
            types = listOf(
                Type(slot = "1", type = TypeDetails(name = "bug", url = "https://pokeapi.co/api/v2/type/7/"))
            ),
            abilities = listOf(
                Ability(ability = AbilityDetails(name = "shield-dust", url = "https://pokeapi.co/api/v2/ability/19/"), isHidden = "false", slot = "1"),
                Ability(ability = AbilityDetails(name = "run-away", url = "https://pokeapi.co/api/v2/ability/50/"), isHidden = "true", slot = "3")
            ),
            stats = listOf(
                Stat(baseStat = "45", effort = "1", stat = StatDetails(name = "hp", url = "https://pokeapi.co/api/v2/stat/1/")),
                Stat(baseStat = "30", effort = "0", stat = StatDetails(name = "speed", url = "https://pokeapi.co/api/v2/stat/6/"))
            )
        )
    )


    fun getPokemons(): List<Pokemon> {
            return pokemons
        }

        fun getPokemon(id: String): Pokemon? {
            return pokemons.firstOrNull { pokemon -> pokemon.id == id }
        }

 */
}