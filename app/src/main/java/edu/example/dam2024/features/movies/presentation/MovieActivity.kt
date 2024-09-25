package edu.example.dam2024.features.movies.presentation

import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import edu.example.dam2024.R
import edu.example.dam2024.features.movies.domain.models.Movie


class MovieActivity : AppCompatActivity() {

    private val movieFactory = MovieFactory()
    private val viewModel = movieFactory.buildViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)

        // Show all movies in the logcat
        val movies = viewModel.viewCreated()
        Log.d("@dev", movies.toString())

        // Call one movie with clicker in the emulator
        bindData(movies)
        viewModel.getMovie(movies.first().id) //Simular un click sobre un item
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
        findViewById<LinearLayout>(R.id.layout_2).setOnClickListener{
            val movie2: Movie? = viewModel.getMovie(movies[1].id)
            movie2?.let {
                Log.d("@dev", "Película seleccionada: ${it.title}")
            }
        }

        findViewById<TextView>(R.id.movie_id_3).text = movies[2].id
        findViewById<TextView>(R.id.movie_title_3).text = movies[2].title
        findViewById<LinearLayout>(R.id.layout_3).setOnClickListener{
            val movie3: Movie? = viewModel.getMovie(movies[2].id)
            movie3?.let{
                Log.d("@dev", "Película seleccionada: ${it.title}")
            }
        }

        findViewById<TextView>(R.id.movie_id_4).text = movies[3].id
        findViewById<TextView>(R.id.movie_title_4).text = movies[3].title
        findViewById<LinearLayout>(R.id.layout_4).setOnClickListener{
            val movie4:Movie? = viewModel.getMovie(movies[3].id)
            movie4?.let{
                Log.d("@dev", "Película seleccionada: ${it.title}")
            }
        }

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