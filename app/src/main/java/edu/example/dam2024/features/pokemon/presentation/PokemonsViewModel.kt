package edu.example.dam2024.features.pokemon.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.example.dam2024.app.data.api.ApiClient.BASE_URL_POKEMON
import edu.example.dam2024.app.domain.ErrorApp
import edu.example.dam2024.features.pokemon.data.remote.PokemonApiRemoteDataSource
import edu.example.dam2024.features.pokemon.domain.GetPokemonsUseCase
import edu.example.dam2024.features.pokemon.domain.Pokemon
import edu.example.dam2024.features.pokemon.domain.PokemonListResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PokemonsViewModel(
    private val getPokemonsUseCase: GetPokemonsUseCase,
    private val pokemonApiRemoteDataSource: PokemonApiRemoteDataSource
) : ViewModel() {

    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> = _uiState
    private var nextPageUrl: String? = null

    private val _totalPokemons = MutableLiveData<Int>() // LiveData para el total de Pokémon
    val totalPokemons: LiveData<Int> get() = _totalPokemons

    fun viewCreated() {
        loadPokemons(BASE_URL_POKEMON)
        fetchTotalPokemons()
    }

    fun loadMorePokemons() {
        nextPageUrl?.let {
            loadPokemons(it)
        }
    }

    private fun loadPokemons(url: String) {
        _uiState.value = (UiState(isLoading = true))
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val pokemonResponse: List<Pokemon> = getPokemonsUseCase.invoke(url)
                val updatedList: List<Pokemon> =
                    _uiState.value?.pokemons.orEmpty() + pokemonResponse
                _uiState.postValue(UiState(pokemons = updatedList, isLoading = false))
            } catch (e: Exception) {
                _uiState.postValue(UiState(errorApp = ErrorApp.ServerErrorApp))

            }
        }
    }

    // Nueva función para obtener el total de Pokémon
    fun fetchTotalPokemons() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val total = pokemonApiRemoteDataSource.getTotalPokemons()
                    .toInt() // Asegúrate de que el método devuelva el valor correcto
                _totalPokemons.postValue(total) // Actualiza el LiveData con el total de Pokémon
            } catch (e: Exception) {
                _totalPokemons.postValue(0) // O maneja el error según necesites
            }
        }
    }

    //Inner Class
    data class UiState(
        val isLoading: Boolean = false,
        val errorApp: ErrorApp? = null,
        val pokemons: List<Pokemon> = emptyList()
    ) //Cada error es una vista distinta (interfaz)

}