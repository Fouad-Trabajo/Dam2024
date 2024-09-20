package edu.example.dam2024.features.movies.data

import edu.example.dam2024.features.movies.data.remote.MovieMockRemoteDataSource
import edu.example.dam2024.features.movies.domain.models.Movie
import edu.example.dam2024.features.movies.domain.usecases.MovieRepository

/**
 *  Naming: Modelo + DataRepository
 */

class MovieDataRepository (private val mockRemoteDataSource: MovieMockRemoteDataSource) :
    MovieRepository {
    // Las dependencias de clases en Kotlin las haremos por constructor

    override fun getMovies(): List<Movie>{
        return mockRemoteDataSource.getMovies()
    }
}