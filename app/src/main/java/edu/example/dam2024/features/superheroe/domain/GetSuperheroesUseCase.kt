package edu.example.dam2024.features.superheroe.domain

class GetSuperheroesUseCase(private val superheroRepository: SuperheroRepository) {

    operator fun invoke(): List<Superhero>{
        return superheroRepository.getSuperheroes()
    }
}