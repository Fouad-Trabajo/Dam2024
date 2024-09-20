package edu.example.dam2024.features.movies.presentation

import androidx.lifecycle.ViewModel
import edu.example.dam2024.features.movies.domain.models.Movie
import edu.example.dam2024.features.movies.domain.usecases.GetMoviesUseCase

class MovieViewModel (private val getMoviesUseCase: GetMoviesUseCase): ViewModel() {

    fun viewCreated(): List<Movie>{
        return getMoviesUseCase.invoke()
    }

}