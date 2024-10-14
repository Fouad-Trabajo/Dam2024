package edu.example.dam2024.features.pokemon.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import edu.example.dam2024.R
import edu.example.dam2024.features.pokemon.domain.Pokemon
import edu.example.dam2024.features.pokemon.presentation.PokemonDiffUtil

class PokemonAdapter : ListAdapter<Pokemon, PokemonViewHolder>(PokemonDiffUtil()) {

    private lateinit var onClick: (pokemonId: String) -> Unit

    fun setEvent(onClick: (pokemonId: String) -> Unit) {
        this.onClick = onClick
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.view_pokemon_item, parent, false)
        return PokemonViewHolder(view)
    }
    //Al crear el PokemonDiffUtil, ya n hace falta el método de getItemCount()

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.bind(currentList[position], onClick)
    }
}