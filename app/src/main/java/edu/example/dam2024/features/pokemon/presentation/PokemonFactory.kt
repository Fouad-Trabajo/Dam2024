package edu.example.dam2024.features.pokemon.presentation

import edu.example.dam2024.features.pokemon.data.remote.PokemonApiRemoteDataSource
import android.content.Context
import edu.example.dam2024.app.data.api.ApiClient
import edu.example.dam2024.features.pokemon.data.PokemonDataRepository
import edu.example.dam2024.features.pokemon.data.local.PokemonXmlLocalDataSource
import edu.example.dam2024.features.pokemon.domain.GetPokemonUseCase
import edu.example.dam2024.features.pokemon.domain.GetPokemonsUseCase

class PokemonFactory(private val context: Context) {

    private val pokemonApiService = ApiClient.providePokemonService()
    private val pokemonApiRemoteDataSource = PokemonApiRemoteDataSource(pokemonApiService)
    private val pokemonXmlLocalDataSource = PokemonXmlLocalDataSource(context)
    private val pokemonDataRepository =
        PokemonDataRepository(pokemonXmlLocalDataSource, pokemonApiRemoteDataSource)
    private val getPokemonsUseCase = GetPokemonsUseCase(pokemonDataRepository)
    private val getPokemonUseCase = GetPokemonUseCase(pokemonDataRepository)


    fun buildViewModel(): PokemonsViewModel {
        return PokemonsViewModel(getPokemonsUseCase,pokemonApiRemoteDataSource)
    }

    fun buildPokemonDetailViewModel(): PokemonDetailViewModel {
        return PokemonDetailViewModel(getPokemonUseCase)
    }
}