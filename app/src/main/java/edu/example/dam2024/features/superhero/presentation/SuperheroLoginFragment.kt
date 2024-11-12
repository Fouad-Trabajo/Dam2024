package edu.example.dam2024.features.superhero.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import edu.example.dam2024.app.domain.ErrorApp
import edu.example.dam2024.databinding.FragmentLoginSuperheroBinding
import edu.example.dam2024.features.superhero.domain.models.Superhero
import edu.example.dam2024.features.superhero.presentation.adapter.SuperheroAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class SuperheroLoginFragment : Fragment() {

    //private lateinit var superheroFactory: SuperheroFactory
    //private lateinit var viewModel: SuperheroesViewModel

    private val superheroLoginViewModel: SuperheroesViewModel by viewModel()

    private var _binding: FragmentLoginSuperheroBinding? = null
    private val binding get() = _binding!!

    private val superheroAdapter = SuperheroAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginSuperheroBinding.inflate(inflater, container, false)
        setupView()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //superheroFactory = SuperheroFactory(requireContext())
        //viewModel = superheroFactory.buildViewModel()
        setupObserver()
        superheroLoginViewModel.viewCreated()
    }

    private fun setupObserver() {
        val superheroObserver = Observer<SuperheroesViewModel.UiState> { uiState ->
            uiState.superheroes?.let {
               bindData(it)
            }
            uiState.errorApp?.let {
                //pinto el error
                showError(it)
            } ?: run { //es como un else
                // ocultar el error
            }
            if (uiState.isLoading) {
                //muestro el cargando...
                Log.d("@dev", "Cargando...")
            } else {
                //oculto el cargando
                Log.d("@dev", "Oculto cargando...")
            }
        }
        //uso la variable superheroObserver para "observar" el ViewModel
        superheroLoginViewModel.uiState.observe(viewLifecycleOwner, superheroObserver)

    }

    private fun setupView() {
        binding.apply{
            button.setOnClickListener {
               navigateToSuperheroDetail()
            }
        }
    }

    private fun bindData(superheroes: List<Superhero>) {
        superheroAdapter.submitList(superheroes)
    }



    private fun showError(error: ErrorApp) {
        when (error) {
            ErrorApp.InternetErrorApp -> TODO()
            ErrorApp.ServerErrorApp -> TODO()
            ErrorApp.DataErrorApp -> TODO()
            ErrorApp.UnknowErrorApp -> TODO()
        }
    }

    private fun navigateToSuperheroDetail() {
        findNavController().navigate(SuperheroLoginFragmentDirections.
        actionFromLoginToListSueperhero())
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}