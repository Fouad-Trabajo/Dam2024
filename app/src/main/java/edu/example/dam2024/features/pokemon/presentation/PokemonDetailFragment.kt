package edu.example.dam2024.features.pokemon.presentation

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
import edu.example.dam2024.databinding.FragmentPokemonDetailBinding
import edu.example.dam2024.features.movies.domain.models.Movie
import edu.example.dam2024.features.pokemon.domain.Pokemon

class PokemonDetailFragment: Fragment() {

    private lateinit var pokemonFactory: PokemonFactory
    private lateinit var pokemonsViewModel: PokemonDetailViewModel


    private var _binding: FragmentPokemonDetailBinding? = null
    private val binding get() = _binding!!

    private val pokemonArgs: PokemonDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPokemonDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pokemonFactory = PokemonFactory(requireContext())
        pokemonsViewModel = pokemonFactory.buildPokemonDetailViewModel()
        setupObserver()
        getPokemonId().let{
            pokemonsViewModel.viewCreated(it)
        }
    }

    private fun setupObserver() {
        // Me creo un observador para el ViewModel
        val pokemonObserver = Observer<PokemonDetailViewModel.UiState> { uiState ->
            uiState.pokemon?.let {
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
        pokemonsViewModel.uiState.observe(viewLifecycleOwner, pokemonObserver)

    }

    private fun getPokemonId(): String {
        return pokemonArgs.pokemonId
    }

    private fun bindData(pokemon: Pokemon) {
        // Nombre pokemon
        binding.namePokemon.text = pokemon.name

        val imageUrl ="https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${pokemon.id}.png"
        // Cargar la imagen del pokemon
        binding.imgPokemon.loadUrl(imageUrl)
    }

    private fun showError(error: ErrorApp) {
        when (error) {
            ErrorApp.DataErrorApp -> TODO()
            ErrorApp.InternetErrorApp -> TODO()
            ErrorApp.ServerErrorApp -> TODO()
        }

    }
}