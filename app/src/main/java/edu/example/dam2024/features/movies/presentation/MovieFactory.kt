package edu.example.dam2024.features.movies.presentation

import edu.example.dam2024.features.movies.data.MovieDataRepository
import edu.example.dam2024.features.movies.data.remote.MovieMockRemoteDataSource
import edu.example.dam2024.features.movies.domain.usecases.GetMoviesUseCase

class MovieFactory {

    // Esta clase solo tiene una única responsabilidad, que es crear el ViewModel (crer objetos)

    fun buildViewModel(): MovieViewModel {
       return  MovieViewModel(/*new..*/ GetMoviesUseCase(MovieDataRepository(MovieMockRemoteDataSource())))
       }
}