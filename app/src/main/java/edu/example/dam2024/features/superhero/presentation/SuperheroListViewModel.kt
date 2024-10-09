package edu.example.dam2024.features.superhero.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.example.dam2024.app.domain.ErrorApp
import edu.example.dam2024.features.superhero.domain.GetSuperheroesUseCase
import edu.example.dam2024.features.superhero.domain.models.Superhero
import kotlinx.coroutines.*

class SuperheroListViewModel(
    private val getSuperheroesUseCase: GetSuperheroesUseCase
) : ViewModel() {


    private val _uiState= MutableLiveData<UiState>()
    val uiState: LiveData<UiState> get() = _uiState


    fun loadSuperheroes(){
        viewModelScope.launch(Dispatchers.IO){
            val superheroes = getSuperheroesUseCase.invoke()
        }
    }

    data class UiState(
        var isLoading: Boolean = false,
        var errorApp: ErrorApp? = null,
        var superheroes: List<Superhero>? = null
    )



}