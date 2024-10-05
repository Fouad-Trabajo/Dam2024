package edu.example.dam2024.features.superhero.data.remote

import edu.example.dam2024.features.superhero.domain.models.Superhero

class SuperheroMockRemoteDataSource {

    private val superheroes = listOf(
        Superhero("1", "A-Bomb",
            "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/lg/1-a-bomb.jpg"),
        Superhero("2", "Abe Sapien",
            "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/sm/2-abe-sapien.jpg"),
        Superhero("3", "Abin Sur",
            "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/sm/3-abin-sur.jpg"),
        Superhero("4","Abomination",
            "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/sm/4-abomination.jpg")
    )

    fun getSuperheroes(): List<Superhero> {
        return superheroes
    }

    fun getSuperhero(id: String): Superhero? {
        return getSuperheroes().find { it.id == id }
    }

}