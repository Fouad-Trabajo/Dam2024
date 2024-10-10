package edu.example.dam2024.features.superhero.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import edu.example.dam2024.R
import edu.example.dam2024.app.domain.ErrorApp
import edu.example.dam2024.app.extensions.loadUrl
import edu.example.dam2024.databinding.FragmentSuperheroesBinding
import edu.example.dam2024.features.movies.presentation.MovieFactory
import edu.example.dam2024.features.superhero.domain.models.Superhero

class SuperheroDetailFragment: Fragment() {

    private lateinit var superheroFactory: SuperheroFactory
    private lateinit var viewModel: SuperheroDetailViewModel

    private var _binding: FragmentSuperheroesBinding? = null
    private val binding get() = _binding!!


    private val superheroArgs: SuperheroDetailFragmentArgs by navArgs()
    //Delegación de funciones en otra clase

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSuperheroesBinding.inflate(inflater, container, false)
        return binding.root //este punto de ruptura es muy importante para saber si el proyecto llegá hata aquí
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObserver()
        superheroFactory = SuperheroFactory(requireContext())
        viewModel = superheroFactory.buildSuperheroDetailViewModel()
        getSuperheroId()?.let {
            viewModel.viewCreated(it)
        }

    }


    private fun setupObserver(){
        val superheroObserver = Observer<SuperheroDetailViewModel.UiState>{ uiState ->
            uiState.superhero?.let{
                bindData(it)
            }
            uiState.errorApp?.let{
                // pinto el error
            }
            if (uiState.isLoading){
                //muestro cargando...
                Log.d("@dev", "Cargando...")
            }else{
                //oculto cargando
                Log.d("@dev", "Oculto cargando...")
            }
        }
        viewModel.uiState.observe(viewLifecycleOwner, superheroObserver)
    }

    private fun bindData(superhero: Superhero){
        // Texto
        val nameTextView = binding<TextView>(R.id.title_superhero_1) // Reemplaza con el ID correcto de tu TextView
        nameTextView.text = superhero.name

        // Image
        val imageView = findViewById<ImageView>(R.id.image_1)
        imageView.loadUrl(superhero.image)
    }

    private fun getSuperheroId(): String?{
        return intent.getStringExtra(KEY_SUPERHERO_ID)
    }

    private fun showError(error: ErrorApp){
        when(error){
            ErrorApp.DataErrorApp -> TODO()
            ErrorApp.InternetErrorApp -> TODO()
            ErrorApp.ServerErrorApp -> TODO()
        }
    }

    //Función estática que siempre va en la parte de abajo de la clase
    companion object{
        val KEY_SUPERHERO_ID = "key_superhero_id"

        fun getIntent(context: Context, superheroId: String): Intent {
            val intent = Intent(context, SuperheroDetailFragment::class.java)
            intent.putExtra(KEY_SUPERHERO_ID, superheroId)
            return intent
        }
    }
}