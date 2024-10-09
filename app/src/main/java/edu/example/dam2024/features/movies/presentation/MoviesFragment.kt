package edu.example.dam2024.features.movies.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import edu.example.dam2024.R
import edu.example.dam2024.app.domain.ErrorApp
import edu.example.dam2024.databinding.FragmentMoviesBinding
import edu.example.dam2024.features.movies.domain.models.Movie

class MoviesFragment : Fragment() { //No se puede poner fragment sin un activity

    private lateinit var movieFactory: MovieFactory
    private lateinit var viewModel: MoviesViewModel

    private var _binding: FragmentMoviesBinding? = null
    private val binding get() = _binding!! //!! es mala práctica, se puede utilizar para test


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMoviesBinding.inflate(inflater, container, false)
        _binding?.movieTitle1
        return binding.root
    }

    // Para
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObserver()
        movieFactory = MovieFactory(requireContext())
        viewModel = movieFactory.buildViewModel()
        viewModel.viewCreated()
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
        viewModel.uiState.observe(viewLifecycleOwner, movieObserver)
        /** no podemos poner this, porque el fragmento no hereda de ViewLifeCycleOwner,
        MoviesActivity si que hereda de ViewLifeCycleOwner con el AppCompatActivity */
    }


    private fun bindData(movies: List<Movie>) {
        binding.movieId1.text = movies[0].id
        binding.movieTitle1.text = movies[0].title
        binding.layoutMovie1.setOnClickListener { //Lambdas
            findNavController().navigate()
        }

        binding.movieId2.text = movies[1].id
        binding.movieTitle2.text = movies[1].title
        binding.layoutMovie2.setOnClickListener {
            navigateToMovieDetail(movies[1].id)
        }

        binding.movieId3.text = movies[2].id
        binding.movieTitle3.text = movies[2].title
        binding.layoutMovie3.setOnClickListener {
            navigateToMovieDetail(movies[2].id)
        }

        binding.movieId4.text = movies[3].id
        binding.movieTitle4.text = movies[3].title
        binding.layoutMovie4.setOnClickListener {
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
        startActivity(MovieDetailActivity.getIntent(requireContext(), movieId))
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}