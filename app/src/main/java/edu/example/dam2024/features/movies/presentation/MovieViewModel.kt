package edu.example.dam2024.features.movies.presentation

import androidx.lifecycle.ViewModel
import edu.example.dam2024.features.movies.domain.models.Movie
import edu.example.dam2024.features.movies.domain.usecases.GetMovieUseCase
import edu.example.dam2024.features.movies.domain.usecases.GetMoviesUseCase

class MovieViewModel(

    private val getMoviesUseCase: GetMoviesUseCase,
    private val getMovieUseCase: GetMovieUseCase
) : ViewModel() {

    fun viewCreated(): List<Movie> {
        return getMoviesUseCase.invoke()
    }

    fun getMovie(id: String): Movie? {
        return getMovieUseCase.invoke(id)
    }

}