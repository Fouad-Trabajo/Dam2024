package edu.example.dam2024.features.pokemon.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.example.dam2024.app.domain.ErrorApp
import edu.example.dam2024.databinding.FragmentPokemonsBinding
import edu.example.dam2024.features.pokemon.domain.Pokemon
import edu.example.dam2024.features.pokemon.presentation.adapter.PokemonAdapter

class PokemonsFragment : Fragment() {

    private lateinit var pokemonFactory: PokemonFactory
    private lateinit var pokemonsViewModel: PokemonsViewModel


    private var _binding: FragmentPokemonsBinding? = null
    private val binding get() = _binding!!

    private val pokemonAdapter = PokemonAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPokemonsBinding.inflate(inflater, container, false)
        setupView()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pokemonFactory = PokemonFactory(requireContext())
        pokemonsViewModel = pokemonFactory.buildViewModel()
        setupObserver()
        pokemonsViewModel.fetchTotalPokemons()
        pokemonsViewModel.viewCreated()
    }

    private fun setupObserver() {
        // Me creo un observador para el ViewModel
        val pokemonObserver = Observer<PokemonsViewModel.UiState> { uiState ->
            uiState.pokemons?.let {
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

        // Observador para el total de Pokémon
        val totalPokemonsObserver = Observer<Int> { total ->
            // Actualiza la interfaz de usuario con el total de Pokémon
            binding.totalPokemons.text = "Total Pokémon: $total" // Asegúrate de tener un TextView en tu layout
        }
        pokemonsViewModel.totalPokemons.observe(viewLifecycleOwner, totalPokemonsObserver)

    }


    private fun setupView() {
        binding.apply {
            listPokemons.layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.VERTICAL, false
            )

            pokemonAdapter.setEvent { pokemonId ->
                navigateToPokemonDetail(pokemonId)
            }
            listPokemons.adapter = pokemonAdapter

            //Agregar un scroll para cargar más pokemon, al llegar al final del página
            listPokemons.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    if (!recyclerView.canScrollVertically(1)) { //si ha llegado al final
                        pokemonsViewModel.loadMorePokemons()
                    }
                }
            })
        }
    }

    private fun bindData(pokemons: List<Pokemon>) {
        pokemonAdapter.addPokemons(pokemons.sortedBy { it.id.toInt() })
    }

    private fun showError(error: ErrorApp) {
        when (error) {
            ErrorApp.InternetErrorApp -> TODO()
            ErrorApp.ServerErrorApp -> TODO()
            ErrorApp.DataErrorApp -> TODO()
            ErrorApp.UnknowErrorApp -> TODO()
        }
    }

    private fun navigateToPokemonDetail(pokemonId: String) {
        findNavController().navigate(
            PokemonsFragmentDirections.actionFromPokemonsToPokemonsDetail(pokemonId)
        )
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}