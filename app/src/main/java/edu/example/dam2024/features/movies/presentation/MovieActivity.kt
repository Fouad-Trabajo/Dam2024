package edu.example.dam2024.features.movies.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import edu.example.dam2024.R


class MainActivity : AppCompatActivity() {

    private val movieViewModel: MovieFactory = MovieFactory()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewModel = movieViewModel.buildViewModel()
        viewModel.viewCreated()
        val movies = viewModel.viewCreated()
        Log.d("@dev", movies.toString())
        // Obtener una película específica por ID
        val movieId = "1" // El ID de la película que quieres obtener
        val movie = viewModel.getMovie(movieId)
        movie?.let {
            Log.d("@dev", it.toString())
        }


    }


    override fun onStart() {
        super.onStart()
        Log.d("@de", "onStart")
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