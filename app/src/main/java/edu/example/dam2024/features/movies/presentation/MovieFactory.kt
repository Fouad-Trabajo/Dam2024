package edu.example.dam2024.features.movies.presentation

import edu.example.dam2024.features.movies.data.MovieDataRepository
import edu.example.dam2024.features.movies.data.remote.MovieMockRemoteDataSource
import edu.example.dam2024.features.movies.domain.usecases.GetMovieUseCase
import edu.example.dam2024.features.movies.domain.usecases.GetMoviesUseCase

class MovieFactory {

    // Esta clase solo tiene una única responsabilidad, que es crear el ViewModel (crer UseCase)

    private val movieMockRemoteDataSource = MovieMockRemoteDataSource()
    private val movieDataRepository = MovieDataRepository(movieMockRemoteDataSource)
    private val getMoviesUseCase = GetMoviesUseCase(movieDataRepository)
    private val getMovieUseCase = GetMovieUseCase(movieDataRepository)

    fun buildViewModel(): MovieViewModel {
        return MovieViewModel(getMoviesUseCase, getMovieUseCase)

    }

}