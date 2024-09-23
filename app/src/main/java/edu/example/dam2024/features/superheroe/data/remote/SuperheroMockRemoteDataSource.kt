package edu.example.dam2024.features.superheroe.data.remote

import edu.example.dam2024.features.superheroe.domain.Superhero

class SuperheroMockRemoteDataSource {

    fun getSuperheroes(): List<Superhero>{
        return listOf(
            Superhero("1", "batman", "poster1","hola"),
            Superhero("2", "superman", "poster2","jskjfksd"),
            Superhero("3", "spiderman", "poster3","sfjksldjf2")
        )
    }
}