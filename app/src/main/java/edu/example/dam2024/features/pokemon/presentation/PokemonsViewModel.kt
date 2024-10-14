package edu.example.dam2024.features.pokemon.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.example.dam2024.app.domain.ErrorApp
import edu.example.dam2024.features.pokemon.domain.GetPokemonsUseCase
import edu.example.dam2024.features.pokemon.domain.Pokemon
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PokemonsViewModel(private val getPokemonsUseCase: GetPokemonsUseCase) : ViewModel() {

    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> = _uiState

    fun viewCreated() {
        _uiState.value = (UiState(isLoading = true))
        viewModelScope.launch(Dispatchers.IO) {
            val pokemon = getPokemonsUseCase.invoke()
            _uiState.postValue(UiState(pokemons = pokemon))
        }
    }

    //Inner Class
    data class UiState(
        val isLoading: Boolean = false,
        val errorApp: ErrorApp? = null,
        val pokemons: List<Pokemon>? = null
    ) //Cada error es una vista distinta (interfaz)

}