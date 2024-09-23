package edu.example.dam2024.features.superheroe.domain

import edu.example.dam2024.features.superhero.domain.SuperheroRepository
import edu.example.dam2024.features.superhero.domain.models.Superhero

class GetSuperheroUseCase(private val superheroRepository: SuperheroRepository) {

    operator fun invoke(id: String): Superhero? {
        return superheroRepository.getSuperhero(id)
    }
}