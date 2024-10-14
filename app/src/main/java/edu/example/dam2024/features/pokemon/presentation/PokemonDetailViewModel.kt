package edu.example.dam2024.features.pokemon.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.example.dam2024.app.domain.ErrorApp
import edu.example.dam2024.features.movies.domain.models.Movie
import edu.example.dam2024.features.movies.presentation.MoviesViewModel
import edu.example.dam2024.features.pokemon.domain.GetPokemonUseCase
import edu.example.dam2024.features.pokemon.domain.Pokemon
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PokemonDetailViewModel(private val getPokemonUseCase: GetPokemonUseCase) : ViewModel() {

    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> = _uiState

    fun viewCreated(id: String) {
        _uiState.value = (UiState(isLoading = true))
        viewModelScope.launch(Dispatchers.IO) {
            val pokemon = getPokemonUseCase.invoke(id)
            _uiState.postValue(UiState(pokemon = pokemon))
        }
    }


    data class UiState(
        val isLoading: Boolean = false,
        val errorApp: ErrorApp? = null,
        val pokemon: Pokemon? = null
    )
}