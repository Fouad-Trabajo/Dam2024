package edu.example.dam2024.features.movies.domain.usecases

import edu.example.dam2024.features.movies.domain.models.Movie
import org.koin.core.annotation.Single

@Single
class GetMovieUseCase(private val movieRepository: MovieRepository) {

    operator fun invoke(id: String): Movie? {
        return movieRepository.getMovie(id)
    }
}