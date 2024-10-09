package edu.example.dam2024.features.movies.presentation

import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
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
        enableEdgeToEdge()
        setContentView(R.layout.activity_movies)

        // Show all movies in the logcat

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
}