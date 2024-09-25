package edu.example.dam2024.features.superhero.domain.models

data class SuperheroApi(
    val id: String, val name: String, val slug: String, val powerStats: PowerStats,
    val appearance: Appearance, val biography: Biography, val work: Work,
    val connections: Connections, val images: Images
) {
}