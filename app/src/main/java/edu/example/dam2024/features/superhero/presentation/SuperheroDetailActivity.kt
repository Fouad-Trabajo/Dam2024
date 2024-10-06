package edu.example.dam2024.features.superhero.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import edu.example.dam2024.R
import edu.example.dam2024.app.domain.ErrorApp
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


        setupObserver()
        getSuperheroId()?.let{ superheroId ->
            viewModel.viewCreated(superheroId)
        }
    }


    private fun getSuperheroId(): String?{
        return intent.getStringExtra(KEY_SUPERHERO_ID)
    }

    private fun bindData(superhero: Superhero){
        // Texto
        val nameTextView = findViewById<TextView>(R.id.title_superhero_1) // Reemplaza con el ID correcto de tu TextView
        nameTextView.text = superhero.name

        // Image
        val imageView = findViewById<ImageView>(R.id.image_1)
        imageView.loadUrl(superhero.image)
    }

    private fun setupObserver(){
        val superheroObserver = Observer<SuperheroDetailViewModel.UiState>{ uiState ->
            uiState.superhero?.let{
                bindData(it)
            }
            uiState.errorApp?.let{
                // pinto el error
            }
            if (uiState.isLoading){
                //muestro cargando...
                Log.d("@dev", "Cargando...")
            }else{
                //oculto cargando
                Log.d("@dev", "Oculto cargando...")
            }
        }
        viewModel.uiState.observe(this, superheroObserver)
    }

    private fun showError(error: ErrorApp){
        when(error){
            ErrorApp.DataErrorApp -> TODO()
            ErrorApp.InternetErrorApp -> TODO()
            ErrorApp.ServerErrorApp -> TODO()
        }
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