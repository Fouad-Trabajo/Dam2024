package edu.example.dam2024.features.superheroe.domain

import edu.example.dam2024.features.superheroe.domain.models.Superhero

interface SuperheroRepository {

    fun getSuperheroes(): List<Superhero>
}