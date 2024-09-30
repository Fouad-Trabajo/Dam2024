package edu.example.dam2024.features.movies.data

import edu.example.dam2024.features.movies.data.local.MovieXmlLocalDataSource
import edu.example.dam2024.features.movies.data.remote.MovieMockRemoteDataSource
import edu.example.dam2024.features.movies.domain.models.Movie
import edu.example.dam2024.features.movies.domain.usecases.MovieRepository

/**
 *  Naming: Modelo + DataRepository
 */

class MovieDataRepository(
    private val movieXmlLocalDataSource: MovieXmlLocalDataSource,
    private val mockRemoteDataSource: MovieMockRemoteDataSource
) :
    MovieRepository { //Concreción del MovieRepository
    // Las dependencias de clases en Kotlin las haremos por constructor


    // Obtener las películas del local, si no lo encuentro, buscarlo desde el remote y guardar en el local
    override fun getMovies(): List<Movie> {
        val movieFromLocal = movieXmlLocalDataSource.getMovies()
        if (movieFromLocal.isEmpty()) {
            val moviesFromRemote = mockRemoteDataSource.getMovies()
            movieXmlLocalDataSource.saveAll(moviesFromRemote)
            return moviesFromRemote
        } else {
            return movieFromLocal
        }
    }

    override fun getMovie(id: String): Movie? {
        val movieFromLocal = movieXmlLocalDataSource.findById(id)
        if (movieFromLocal == null){
             mockRemoteDataSource.getMovie(id)?.let{
                 movieXmlLocalDataSource.save(it)
                 return it
             }

        }
        return movieFromLocal
    }

    /**
    override fun getMovie(id: String): Movie? {
    getMovies()
    }
    Nunca deberíamos hacer esto
     */

}