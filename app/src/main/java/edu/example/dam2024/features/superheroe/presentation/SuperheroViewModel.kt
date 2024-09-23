package edu.example.dam2024.features.superheroe.presentation

import androidx.lifecycle.ViewModel
import edu.example.dam2024.features.movies.domain.models.Movie
import edu.example.dam2024.features.superheroe.domain.GetSuperheroesUseCase
import edu.example.dam2024.features.superheroe.domain.Superhero

class SuperheroViewModel(private val getSuperheroesUseCase: GetSuperheroesUseCase):ViewModel() {
    fun viewCreated(): List<Superhero> {
        return getSuperheroesUseCase.invoke()
    }
}