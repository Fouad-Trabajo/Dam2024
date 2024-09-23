package edu.example.dam2024.features.superhero.presentation

import androidx.lifecycle.ViewModel
import edu.example.dam2024.features.superhero.domain.GetSuperheroesUseCase
import edu.example.dam2024.features.superhero.domain.models.Superhero

class SuperheroViewModel(private val getSuperheroesUseCase: GetSuperheroesUseCase):ViewModel() {
    fun viewCreated(): List<Superhero> {
        return getSuperheroesUseCase.invoke()
    }
}