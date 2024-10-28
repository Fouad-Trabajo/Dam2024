package edu.example.dam2024.features.superhero.data.remote

data class SuperheroApiModel(
    val id: String,
    val name: String,
    val slug: String,
    val powerStats: SuperheroPowerStatsApiModel,
    val appearance: SuperheroAppearanceApiModel,
    val biography: SuperheroBiographyApiModel,
    val work: SuperheroWorkApiModel,
    val connections: SuperheroConnectionsApiModel,
    val images: SuperheroImagesApiModel
)


data class SuperheroPowerStatsApiModel(
    val intelligence: String, val strength: String, val speed: String,
    val durability: String,
    val power: String, val combat: String
)

data class SuperheroAppearanceApiModel(
    val gender: String, val race: String, val height: List<String>,
    val weight: List<String>, val eyeColor: String, val hairColor: String
)

data class SuperheroBiographyApiModel(
    val fullName: String,
    val alterEgos: String,
    val aliases: List<String>,
    val placeOfBirth: String,
    val firstAppearance: String,
    val publisher: String,
    val alignment: String
)

data class SuperheroWorkApiModel(val occupation: String, val base: String)

data class SuperheroConnectionsApiModel(val groupAffiliation: String, val relatives: String)

data class SuperheroImagesApiModel(val xs: String, val sm: String, val md: String, val lg: String)
