package edu.example.dam2024.features.superheroe.domain

import edu.example.dam2024.features.superheroe.domain.models.Superhero

class GetSuperheroesUseCase(private val superheroRepository: SuperheroRepository) {

    operator fun invoke(): List<Superhero>{
        return superheroRepository.getSuperheroes()
    }
}