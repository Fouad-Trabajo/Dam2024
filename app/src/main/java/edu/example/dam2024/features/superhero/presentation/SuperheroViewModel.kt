package edu.example.dam2024.features.superhero.presentation

import androidx.lifecycle.ViewModel
import edu.example.dam2024.features.superhero.domain.GetSuperheroesUseCase
import edu.example.dam2024.features.superhero.domain.models.Superhero
import edu.example.dam2024.features.superhero.domain.GetSuperheroUseCase


class SuperheroViewModel(
    private val getSuperheroUseCase: GetSuperheroUseCase,
    private val getSuperheroesUseCase: GetSuperheroesUseCase
) : ViewModel() {

    fun getSuperheroes(): List<Superhero> {
        return getSuperheroesUseCase.invoke()
    }

    fun getSuperhero(id: String): Superhero? {
        return getSuperheroUseCase.invoke(id)
    }

}