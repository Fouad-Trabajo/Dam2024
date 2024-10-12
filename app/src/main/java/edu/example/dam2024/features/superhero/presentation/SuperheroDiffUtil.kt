package edu.example.dam2024.features.superhero.presentation

import androidx.recyclerview.widget.DiffUtil
import edu.example.dam2024.features.superhero.domain.models.Superhero

class SuperheroDiffUtil: DiffUtil.ItemCallback<Superhero>() {

    override fun areItemsTheSame(oldItem: Superhero, newItem: Superhero): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Superhero, newItem: Superhero): Boolean {
        return oldItem == newItem
    }
}