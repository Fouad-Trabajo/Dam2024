package edu.example.dam2024.features.superhero.data.remote

import com.google.gson.annotations.SerializedName

data class SuperheroApiModel(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("slug") val slug: String,
    @SerializedName("powerstats") val powerStats: SuperheroPowerStatsApiModel,
    @SerializedName("appearance") val appearance: SuperheroAppearanceApiModel,
    @SerializedName("biography") val biography: SuperheroBiographyApiModel,
    @SerializedName("work") val work: SuperheroWorkApiModel,
    @SerializedName("connections") val connections: SuperheroConnectionsApiModel,
    @SerializedName("images") val images: SuperheroImagesApiModel
)


data class SuperheroPowerStatsApiModel(
    @SerializedName("intelligence") val intelligence: String,
    @SerializedName("strength") val strength: String,
    @SerializedName("speed") val speed: String,
    @SerializedName("durability") val durability: String,
    @SerializedName("power") val power: String,
    @SerializedName("combat") val combat: String
)

data class SuperheroAppearanceApiModel(
    @SerializedName("gender") val gender: String,
    @SerializedName("race") val race: String,
    @SerializedName("height") val height: List<String>,
    @SerializedName("weight") val weight: List<String>,
    @SerializedName("eyeColor") val eyeColor: String,
    @SerializedName("hairColor") val hairColor: String
)

data class SuperheroBiographyApiModel(
    @SerializedName("fullName") val fullName: String,
    @SerializedName("alterEgos")val alterEgos: String,
    @SerializedName("aliases")val aliases: List<String>,
    @SerializedName("placeOfBirth")val placeOfBirth: String,
    @SerializedName("firstAppearance")val firstAppearance: String,
    @SerializedName("publisher")val publisher: String,
    @SerializedName("alignment")val alignment: String
)

data class SuperheroWorkApiModel(
    @SerializedName("occupation")val occupation: String,
    @SerializedName("base")val base: String)

data class SuperheroConnectionsApiModel(
    @SerializedName("groupAffiliation")val groupAffiliation: String,
    @SerializedName("relatives")val relatives: String)

data class SuperheroImagesApiModel(
    @SerializedName("xs")val xs: String,
    @SerializedName("sm")val sm: String,
    @SerializedName("md")val md: String,
    @SerializedName("lg")val lg: String)
