package edu.example.dam2024.features.superhero.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import edu.example.dam2024.app.domain.ErrorApp
import edu.example.dam2024.app.extensions.loadUrl
import edu.example.dam2024.databinding.FragmentSuperheroDetailBinding
import edu.example.dam2024.features.superhero.domain.models.Superhero
import org.koin.androidx.viewmodel.ext.android.viewModel

class SuperheroDetailFragment : Fragment() {

    //private lateinit var superheroFactory: SuperheroFactory
    //private lateinit var viewModel: SuperheroDetailViewModel

    private val superheroDetailViewModel: SuperheroDetailViewModel by viewModel()

    private var _binding: FragmentSuperheroDetailBinding? = null
    private val binding get() = _binding!!


    private val superheroArgs: SuperheroDetailFragmentArgs by navArgs()
    //Delegación de funciones en otra clase

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSuperheroDetailBinding.inflate(inflater, container, false)
        return binding.root //este punto de ruptura es muy importante para saber si el proyecto llegá hata aquí
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        superheroArgs.superheroId

        binding.toolbar.apply {
            setNavigationOnClickListener {
                findNavController().navigateUp()
            }
        }
        //superheroFactory = SuperheroFactory(requireContext())
        //viewModel = superheroFactory.buildSuperheroDetailViewModel()
        setupObserver()
        getSuperheroId().let {
            superheroDetailViewModel.viewCreated(it)
        }

    }


    private fun setupObserver() {
        val superheroObserver = Observer<SuperheroDetailViewModel.UiState> { uiState ->
            uiState.superhero?.let {
                bindData(it)
            }
            uiState.errorApp?.let {
                // pinto el error
            }
            if (uiState.isLoading) {
                //muestro cargando...
                Log.d("@dev", "Cargando...")
            } else {
                //oculto cargando
                Log.d("@dev", "Oculto cargando...")
            }
        }
        superheroDetailViewModel.uiState.observe(viewLifecycleOwner, superheroObserver)
    }

    private fun bindData(superhero: Superhero) {
        // Texto
        binding.titleSuperhero.text = superhero.name
        // Image
        binding.image1.loadUrl(superhero.urlImage)
    }

    private fun getSuperheroId(): String {
        return superheroArgs.superheroId
    }

    private fun showError(error: ErrorApp) {
        when (error) {
            ErrorApp.InternetErrorApp -> TODO()
            ErrorApp.ServerErrorApp -> TODO()
            ErrorApp.DataErrorApp -> TODO()
            ErrorApp.UnknowErrorApp -> TODO()
        }
    }

    //Función estática que siempre va en la parte de abajo de la clase
    companion object {
        val KEY_SUPERHERO_ID = "key_superhero_id"

        fun getIntent(context: Context, superheroId: String): Intent {
            val intent = Intent(context, SuperheroDetailFragment::class.java)
            intent.putExtra(KEY_SUPERHERO_ID, superheroId)
            return intent
        }
    }
}