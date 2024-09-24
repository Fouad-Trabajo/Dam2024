package edu.example.dam2024.features.superhero.data.remote

import edu.example.dam2024.features.superhero.domain.models.Superhero

class SuperheroMockRemoteDataSource {

    private val superheroes = listOf(
        Superhero("1", "Batman"),
        Superhero("2", "Superman"),
        Superhero("3", "Spider man"),
        Superhero("4", "Ironman")
    )

    fun getSuperheroes(): List<Superhero> {
        return superheroes
    }

    fun getSuperhero(id: String): Superhero? {
        return getSuperheroes().find { it.id == id }
    }

}