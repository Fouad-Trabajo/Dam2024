package edu.example.dam2024.features.movies.domain.usecases

import edu.example.dam2024.features.movies.domain.models.Movie

/**
 * Naming: Verbo(Acción) + Modelo + UseCase
 */

class GetMoviesUseCase(private val movieRepository: MovieRepository) {

    operator fun invoke(): List<Movie> {  //Invoke the use case
        return movieRepository.getMovies()
    }
}