package edu.example.dam2024.features.superhero.presentation

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import edu.example.dam2024.R
import edu.example.dam2024.databinding.ActivitySuperheroesBinding

class SuperheroActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySuperheroesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuperheroesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupView()
    }


    // Navegar entre las diferentes vistas de la aplicación
    private fun setupView() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.superhero_container) as NavHostFragment

        val navController = navHostFragment.navController
        binding.menuActivitySuperhero.setupWithNavController(navController)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.fragment_superheroes || destination.id == R.id.fragment_superhero_2) {
                binding.menuActivitySuperhero.visibility = View.VISIBLE
            } else {
                binding.menuActivitySuperhero.visibility = View.GONE
            }
        }
    }
}