package edu.example.dam2024.features.superhero.domain.models

data class Superhero(
    val id: String, val name: String, val slug: String, val powerStats: PowerStats,
    val appearance: Appearance, val biography: Biography, val work: Work,
    val connections: Connections, val images: Images
)

data class PowerStats(
    val intelligence: String, val strength: String, val speed: String,
    val durability: String,
    val power: String, val combat: String
)

data class Appearance(
    val gender: String, val race: String, val height: List<String>,
    val weight: List<String>, val eyeColor: String, val hairColor: String
)

data class Biography(
    val fullName: String,
    val alterEgos: String,
    val aliases: List<String>,
    val placeOfBirth: String,
    val firstAppearance: String,
    val publisher: String,
    val alignment: String
)

data class Work(val occupation: String, val base: String)

data class Connections(val groupAffiliation: String, val relatives: String)

data class Images(val xs: String, val sm: String, val md: String, val lg: String)

