package edu.example.dam2024.features.movies.domain.usecases

import edu.example.dam2024.features.movies.domain.models.Movie

interface MovieRepository {
    fun getMovies(): List<Movie>
    fun getMovie(): Movie
}