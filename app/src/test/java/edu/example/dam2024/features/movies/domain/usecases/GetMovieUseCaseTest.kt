package edu.example.dam2024.features.movies.domain.usecases

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class GetMovieUseCaseTest {

    private val getMovieUseCase: GetMovieUseCase
    @Mock
    private val movieRepository: MovieRepository

    @org.junit.jupiter.api.BeforeEach
    fun setUp() {
        getMovieUseCase = GetMovieUseCase(movieRepository)
    }

    @org.junit.jupiter.api.AfterEach
    fun tearDown() {
        getMovieUseCase = null
    }

    public void cuando_el_id_coinicide_devuelve_la_pelicula_correcta(){

    }
}