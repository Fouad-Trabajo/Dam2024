package edu.example.dam2024.features.movies.data.remote

import edu.example.dam2024.features.movies.domain.models.Movie
import retrofit2.http.GET

interface MovieService {

    @GET
    fun getMovies(): List<Movie>
}