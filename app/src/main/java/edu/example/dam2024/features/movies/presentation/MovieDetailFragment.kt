package edu.example.dam2024.features.movies.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import edu.example.dam2024.app.domain.ErrorApp
import edu.example.dam2024.app.extensions.loadUrl
import edu.example.dam2024.databinding.FragmentMovieDetailBinding
import edu.example.dam2024.features.movies.domain.models.Movie


class MovieDetailFragment : Fragment() {

    private lateinit var movieFactory: MovieFactory
    private lateinit var viewModel: MovieDetailViewModel

    private var _binding: FragmentMovieDetailBinding? = null
    private val binding get() = _binding!! //!! es mala práctica, se puede utilizar para test

    private val movieArgs: MovieDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        movieArgs.movieId

        movieFactory = MovieFactory(requireContext())
        viewModel = movieFactory.buildMovieDetailViewModel()
        setupObserver()
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
        return movieArgs.movieId
    } //La forma de mandar información entre pantallas es con el intent (Es una clase muy importante)

    /**
     *  Solo se pueden pasar String entre vistas.
     *  No se pueden pasar objetos. (Para eso se debe serializar)
     *  Por eso pasamos el string mínimo para recuperar toda la informaición del objeto (id)
     */


    private fun bindData(movie: Movie) {
        // Asignar el título de la película al TextView
        binding.titleMovie.text = movie.title

        // Cargar la imagen del póster de la película en el ImageView
        binding.posterMovie.loadUrl(movie.poster)
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
            val intent = Intent(context, MovieDetailFragment::class.java)
            intent.putExtra(KEY_MOVIE_ID, movieId)
            return intent
        }
    }
}