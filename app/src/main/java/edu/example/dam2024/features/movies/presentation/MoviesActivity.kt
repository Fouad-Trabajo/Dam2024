package edu.example.dam2024.features.movies.presentation

import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import edu.example.dam2024.R
import edu.example.dam2024.app.domain.ErrorApp
import edu.example.dam2024.features.movies.data.local.MovieXmlLocalDataSource
import edu.example.dam2024.features.movies.domain.models.Movie


class MoviesActivity : AppCompatActivity() {

    private lateinit var movieFactory: MovieFactory
    private lateinit var viewModel: MoviesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)

        //Tengo que saber que es esto porque no me estoy enterando mucho jajajaj
        movieFactory = MovieFactory(this)
        viewModel = movieFactory.buildViewModel()

        setupObserver()

        // Show all movies in the logcat
        viewModel.viewCreated()
        // Log.d("@dev", movies.toString())

        // Call one movie with clicker in the emulator
        //bindData(movies)
        //viewModel.getMovie(movies.first().id) //Simular un click sobre un item

        //Save, get and delete model in movies.xml
        //testXml()

        //Save, get and delete list of movies in movies.xml
        //testListXml()

        //testMovie()
    }


    private fun setupObserver() {
        // Me creo un observador para el ViewModel
        val movieObserver = Observer<MoviesViewModel.UiState> { uiState ->
            uiState.movies?.let {
                bindData(it)
            }
            uiState.errorApp?.let {
                // Pinto el error
            }
            if (uiState.isLoading) {
                // muestro cargando...
                Log.d("@dev", "Cargando...")
            } else {
                // oculto cargando...
                Log.d("@dev", "Oculto cargando...")
            }
        }

        //uso la variable movieObserver para observar el ViewModel
        viewModel.uiState.observe(this, movieObserver)
    }

    fun bindData(movies: List<Movie>) {
        findViewById<TextView>(R.id.movie_id_1).text = movies[0].id
        findViewById<TextView>(R.id.movie_title_1).text = movies[0].title
        findViewById<LinearLayout>(R.id.layout_movie_1).setOnClickListener { //Lambdas
            navigateToMovieDetail(movies[0].id)
        }

        findViewById<TextView>(R.id.movie_id_2).text = movies[1].id
        findViewById<TextView>(R.id.movie_title_2).text = movies[1].title
        findViewById<LinearLayout>(R.id.layout_movie_2).setOnClickListener {
            navigateToMovieDetail(movies[1].id)
        }

        findViewById<TextView>(R.id.movie_id_3).text = movies[2].id
        findViewById<TextView>(R.id.movie_title_3).text = movies[2].title
        findViewById<LinearLayout>(R.id.layout_movie_3).setOnClickListener {
            navigateToMovieDetail(movies[2].id)
        }

        findViewById<TextView>(R.id.movie_id_4).text = movies[3].id
        findViewById<TextView>(R.id.movie_title_4).text = movies[3].title
        findViewById<LinearLayout>(R.id.layout_movie_4).setOnClickListener {
            navigateToMovieDetail(movies[3].id)
        }

    }

    private fun showError(error: ErrorApp) {
        when (error) {
            ErrorApp.DataErrorApp -> TODO()
            ErrorApp.InternetErrorApp -> TODO()
            ErrorApp.ServerErrorApp -> TODO()
        }
    }

    private fun navigateToMovieDetail(movieId: String) {
        startActivity(MovieDetailActivity.getIntent(this, movieId))
    }

    /*
        private fun testXml() {
            val movieXmlLocalDataSource = MovieXmlLocalDataSource(this) //Leer abajo
            //Le estoy pasando MovieActivity porque hereda de Context y MovieXmlLocalDataSource hereda de Context
            val movie = viewModel.getMovie("1")
            movie?.let {
                movieXmlLocalDataSource.save(it) //Save movie in movies.xml
            }
            // Get movie from movies.xml
            val movieSave = movieXmlLocalDataSource.getMovie()
            Log.d("@dev", movieSave.toString())

            //Delete movie in movies.xml
            movieXmlLocalDataSource.delete()
        }

        /** Uno de los resultados de aprendizaje de AAD es guardar,
        obtener y borrar datos de un archivo xml. Esto se llama persistencia de datos
         */
    */

    /*
    private fun testListXml() {
        val movieXmlLocalDataSource = MovieXmlLocalDataSource(this)
        val movies = viewModel.viewCreated()
        movieXmlLocalDataSource.saveAll(movies) //Save list of movies in movies.xml


        // Get list of movies in movies.xml
        val movieSave = movieXmlLocalDataSource.getMovies()
        Log.d("@dev", movieSave.toString())
    }

    private fun testMovie() {
        val movies = viewModel.viewCreated()
        val movieXmlLocalDataSource = MovieXmlLocalDataSource(this)
        val movie = movieXmlLocalDataSource.findById("1")
        Log.d("@dev", movie.toString())
    }
*/

    override fun onStart() {
        super.onStart()
        Log.d("@dev", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("@dev", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("@dev", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("@dev", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("@dev", "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("@dev", "onRestart")
    }
}