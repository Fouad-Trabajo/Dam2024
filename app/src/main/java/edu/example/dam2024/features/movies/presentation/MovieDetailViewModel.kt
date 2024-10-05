package edu.example.dam2024.features.movies.presentation

import androidx.lifecycle.ViewModel
import edu.example.dam2024.features.movies.domain.models.Movie
import edu.example.dam2024.features.movies.domain.usecases.GetMovieUseCase

class MovieDetailViewModel(
    private val getMovieUseCase: GetMovieUseCase
) : ViewModel() {

    fun viewCreated(id: String): Movie? {
        return getMovieUseCase.invoke(id)
    }
}