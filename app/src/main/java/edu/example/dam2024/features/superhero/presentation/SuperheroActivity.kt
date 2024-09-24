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
        findViewById<TextView>(R.id.superhero_id_1).text = superheroes[0].id
        findViewById<TextView>(R.id.superhero_name_1).text = superheroes[0].name
        findViewById<LinearLayout>(R.id.layout_1).setOnClickListener{
            val superhero1: Superhero? = viewModel.getSuperhero(superheroes[0].id)
            superhero1?.let{
                Log.d("@dev", "Supherheroe seleccionado: ${it.name}")
            }
        }

        findViewById<TextView>(R.id.superhero_id_2).text = superheroes[1].id
        findViewById<TextView>(R.id.superhero_name_2).text = superheroes[1].name
        findViewById<LinearLayout>(R.id.layout_2).setOnClickListener{
            val superhero2: Superhero? = viewModel.getSuperhero(superheroes[1].id)
            superhero2?.let {
                Log.d("@dev", "Supherheroe seleccionado: ${it.name}")
            }
        }

        findViewById<TextView>(R.id.superhero_id_3).text = superheroes[2].id
        findViewById<TextView>(R.id.superhero_name_3).text = superheroes[2].name
        findViewById<LinearLayout>(R.id.layout_3).setOnClickListener{
            val superhero1: Superhero? = viewModel.getSuperhero(superheroes[2].id)
            superhero1?.let{
                Log.d("@dev", "Supherheroe seleccionado: ${it.name}")
            }
        }

        findViewById<TextView>(R.id.superhero_id_4).text = superheroes[3].id
        findViewById<TextView>(R.id.superhero_name_4).text = superheroes[3].name
        findViewById<LinearLayout>(R.id.layout_4).setOnClickListener{
            val superhero2: Superhero? = viewModel.getSuperhero(superheroes[3].id)
            superhero2?.let {
                Log.d("@dev", "Supherheroe seleccionado: ${it.name}")
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