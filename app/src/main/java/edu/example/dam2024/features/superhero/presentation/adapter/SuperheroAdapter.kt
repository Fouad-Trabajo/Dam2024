package edu.example.dam2024.features.superhero.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import edu.example.dam2024.R
import edu.example.dam2024.features.superhero.domain.models.Superhero
import edu.example.dam2024.features.superhero.presentation.SuperheroDiffUtil

class SuperheroAdapter: ListAdapter<Superhero, SuperheroViewHolder>(SuperheroDiffUtil()) {

    private lateinit var onClick: (superheroId: String) -> Unit
    fun setEvent(onClick: (superheroId: String) -> Unit){
        this.onClick = onClick
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperheroViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_superhero_item,parent,false)
        return SuperheroViewHolder(view)
    }

    override fun getItemCount(): Int = currentList.size

    override fun onBindViewHolder(holder: SuperheroViewHolder, position: Int){
        holder.bind(currentList[position], onClick)
    }
}