package edu.example.dam2024.features.pokemon.presentation.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import edu.example.dam2024.app.extensions.loadUrl
import edu.example.dam2024.databinding.ViewMovieItemBinding
import edu.example.dam2024.databinding.ViewPokemonItemBinding
import edu.example.dam2024.features.movies.domain.models.Movie
import edu.example.dam2024.features.pokemon.domain.Pokemon

class PokemonViewHolder(private val view: View): RecyclerView.ViewHolder(view) {

    private lateinit var binding: ViewPokemonItemBinding

    fun bind(pokemon: Pokemon, onClick: (String) -> Unit){
        binding = ViewPokemonItemBinding.bind(view)

        binding.apply {
            pokemonImage.loadUrl(pokemon.abilities.toString())
            pokemonName.text = pokemon.name
            //movieDescription1.text = movie.description
            view.setOnClickListener {
                onClick(pokemon.id)
            }
        }
    }
}