package edu.example.dam2024.features.superhero.data.remote

import edu.example.dam2024.features.superhero.domain.models.Superhero

class SuperheroMockRemoteDataSource {

    fun getSuperheroes(): List<Superhero> {
        return listOf(
            Superhero("1", "Batman"),
            Superhero("2", "Superman"),
            Superhero("3", "Spiderman"),
            Superhero("4", "Ironman")
        )
    }
}