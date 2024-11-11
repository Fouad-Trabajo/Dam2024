package edu.example.dam2024.features.movies.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import edu.example.dam2024.app.domain.ErrorApp
import edu.example.dam2024.databinding.FragmentMoviesBinding
import edu.example.dam2024.features.movies.domain.models.Movie
import edu.example.dam2024.features.movies.presentation.adapter.MovieAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MoviesFragment : Fragment() { //No se puede poner fragment sin un activity

    //private lateinit var movieFactory: MovieFactory
    //private lateinit var viewModel: MoviesViewModel

    private val moviesViewModel: MoviesViewModel by viewModel()

    private var _binding: FragmentMoviesBinding? = null
    private val binding get() = _binding!! //!! es mala práctica, se puede utilizar para test

    private val movieAdapter = MovieAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMoviesBinding.inflate(inflater, container, false)
        setupView()
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //movieFactory = MovieFactory(requireContext())
        //viewModel = movieFactory.buildViewModel()


        setupObserver()
        moviesViewModel.viewCreated()
    }


    private fun setupObserver() {
        // Me creo un observador para el ViewModel
        val movieObserver = Observer<MoviesViewModel.UiState> { uiState ->
            uiState.movies?.let {
                bindData(it)
            }
            uiState.errorApp?.let {
                showError(it)
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
        moviesViewModel.uiState.observe(viewLifecycleOwner, movieObserver)
        /** no podemos poner this, porque el fragmento no hereda de ViewLifeCycleOwner,
        MoviesActivity si que hereda de ViewLifeCycleOwner con el AppCompatActivity */
    }

    private fun setupView() {
        binding.apply {
            listMovie.layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.VERTICAL, false
            )

            movieAdapter.setEvent { movieId ->
                navigateToMovieDetail(movieId)
            }
            listMovie.adapter = movieAdapter
        }
    }

    private fun bindData(movies: List<Movie>) {
        movieAdapter.submitList(movies)
    }

    private fun showError(error: ErrorApp) {
        when (error) {
            ErrorApp.InternetErrorApp -> TODO()
            ErrorApp.ServerErrorApp -> TODO()
            ErrorApp.DataErrorApp -> TODO()
            ErrorApp.UnknowErrorApp -> TODO()
        }
    }

    private fun navigateToMovieDetail(movieId: String) {
        findNavController().navigate(
            MoviesFragmentDirections.actionFromMoviesToMoviesDetail(movieId)
        )
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}