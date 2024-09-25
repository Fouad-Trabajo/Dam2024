package edu.example.dam2024.features.superhero.presentation

import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import edu.example.dam2024.R
import edu.example.dam2024.features.superhero.domain.models.Superhero

class SuperheroActivity : AppCompatActivity() {

    private val superheroViewModel: SuperheroFactory = SuperheroFactory()
    private val viewModel = superheroViewModel.buildViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_superhero)
        val superheroes = viewModel.getSuperheroes()
        bindData(superheroes)
        viewModel.getSuperhero(superheroes.first().id)
    }


    private fun bindData(superheroes: List<Superhero>){


        for (i in superheroes.indices) {
            val superhero = superheroes[i]
            val layoutId = resources.getIdentifier("layout_${i + 1}", "id", packageName)
            val idTextViewId = resources.getIdentifier("superhero_id_${i + 1}", "id", packageName)
            val nameTextViewId = resources.getIdentifier("superhero_name_${i + 1}", "id", packageName)

            findViewById<TextView>(idTextViewId).text = superhero.id
            findViewById<TextView>(nameTextViewId).text = superhero.name
            findViewById<LinearLayout>(layoutId).setOnClickListener {
                viewModel.getSuperhero(superhero.id)?.let {
                    Log.d("@dev", "Superhéroe seleccionado: ${it.name}")
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("@dev", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("@dev", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("@dev", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("@dev", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("@dev", "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("@dev", "onRestart")
    }
}