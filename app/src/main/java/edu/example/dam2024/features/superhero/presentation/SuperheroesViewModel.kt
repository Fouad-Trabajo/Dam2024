package edu.example.dam2024.features.superhero.presentation

import edu.example.dam2024.app.domain.ErrorApp
import edu.example.dam2024.features.superhero.domain.GetSuperheroesUseCase
import edu.example.dam2024.features.superhero.domain.models.Superhero
import kotlinx.coroutines.*
import androidx.lifecycle.*


class SuperheroesViewModel(
    private val getSuperheroesUseCase: GetSuperheroesUseCase
) : ViewModel() {

    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> = _uiState

    fun viewCreated(){
        _uiState.value = (UiState(isLoading = true))
         viewModelScope.launch(Dispatchers.IO){
             val superheroes = getSuperheroesUseCase.invoke()
             _uiState.postValue(UiState(superheroes = superheroes))
         }
    }

    // Inner class
    data class UiState(
        val isLoading: Boolean = false,
        val errorApp: ErrorApp? = null,
        val superheroes: List<Superhero>? = null
    )
}