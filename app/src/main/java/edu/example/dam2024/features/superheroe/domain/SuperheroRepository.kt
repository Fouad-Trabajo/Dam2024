package edu.example.dam2024.features.superheroe.domain

interface SuperheroRepository {

    fun getSuperheroes(): List<Superhero>
}