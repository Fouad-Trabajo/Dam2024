package edu.example.dam2024.features.superhero.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import edu.example.dam2024.R
import edu.example.dam2024.app.domain.ErrorApp
import edu.example.dam2024.app.extensions.loadUrl
import edu.example.dam2024.features.superhero.domain.models.Superhero

class SuperheroDetailActivity : AppCompatActivity() {

    private lateinit var superheroFactory: SuperheroFactory
    private lateinit var viewModel: SuperheroDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.fragment_superhero_detail)

        superheroFactory = SuperheroFactory(this)
        viewModel = superheroFactory.buildSuperheroDetailViewModel()
    }
}