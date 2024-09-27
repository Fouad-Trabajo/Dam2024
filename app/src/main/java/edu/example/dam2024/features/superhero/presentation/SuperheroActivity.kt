package edu.example.dam2024.features.superhero.presentation

import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import edu.example.dam2024.R
import edu.example.dam2024.features.superhero.data.local.SuperheroXmlLocalDataSource
import edu.example.dam2024.features.superhero.domain.models.Superhero

class SuperheroActivity : AppCompatActivity() {


    private val superheroFactory = SuperheroFactory()
    private val viewModel = superheroFactory.buildViewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_superhero)


        // Show all superheroes in the logcat
        val superhero: List<Superhero> = viewModel.getSuperheroes()
        Log.d("@dev", superhero.toString())

        // Call one superhero with clicker in the emulator
        bindData(superhero)
        viewModel.getSuperhero(superhero.first().id)

        //Save and get a superhero in file.xml
        textXml()
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


    private fun textXml(){
        val superheroXmlLocalDataSource = SuperheroXmlLocalDataSource(this)
        val superhero = viewModel.getSuperhero("1")
        superhero?.let{
            superheroXmlLocalDataSource.save(it) //Guardar el superhéroe en el archivo xml
        }
        val superheroSave = superheroXmlLocalDataSource.getSuperhero() //Obtener el superhero del xml
        Log.d("@dev", superheroSave.toString())
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