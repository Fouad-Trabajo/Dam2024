package edu.example.dam2024.features.movies.domain.usecases

import edu.example.dam2024.features.movies.domain.models.Movie

class GetMovieUseCase(private val movieRepository: MovieRepository) {

    fun invoke(): Movie {
        return movieRepository.getMovie()
    }
}