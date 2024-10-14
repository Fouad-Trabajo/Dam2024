package edu.example.dam2024.features.movies.data.remote

import edu.example.dam2024.features.movies.domain.models.Movie

/**
 * Naming: Modelo + Tecnología + RemoteDataSource (Fuente de datos local)
 */

class MovieMockRemoteDataSource {

    private val movies = listOf(
        Movie("1", "TeneT", "https://image.tmdb.org/t/p/original/aCIFMriQh8rvhxpN1IWGgvH0Tlg.jpg"),
        Movie("2", "Seven", "https://es.web.img3.acsta.net/medias/nmedia/18/69/04/89/19757783.jpg"),
        Movie("3", "Fight Club", "https://image.tmdb.org/t/p/original/pB8BM7pdSp6B6Ih7QZ4DrQ3PmJK.jpg"),
        Movie("4", "Pulp Fiction", "https://image.tmdb.org/t/p/original/pbWgQPC6l9pkpEpi3WNRSfWYNP6.jpg"),
        Movie("5", "It", "https://es.web.img2.acsta.net/r_600_889/newsv7/19/07/18/10/11/4763302.jpg")
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