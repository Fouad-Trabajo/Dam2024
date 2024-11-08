package edu.example.dam2024.features.superhero.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.example.dam2024.app.domain.ErrorApp
import edu.example.dam2024.features.superhero.domain.GetSuperheroesUseCase
import edu.example.dam2024.features.superhero.domain.models.Superhero
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class SuperheroesViewModel(
    private val getSuperheroesUseCase: GetSuperheroesUseCase
) : ViewModel() {

    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> = _uiState

    //LiveData para mostrar el total de superhéroes
    private val _totalSuperheroes = MutableLiveData<Int>()
    val totalSuperheroes: LiveData<Int> get() = _totalSuperheroes

    fun viewCreated() {
        _uiState.value = UiState(isLoading = true)
        viewModelScope.launch(Dispatchers.IO) {
            val superheroes = getSuperheroesUseCase.invoke()
            _uiState.postValue(
                UiState(
                    superheroes = superheroes.getOrNull(),
                    errorApp = superheroes.exceptionOrNull() as ErrorApp
                )
            )
            //_totalSuperheroes.postValue(superheroes.size)
        }
    }

    // Inner class
    data class UiState(
        val isLoading: Boolean = false,
        val errorApp: ErrorApp? = null,
        val superheroes: List<Superhero>? = null
    )
}