package edu.example.dam2024.features.superheroe.data.remote

import edu.example.dam2024.features.superheroe.domain.Superhero

class SuperheroMockRemoteDataSource {

    fun getSuperheroes(): List<Superhero>{
        return listOf(
            Superhero("1", "title1", "poster1","hola"),
            Superhero("2", "title2", "poster2","jskjfksd"),
            Superhero("3", "title3", "poster3","sfjksldjf2")
        )
    }
}