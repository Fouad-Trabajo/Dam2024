package edu.example.dam2024.features.superhero.data.remote

import edu.example.dam2024.features.superhero.domain.models.Superhero

//Mapper de datos de api a mapper de datos de dominio
fun SuperheroApiModel.toModel(): Superhero {
    return Superhero(
        this.id,
        this.name,
        this.images.md
    )
}