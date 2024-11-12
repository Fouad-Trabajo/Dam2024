package edu.example.dam2024.features.superhero.domain

import edu.example.dam2024.features.superhero.domain.models.Superhero

interface SuperheroRepository {
    suspend fun getSuperheroes(): Result<List<Superhero>>
    suspend fun getSuperhero(id: String): Superhero?
}