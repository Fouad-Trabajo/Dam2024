package edu.example.dam2024.features.superhero.presentation

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
import edu.example.dam2024.databinding.FragmentSuperheroesBinding
import edu.example.dam2024.features.superhero.domain.models.Superhero
import edu.example.dam2024.features.superhero.presentation.adapter.SuperheroAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class SuperheroesFragment : Fragment() {

    private lateinit var superheroFactory: SuperheroFactory
    private lateinit var superheroesViewModel: SuperheroesViewModel

    //private val superheroesViewModel: SuperheroesViewModel by viewModel()

    private var _binding: FragmentSuperheroesBinding? = null
    private val binding get() = _binding!!

    private val superheroAdapter = SuperheroAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSuperheroesBinding.inflate(inflater, container, false)
        setupView()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        superheroFactory = SuperheroFactory(requireContext())
        superheroesViewModel = superheroFactory.buildViewModel()
        setupObserver()
        superheroesViewModel.viewCreated()
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
        superheroesViewModel.uiState.observe(viewLifecycleOwner, superheroObserver)

        
        val totalSuperheroesObserver = Observer<Int> { total ->
            // Actualiza la interfaz de usuario con el total de superhéroes
            binding.totalSuperheroes.text = "Total Superhéroes: $total"
        }
        superheroesViewModel.totalSuperheroes.observe(viewLifecycleOwner, totalSuperheroesObserver)
    }

    private fun setupView() {
        binding.apply{
            listSuperhero.layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.VERTICAL, false
            )
            superheroAdapter.setEvent { superheroId ->
                navigateToSuperheroDetail(superheroId)
            }
            listSuperhero.adapter = superheroAdapter
        }
    }

    private fun bindData(superheroes: List<Superhero>) {
        superheroAdapter.submitList(superheroes.sortedBy { it.id.toInt() })
    }



    private fun showError(error: ErrorApp) {
        when (error) {
            ErrorApp.DataErrorApp -> TODO()
            ErrorApp.InternetErrorApp -> TODO()
            ErrorApp.ServerErrorApp -> TODO()
        }
    }

    private fun navigateToSuperheroDetail(superheroId: String) {
        findNavController().navigate(SuperheroesFragmentDirections.
        actionFromSuperheroToSuperheroDetail(superheroId))
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}