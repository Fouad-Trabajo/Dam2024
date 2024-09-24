package edu.example.dam2024.features.movies.data.remote

import edu.example.dam2024.features.movies.domain.models.Movie

/**
 * Naming: Modelo + Tecnología + RemoteDataSource (Fuente de datos local)
 */

class MovieMockRemoteDataSource {

    private val movies = listOf(
        Movie("1", "TeneT", "-"),
        Movie("2", "Seven", "-"),
        Movie("3", "Fight Club", "-"),
        Movie("4", "Pulp Fiction", "-")
        //Movie(title = "title4", poster = "poster4", id = "4")
    )

    fun getMovies(): List<Movie> {
        return movies
        // En Kotlin puedes alterar el orden del constructor

    }

    fun getMovie(id: String): Movie? {
        return movies.firstOrNull { movie -> //renobrar el it por movie
            //it es un objeto Movie del listado
            movie.id == id
        } //También se puede hacer con .find { it.id == id }
    }
}