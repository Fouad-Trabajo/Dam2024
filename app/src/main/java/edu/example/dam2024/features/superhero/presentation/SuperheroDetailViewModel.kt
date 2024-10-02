package edu.example.dam2024.features.superhero.presentation

import androidx.lifecycle.ViewModel
import edu.example.dam2024.features.superhero.domain.GetSuperheroUseCase
import edu.example.dam2024.features.superhero.domain.models.Superhero

class SuperheroDetailViewModel(private val getSuperheroUseCase: GetSuperheroUseCase) : ViewModel() {


    fun viewCreated(id: String): Superhero?{
        return getSuperheroUseCase.invoke(id)
    }


}