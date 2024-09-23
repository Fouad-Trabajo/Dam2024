package edu.example.dam2024.features.superhero.domain

import edu.example.dam2024.features.superhero.domain.models.Superhero

interface SuperheroRepository {

    fun getSuperheroes(): List<Superhero>
}