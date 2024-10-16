package edu.example.dam2024.features.superhero.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.example.dam2024.app.domain.ErrorApp
import edu.example.dam2024.features.superhero.domain.GetSuperheroUseCase
import edu.example.dam2024.features.superhero.domain.models.Superhero
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SuperheroDetailViewModel(
    private val getSuperheroUseCase: GetSuperheroUseCase
) : ViewModel() {

    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> = _uiState


    fun viewCreated(id: String) {
        _uiState.value = UiState(isLoading = true)
        viewModelScope.launch(Dispatchers.IO) {
            val superhero = getSuperheroUseCase.invoke(id)
            _uiState.postValue(UiState(superhero = superhero))
        }
    }

    data class UiState(
        val isLoading: Boolean = false,
        val errorApp: ErrorApp? = null,
        val superhero: Superhero? = null
    )
}