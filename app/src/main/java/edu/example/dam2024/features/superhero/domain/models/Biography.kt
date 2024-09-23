package edu.example.dam2024.features.superhero.domain.models

data class Biography(
    val fullName: String, val alterEgo: String, val aliases: List<String>,
    val placeOfBirth: String, val firstAppearance: String, val publisher: String,
    val alignment: String
) {
}