package edu.example.dam2024.features.superhero.presentation.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import edu.example.dam2024.app.extensions.loadUrl
import edu.example.dam2024.databinding.ViewSuperheroItemBinding
import edu.example.dam2024.features.superhero.domain.models.Superhero

class SuperheroViewHolder(private val view: View): RecyclerView.ViewHolder(view) {

    private lateinit var binding: ViewSuperheroItemBinding

    fun bind(superhero: Superhero, onClick: (String) ->Unit){
        binding = ViewSuperheroItemBinding.bind(view)

        binding.apply{
            superheroImage.loadUrl(superhero.images.md)
            superheroName.text = superhero.name
            view.setOnClickListener{
                onClick(superhero.id)
            }
        }

    }

}