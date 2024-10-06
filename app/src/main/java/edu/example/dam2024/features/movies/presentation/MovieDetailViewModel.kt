package edu.example.dam2024.features.movies.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.example.dam2024.app.domain.ErrorApp
import edu.example.dam2024.features.movies.domain.models.Movie
import edu.example.dam2024.features.movies.domain.usecases.GetMovieUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieDetailViewModel(
    private val getMovieUseCase: GetMovieUseCase
) : ViewModel() {

    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> = _uiState

    fun viewCreated(id: String) {
        _uiState.value = (UiState(isLoading = true))
        viewModelScope.launch(Dispatchers.IO) {
            val movie = getMovieUseCase.invoke(id)
            _uiState.postValue(UiState(movie = movie))
        }
    }


    data class UiState(
        val isLoading: Boolean = false,
        val errorApp: ErrorApp? = null,
        val movie: Movie? = null
    )

}