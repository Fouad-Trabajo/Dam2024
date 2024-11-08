package edu.example.dam2024.features.superhero.domain

import edu.example.dam2024.features.superhero.domain.models.Superhero
import org.koin.core.annotation.Single

@Single
class GetSuperheroesUseCase(private val superheroRepository: SuperheroRepository) {

    suspend operator fun invoke(): Result<List<Superhero>> {
        return superheroRepository.getSuperheroes()
    }

}