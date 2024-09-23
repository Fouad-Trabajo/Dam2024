package edu.example.dam2024.features.superhero.presentation

import androidx.lifecycle.ViewModel
import edu.example.dam2024.features.superhero.domain.GetSuperheroesUseCase
import edu.example.dam2024.features.superhero.domain.models.Superhero
import edu.example.dam2024.features.superheroe.domain.GetSuperheroUseCase


class SuperheroViewModel(private val getSuperheroUseCase: GetSuperheroUseCase,
    val getSuperheroesUseCase: GetSuperheroesUseCase) : ViewModel() {
        fun viewCreated(): List<Superhero> {
            return getSuperheroesUseCase.invoke()
        }

    fun getSuperhero(id: String): Superhero? {
        return getSuperheroUseCase.invoke(id)
    }

    }