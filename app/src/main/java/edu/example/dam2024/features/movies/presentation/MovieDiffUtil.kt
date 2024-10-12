package edu.example.dam2024.features.movies.presentation

import androidx.recyclerview.widget.DiffUtil
import edu.example.dam2024.features.movies.domain.models.Movie

class MovieDiffUtil : DiffUtil.ItemCallback<Movie>(){

    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem.id == newItem.id
    } //Si el id conicide es que el item es el mismo

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem == newItem
    } //Si el item antiguo es igual al nuevo ,quiere decir que el contenido es el mismo
}