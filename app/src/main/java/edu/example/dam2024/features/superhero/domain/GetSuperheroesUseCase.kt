package edu.example.dam2024.features.superhero.domain

import edu.example.dam2024.features.superhero.domain.models.Superhero

class GetSuperheroesUseCase(private val superheroRepository: SuperheroRepository) {

    fun invoke(): List<Superhero> {
        return superheroRepository.getSuperheroes()
    }

}