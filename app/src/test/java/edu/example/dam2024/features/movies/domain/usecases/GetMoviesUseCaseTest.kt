package edu.example.dam2024.features.movies.domain.usecases
/*
import edu.example.dam2024.features.movies.domain.models.Movie
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach


/**
 * No estoy utilizando el framework Mockito (aunque tengo descargada la librería)
 * porque he visto un tutorial que lo hace con Mockk, creo que no distan mucho uno del otro
 */
class GetMoviesUseCaseTest {

    @RelaxedMockK
    private lateinit var movieRepository: MovieRepository
    private lateinit var getMoviesUseCase: GetMoviesUseCase

    @BeforeEach
    fun setUp() {
        MockKAnnotations.init(this)
        getMoviesUseCase = GetMoviesUseCase(movieRepository)
    }

    @AfterEach
    fun tearDown() {
    }


    @Test
    fun `cuando el repositorio devuelve una lista vacia`() = runBlocking {
        //Given: Declaración de variables
        val movieRepository = mockk<MovieRepository>()
        coEvery { movieRepository.getMovies() } returns emptyList()
        val getMoviesUseCase = GetMoviesUseCase(movieRepository)

        //When: Acciones a realizar
        val movies: List<Movie> = getMoviesUseCase() //llamar al caso de uso

        //Then: Comprobaciones
        coVerify(exactly = 1) { movieRepository.getMovies() }
        //verifica que se está llamando al repositorio una vez
        assert(movies.isEmpty())
    }

    @Test
    fun `cuando el repositorio devuelve una lista correcta`() = runBlocking {
        //Given: Declaración de variables
        val movieRepository = mockk<MovieRepository>()
        val moviesExpected = listOf(
            Movie("1", "Up", "https://n9.cl/1jeti"),
            Movie("2","It","https://n9.cl/1jeti"))
        coEvery { movieRepository.getMovies() } returns moviesExpected
        val getMoviesUseCase = GetMoviesUseCase(movieRepository)

        //When: Acciones a realizar
        val moviesReceived: List<Movie> = getMoviesUseCase()

        //Then: Comprobaciones
        coVerify(exactly = 1) { movieRepository.getMovies() }
        Assert.assertEquals(moviesReceived, moviesExpected)
    }


}

 */