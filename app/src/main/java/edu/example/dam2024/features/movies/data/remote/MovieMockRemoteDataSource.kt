package edu.example.dam2024.features.movies.data.remote

import edu.example.dam2024.features.movies.domain.models.Movie

/**
 * Naming: Modelo + Tecnología + RemoteDataSource (Fuente de datos local)
 */

class MovieMockRemoteDataSource {


    fun getMovies(): List<Movie>{
        return listOf(
            Movie("1", "title1", "poster1"),
            Movie("2", "title2", "poster2"),
            Movie("3", "title3", "poster3"),
            Movie(title = "title4", poster = "poster4", id = "4")
            // En Kotlin puedes alterar el orden del constructor
        )
    }
}