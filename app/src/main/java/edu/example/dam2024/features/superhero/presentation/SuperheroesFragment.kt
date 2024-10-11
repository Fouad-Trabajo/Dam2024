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
import edu.example.dam2024.databinding.FragmentSuperheroesBinding
import edu.example.dam2024.features.superhero.domain.models.Superhero

class SuperheroesFragment : Fragment() {

    private var _binding: FragmentSuperheroesBinding? = null
    private val binding get() = _binding!!

    private lateinit var superheroFactory: SuperheroFactory
    private lateinit var viewModel: SuperheroesViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSuperheroesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObserver()
        superheroFactory = SuperheroFactory(requireContext())
        viewModel = superheroFactory.buildViewModel()
        viewModel.viewCreated()
    }

    private fun setupObserver() {
        val superheroObserver = Observer<SuperheroesViewModel.UiState> { uiState ->
            uiState.superheroes?.let {
               bindData(it)
            }
            uiState.errorApp?.let {
                //pinto el error
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
        viewModel.uiState.observe(viewLifecycleOwner, superheroObserver)

    }

    private fun bindData(superheroes: List<Superhero>) {
        binding.apply {
            // Bind data for superhero 1
            layoutSuperhero1.setOnClickListener {
                navigateToSuperheroDetail(superheroes[0].id)
            }
            superheroId1.text = superheroes[0].id
            superheroName1.text = superheroes[0].name

            // Bind data for superhero 2
            layoutSuperhero2.setOnClickListener {
                navigateToSuperheroDetail(superheroes[1].id)
            }
            superheroId2.text = superheroes[1].id
            superheroName2.text = superheroes[1].name

            // Bind data for superhero 3
            layoutSuperhero3.setOnClickListener {
                navigateToSuperheroDetail(superheroes[2].id)
            }
            superheroId3.text = superheroes[2].id
            superheroName3.text = superheroes[2].name

            // Bind data for superhero 4
            layoutSuperhero4.setOnClickListener {
                navigateToSuperheroDetail(superheroes[3].id)
            }
            superheroId4.text = superheroes[3].id
            superheroName4.text = superheroes[3].name
        }
    }



    private fun showError(error: ErrorApp) {
        when (error) {
            ErrorApp.DataErrorApp -> TODO()
            ErrorApp.InternetErrorApp -> TODO()
            ErrorApp.ServerErrorApp -> TODO()
        }
    }

    private fun navigateToSuperheroDetail(superheroId: String) {
        //findNavController().navigate(SuperheroFragmentDirections.actionSuperheroFragmentToSuperheroDetailFragment(superheroId))
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}