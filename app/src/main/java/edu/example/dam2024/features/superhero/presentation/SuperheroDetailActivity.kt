package edu.example.dam2024.features.superhero.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import edu.example.dam2024.R
import edu.example.dam2024.app.extensions.loadUrl
import edu.example.dam2024.features.superhero.domain.models.Superhero

class SuperheroDetailActivity : AppCompatActivity() {

    private lateinit var superheroFactory: SuperheroFactory
    private lateinit var viewModel: SuperheroDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_superhero_detail)

        superheroFactory = SuperheroFactory(this)
        viewModel = superheroFactory.buildSuperheroDetailViewModel()


        getSuperheroId()?.let{ superheroId ->
            viewModel.viewCreated(superheroId)?.let{ superhero ->
                bindData(superhero)
            }

        }
    }


    private fun getSuperheroId(): String?{
        return intent.getStringExtra(KEY_SUPERHERO_ID)
    }

    private fun bindData(superhero: Superhero){
        // Texto
        val idTextView = findViewById<TextView>(R.id.title_1) // Reemplaza con el ID correcto de tu TextView
        val nameTextView = findViewById<TextView>(R.id.title_1) // Reemplaza con el ID correcto de tu TextView
        idTextView.text = superhero.id.toString()  // Asegúrate de que id sea un String
        nameTextView.text = superhero.name

        // Imagen
        val imageView = findViewById<ImageView>(R.id.image_1)
        imageView.loadUrl(superhero.image)
    }

    //Función estática que siempre va en la parte de abajo de la clase
    companion object{
        val KEY_SUPERHERO_ID = "key_superhero_id"

        fun getIntent(context: Context, superheroId: String): Intent {
            val intent = Intent(context, SuperheroDetailActivity::class.java)
            intent.putExtra(KEY_SUPERHERO_ID, superheroId)
            return intent
        }
    }
}