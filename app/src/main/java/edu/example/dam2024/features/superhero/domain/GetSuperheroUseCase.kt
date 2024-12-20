package edu.example.dam2024.features.superhero.domain

import edu.example.dam2024.features.superhero.domain.models.Superhero
import org.koin.core.annotation.Single

@Single
class GetSuperheroUseCase(private val superheroRepository: SuperheroRepository) {

    suspend operator fun invoke(id: String): Superhero? {
        return superheroRepository.getSuperhero(id)
    }
}