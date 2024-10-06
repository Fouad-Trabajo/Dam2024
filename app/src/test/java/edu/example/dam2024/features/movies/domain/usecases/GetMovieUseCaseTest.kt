package edu.example.dam2024.features.movies.domain.usecases


import edu.example.dam2024.features.movies.domain.models.Movie
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito

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
    fun `cuando introduczo un id valido obtengo el modelo correcto`() {
        //Given: Declaración de variables
        val movieExpected = Movie("1", "Up", "https://n9.cl/1jeti")
        Mockito.`when`(movieRepository.getMovie("1")).thenReturn(null)

        //When
        getMovieUseCase.invoke("1")?.let { movieReceived ->


            //Then
            Assertions.assertEquals(movieReceived.id, "1");
            Assertions.assertEquals(movieReceived.title, "Up");
            Assertions.assertEquals(movieReceived.poster, "https://n9.cl/1jeti");
        }
    }


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
}