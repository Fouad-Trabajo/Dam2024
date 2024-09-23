package edu.example.dam2024.features.movies.data.remote

import edu.example.dam2024.features.movies.domain.models.Movie

/**
 * Naming: Modelo + Tecnología + RemoteDataSource (Fuente de datos local)
 */

class MovieMockRemoteDataSource {


    fun getMovies(): List<Movie>{
        return listOf(
            Movie("1", "TeneT", "-"),
            Movie("2", "Seven", "-"),
            Movie("3", "Figth Club", "-"),
            Movie(title = "title4", poster = "poster4", id = "4")
            // En Kotlin puedes alterar el orden del constructor
        )
    }

    fun getMovie(id: String): Movie? {
        return getMovies().find { it.id == id }
    }
}