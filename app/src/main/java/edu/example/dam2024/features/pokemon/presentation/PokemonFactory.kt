package edu.example.dam2024.features.pokemon.presentation

import android.content.Context
import edu.example.dam2024.features.pokemon.data.PokemonDataRepository
import edu.example.dam2024.features.pokemon.data.local.PokemonXmlLocalDataSource
import edu.example.dam2024.features.pokemon.data.remote.PokemonMockRemoteDataSource
import edu.example.dam2024.features.pokemon.domain.GetPokemonUseCase
import edu.example.dam2024.features.pokemon.domain.GetPokemonsUseCase

class PokemonFactory(private val context: Context) {

    private val pokemonMockRemoteDataSource = PokemonMockRemoteDataSource()
    private val pokemonXmlLocalDataSource = PokemonXmlLocalDataSource(context)
    private val pokemonDataRepository =
        PokemonDataRepository(pokemonXmlLocalDataSource, pokemonMockRemoteDataSource)
    private val getPokemonsUseCase = GetPokemonsUseCase(pokemonDataRepository)
    private val getPokemonUseCase = GetPokemonUseCase(pokemonDataRepository)


    fun buildViewModel(): PokemonsViewModel {
        return PokemonsViewModel(getPokemonsUseCase)
    }

    fun buildPokemonDetailViewModel(): PokemonDetailViewModel {
        return PokemonDetailViewModel(getPokemonUseCase)
    }
}