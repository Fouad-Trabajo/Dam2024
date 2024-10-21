package edu.example.dam2024.features.superhero.presentation

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import edu.example.dam2024.R

class SuperheroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_superheroes)
        setupView()
    }


    // Navegar entre las diferentes vistas de al aplicación
    private fun setupView() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.superhero_container) as NavHostFragment

        val navController = navHostFragment.navController
        findViewById<BottomNavigationView>(R.id.menu_activity_superhero)
            .setupWithNavController(navController)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.fragment_superheroes || destination.id == R.id.fragment_superhero_2) {
                findViewById<BottomNavigationView>(R.id.menu_activity_superhero)
                    .visibility = View.VISIBLE
            } else {
                findViewById<BottomNavigationView>(R.id.menu_activity_superhero)
                    .visibility = View.GONE
            }
        }
    }
}