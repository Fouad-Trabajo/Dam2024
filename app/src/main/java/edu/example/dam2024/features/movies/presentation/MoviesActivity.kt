package edu.example.dam2024.features.movies.presentation

import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import edu.example.dam2024.R
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


        // Show all movies in the logcat
        val movies = viewModel.viewCreated()
        // Log.d("@dev", movies.toString())

        // Call one movie with clicker in the emulator
        bindData(movies)
        viewModel.getMovie(movies.first().id) //Simular un click sobre un item

        //Save, get and delete model in movies.xml
        //testXml()

        //Save, get and delete list of movies in movies.xml
        //testListXml()

        testMovie()
    }

    private fun bindData(movies: List<Movie>) {
        findViewById<TextView>(R.id.movie_id_1).text = movies[0].id
        findViewById<TextView>(R.id.movie_title_1).text = movies[0].title
        findViewById<LinearLayout>(R.id.layout_1).setOnClickListener { //Lambdas
            val movie1: Movie? = viewModel.getMovie(movies[0].id)
            movie1?.let {
                Log.d("@dev", "Película seleccionada: ${it.title}")
            } //Esto se va a ir duplicando entonces debo sacarlo fuera
        }

        findViewById<TextView>(R.id.movie_id_2).text = movies[1].id
        findViewById<TextView>(R.id.movie_title_2).text = movies[1].title
        findViewById<LinearLayout>(R.id.layout_2).setOnClickListener {
            val movie2: Movie? = viewModel.getMovie(movies[1].id)
            movie2?.let {
                Log.d("@dev", "Película seleccionada: ${it.title}")
            }
        }

        findViewById<TextView>(R.id.movie_id_3).text = movies[2].id
        findViewById<TextView>(R.id.movie_title_3).text = movies[2].title
        findViewById<LinearLayout>(R.id.layout_3).setOnClickListener {
            val movie3: Movie? = viewModel.getMovie(movies[2].id)
            movie3?.let {
                Log.d("@dev", "Película seleccionada: ${it.title}")
            }
        }

        findViewById<TextView>(R.id.movie_id_4).text = movies[3].id
        findViewById<TextView>(R.id.movie_title_4).text = movies[3].title
        findViewById<LinearLayout>(R.id.layout_4).setOnClickListener {
            val movie4: Movie? = viewModel.getMovie(movies[3].id)
            movie4?.let {
                Log.d("@dev", "Película seleccionada: ${it.title}")
            }
        }

    }


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


    private fun testListXml() {
        val movieXmlLocalDataSource = MovieXmlLocalDataSource(this)
        val movies = viewModel.viewCreated()
        movieXmlLocalDataSource.saveAll(movies) //Save list of movies in movies.xml


        // Get list of movies in movies.xml
        val movieSave = movieXmlLocalDataSource.getMovies()
        Log.d("@dev", movieSave.toString())
    }

    private fun testMovie(){
        val movies = viewModel.viewCreated()
        val movieXmlLocalDataSource = MovieXmlLocalDataSource(this)
    val movie = movieXmlLocalDataSource.findById("1")
        Log.d("@dev", movie.toString())
    }

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