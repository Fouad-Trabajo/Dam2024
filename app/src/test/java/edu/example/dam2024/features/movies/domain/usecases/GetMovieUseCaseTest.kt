package edu.example.dam2024.features.movies.domain.usecases

import edu.example.dam2024.features.movies.domain.models.Movie
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach


class GetMovieUseCaseTest {

    @RelaxedMockK
    private lateinit var movieRepository: MovieRepository
    private lateinit var getMovieUseCase: GetMovieUseCase

    @BeforeEach
    fun setUp() {
        MockKAnnotations.init(this)
        getMovieUseCase = GetMovieUseCase(movieRepository)
    }

    @AfterEach
    fun tearDown() {
    }

    @Test
    fun `verficar que se llama al getMovie`() = runBlocking {
        //Given: Declaración de variables
        val movieExpected = Movie("1", "Up", "https://n9.cl/1jeti")
        coEvery { movieRepository.getMovie("1")} returns movieExpected


        //When
        val movieReceived = getMovieUseCase.invoke("1")


        //Then
        coVerify(exactly = 1) {
            movieRepository.getMovie("1")
        }
        assertEquals(movieExpected ,movieReceived)
    }


    @Test
    fun `cuando introduczo un id valido obtengo el modelo correcto`() = runBlocking{
        //Given: Declaración de variables
        val movieExpected = Movie("1", "Up", "https://n9.cl/1jeti")
        coEvery { movieRepository.getMovie("1") } returns movieExpected

        //When
        val movieReceived = getMovieUseCase.invoke("1")

        coVerify(exactly = 1) {
            movieRepository.getMovie("1")
        }
        Assert.assertEquals(movieExpected.id,movieReceived?.id )
        Assert.assertEquals(movieExpected.title, movieReceived?.title)
        Assert.assertEquals(movieExpected.poster, movieReceived?.poster)

    }


/*
    @Test
    fun `cuando introduczo un id invalido`() = runBlocking {
        //Given: Declaración de variables
        val invalidId = "2"
        Mockito.`when`(movieRepository.getMovie("1")).thenReturn(null)

        //When
        val movieReceived: Movie? = getMovieUseCase.invoke(invalidId)

        //Then
        Assertions.assertNull(movieReceived)
    }
 */
}
