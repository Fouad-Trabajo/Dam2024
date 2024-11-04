package edu.example.dam2024.features.movies.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.example.dam2024.app.domain.ErrorApp
import edu.example.dam2024.features.movies.domain.models.Movie
import edu.example.dam2024.features.movies.domain.usecases.GetMoviesUseCase
import kotlinx.coroutines.*
import org.koin.android.annotation.KoinViewModel


// El ViewModel sobrevive al ciclo de vida del software
@KoinViewModel
class MoviesViewModel(
    private val getMoviesUseCase: GetMoviesUseCase
) : ViewModel() {

    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> = _uiState

    /**El problema está que utilizando corrutinas, no podemos comunicarnos con el activity,
    por esto utilizamos el partón Observer */

    fun viewCreated() {
        _uiState.value = (UiState(isLoading = true))
        viewModelScope.launch(Dispatchers.IO) { //Esto es para cambiar el thread
            val movies = getMoviesUseCase.invoke() //Las corrutinas no devuelven nada
            // postValues -> origen: Defaul, IO, Main destino: Main
            //delay(5000)
            _uiState.postValue(UiState(movies = movies))

            // value -> origen/destino: Mismo --- Defaul-Defaul Main-Main IO-IO
            //_uiState.value(UiState(movies = movies))
        }
    }


    //Inner Class
    data class UiState( //Esto es para cuando se encuentra un error a la hora de cargar la info
        val isLoading: Boolean = false,
        val errorApp: ErrorApp? = null,
        val movies: List<Movie>? = null
    ) //Cada error es una vista distinta (interfaz)
}