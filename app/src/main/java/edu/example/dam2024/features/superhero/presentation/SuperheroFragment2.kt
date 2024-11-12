package edu.example.dam2024.features.superhero.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import edu.example.dam2024.databinding.Fragment2SuperheroesBinding
import edu.example.dam2024.features.superhero.presentation.adapter.SuperheroAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class SuperheroFragment2: Fragment() {

    //private lateinit var superheroFactory: SuperheroFactory
    //private lateinit var viewModel: SuperheroesViewModel

    private val superheroesViewModel: SuperheroesViewModel by viewModel()

    private var _binding: Fragment2SuperheroesBinding? = null
    private val binding get() = _binding!!

    private val superheroAdapter = SuperheroAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = Fragment2SuperheroesBinding.inflate(inflater, container, false)
        //setupView()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //superheroFactory = SuperheroFactory(requireContext())
        //viewModel = superheroFactory.buildViewModel()
        //setupObserver()
        superheroesViewModel.viewCreated()
    }
}