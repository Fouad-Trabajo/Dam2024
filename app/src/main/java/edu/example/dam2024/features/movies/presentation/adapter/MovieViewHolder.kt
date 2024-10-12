package edu.example.dam2024.features.movies.presentation.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import edu.example.dam2024.app.extensions.loadUrl
import edu.example.dam2024.databinding.ViewMovieItemBinding
import edu.example.dam2024.features.movies.domain.models.Movie

class MovieViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    private lateinit var binding: ViewMovieItemBinding


    fun bind(movie: Movie, onClick: (String) -> Unit){
        binding = ViewMovieItemBinding.bind(view)

        binding.apply {
            movieImage.loadUrl(movie.poster)
            movieTitle.text = movie.title
            //movieDescription1.text = movie.description
            view.setOnClickListener {
                onClick(movie.id)
            }
        }
    }
}