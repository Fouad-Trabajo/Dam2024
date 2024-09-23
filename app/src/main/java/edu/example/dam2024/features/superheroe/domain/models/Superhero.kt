package edu.example.dam2024.features.superheroe.domain.models

data class Superhero(
    val id: String, val name: String, val slug: String, val powerstats: List<Int>,
    val appearance: Appearance, val biography: Biography, val work: Work,
    val connections: Connections, val images: Images
) {
}