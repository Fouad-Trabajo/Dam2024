package edu.example.dam2024.features.movies.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import edu.example.dam2024.R
import edu.example.dam2024.app.domain.ErrorApp
import edu.example.dam2024.app.extensions.loadUrl
import edu.example.dam2024.databinding.FragmentMoviesBinding
import edu.example.dam2024.features.movies.domain.models.Movie


class MovieDetailFragment : Fragment() {

    private lateinit var movieFactory: MovieFactory
    private lateinit var viewModel: MovieDetailViewModel

    private var _binding: FragmentMoviesBinding? = null
    private val binding get() = _binding!! //!! es mala práctica, se puede utilizar para test

    override fun onCreateView(

        infa: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        private var _binding: FragmentMoviesBinding? = null
        private val binding get() = _binding!! //!! es mala práctica, se puede utilizar para test
        _binding = FragmentMoviesBinding.inflate(inflater, container, false)
        _binding?.movieTitle1
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObserver()
        movieFactory = MovieFactory(requireContext())
        viewModel = movieFactory.buildMovieDetailViewModel()
        getMovieId()?.let {
            viewModel.viewCreated(it)
        }
    }

    private fun setupObserver() {
        val movieObserver = Observer<MovieDetailViewModel.UiState> { uiState ->
            uiState.movie?.let {
                bindData(it)
            }

            uiState.errorApp?.let {
                // Pinto el error
            }
            if (uiState.isLoading) {
                //muestro cargando
                Log.d("@dev", "Cargando...")
            } else {
                // oculto cargando
                Log.d("@dev", "Oculto cargando...")
            }
        }
        viewModel.uiState.observe(viewLifecycleOwner, movieObserver)
    }

    private fun getMovieId(): String? {
        return intent.getStringExtra(KEY_MOVIE_ID)
    } //La forma de mandar información entre pantallas es con el intent (Es una clase muy importante)

    /**
     *  Solo se pueden pasar String entre vistas.
     *  No se pueden pasar objetos. (Para eso se debe serializar)
     *  Por eso pasamos el string mínimo para recuperar toda la informaición del objeto (id)
     */


    private fun bindData(movie: Movie) {
        // Texto
        val titleTextView = findViewById<TextView>(R.id.title_movie_1) // Reemplaza con el ID correcto de tu TextView
        titleTextView.text = movie.title

        // Image
        binding.poster.loadUrl(movie.poster)
        val imageView = findViewById<ImageView>(R.id.poster_1)
        imageView.loadUrl(movie.poster)
    }

    private fun showError(error: ErrorApp) {
        when (error) {
            ErrorApp.DataErrorApp -> TODO()
            ErrorApp.InternetErrorApp -> TODO()
            ErrorApp.ServerErrorApp -> TODO()
        }

    }

    // Función estática
    companion object {
        val KEY_MOVIE_ID = "key_movie_id"

        //Al hacerlo de esta forma estamos haciendo el código más limpio y estructurado (OpenToClose)
        fun getIntent(context: Context, movieId: String): Intent {
            val intent = Intent(context, MovieDetailActivity::class.java)
            intent.putExtra(KEY_MOVIE_ID, movieId)
            return intent
        }
    }
}