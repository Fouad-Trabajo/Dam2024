package edu.example.dam2024.features.superhero.data.remote

import edu.example.dam2024.features.superhero.domain.models.Superhero

class SuperheroMockRemoteDataSource {

    private val superheroes = listOf(
        Superhero(id = "1", name = "A-Bomb", image = "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/md/1-a-bomb.jpg"),
        Superhero(id = "2", name = "Abe Sapien", image = "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/md/2-abe-sapien.jpg"),
        Superhero(id = "3", name = "Abin Sur", image = "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/md/3-abin-sur.jpg"),
        Superhero(id = "4", name = "Abomination", image = "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/md/4-abomination.jpg"),
        Superhero(id = "5", name = "Abraxas", image = "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/md/5-abraxas.jpg"),
        Superhero(id = "6", name = "Absorbing Man", image = "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/md/6-absorbing-man.jpg"),
        Superhero(id = "7", name = "Adam Monroe", image = "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/md/7-adam-monroe.jpg"),
        Superhero(id = "8", name = "Adam Strange", image = "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/md/8-adam-strange.jpg"),
        Superhero(id = "10", name = "Agent Bob", image = "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/md/10-agent-bob.jpg"),
        Superhero(id = "11", name = "Agent Zero", image = "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/md/11-agent-zero.jpg"),
        Superhero(id = "12", name = "Air-Walker", image = "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/md/12-air-walker.jpg"),
        Superhero(id = "13", name = "Ajax", image = "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/md/13-ajax.jpg"),
        Superhero(id = "14", name = "Alan Scott", image = "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/md/14-alan-scott.jpg"),
        Superhero(id = "15", name = "Alex Mercer", image = "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/md/15-alex-mercer.jpg"),
        Superhero(id = "17", name = "Alfred Pennyworth", image = "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/md/17-alfred-pennyworth.jpg"),
        Superhero(id = "18", name = "Alien", image = "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/md/18-alien.jpg"),
        Superhero(id = "20", name = "Amazo", image = "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/md/20-amazo.jpg")
    )


    fun getSuperheroes(): List<Superhero> {
        return superheroes
    }

    fun getSuperhero(id: String): Superhero? {
        return getSuperheroes().find { it.id == id }
    }

}