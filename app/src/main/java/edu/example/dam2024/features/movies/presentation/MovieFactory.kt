package edu.example.dam2024.features.movies.presentation

import android.content.Context
import edu.example.dam2024.features.movies.data.MovieDataRepository
import edu.example.dam2024.features.movies.data.local.MovieXmlLocalDataSource
import edu.example.dam2024.features.movies.data.remote.MovieMockRemoteDataSource
import edu.example.dam2024.features.movies.domain.usecases.GetMovieUseCase
import edu.example.dam2024.features.movies.domain.usecases.GetMoviesUseCase

class MovieFactory(private val context: Context) {

    // Esta clase solo tiene una única responsabilidad, que es crear el ViewModel (crear UseCase)

    private val movieMockRemoteDataSource = MovieMockRemoteDataSource()
    private val movieXmlLocalDataSource = MovieXmlLocalDataSource(context)
    private val movieDataRepository =
        MovieDataRepository(movieXmlLocalDataSource, movieMockRemoteDataSource)
    private val getMoviesUseCase = GetMoviesUseCase(movieDataRepository)
    private val getMovieUseCase = GetMovieUseCase(movieDataRepository)

    fun buildViewModel(): MoviesViewModel {
        return MoviesViewModel(getMoviesUseCase)

    }

    fun buildMovieDetailViewModel(): MovieDetailViewModel {
        return MovieDetailViewModel(getMovieUseCase)
    }

}