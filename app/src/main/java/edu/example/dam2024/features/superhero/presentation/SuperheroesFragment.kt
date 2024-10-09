package edu.example.dam2024.features.superhero.presentation

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
import edu.example.dam2024.app.domain.ErrorApp
import edu.example.dam2024.databinding.FragmentSuperheroesBinding
import edu.example.dam2024.features.superhero.domain.models.Superhero

class SuperheroesFragment : Fragment() {

    private lateinit var superheroFactory: SuperheroFactory
    private lateinit var viewModel: SuperheroesViewModel

    private var _binding: FragmentSuperheroesBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSuperheroesBinding.inflate(inflater, container, false)
        _binding?.superheroName1
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObserver()
        superheroFactory = SuperheroFactory(requireContext())
        viewModel = superheroFactory.buildViewModel()
        viewModel.viewCreated()
    }

    fun setupObserver() {
        val superheroObserver = Observer<SuperheroesViewModel.UiState> { uiState ->
            uiState.superheroes?.let {
                bindData(it)
            }
            uiState.errorApp?.let {
                //pinto el error
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
        for (i in superheroes.indices) {
            val superhero = superheroes[i]
            val layoutId = resources.getIdentifier("layout_${i + 1}", "id", packageName)
            val idTextViewId = resources.getIdentifier("superhero_id_${i + 1}", "id", packageName)
            val nameTextViewId =
                resources.getIdentifier("superhero_name_${i + 1}", "id", packageName)

            findViewById<TextView>(idTextViewId).text = superhero.id
            findViewById<TextView>(nameTextViewId).text = superhero.name
            findViewById<LinearLayout>(layoutId).setOnClickListener {
                findNavController().navigate()
            }
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
        startActivity(SuperheroDetailActivity.getIntent(requireContext(), superheroId))
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}