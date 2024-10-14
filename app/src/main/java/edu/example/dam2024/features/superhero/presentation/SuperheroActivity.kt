package edu.example.dam2024.features.superhero.presentation

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import edu.example.dam2024.R

class SuperheroActivity : AppCompatActivity() {

    //Inicialización
    private lateinit var superheroFactory : SuperheroFactory
    private lateinit var viewModel : SuperheroesViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_superheroes)



        // Show all superheroes in the logcat
        //val superhero: List<Superhero> = viewModel.getSuperheroes()
       // Log.d("@dev", superhero.toString())

        // Call one superhero with clicker in the emulator
        //bindData(superhero)
        //viewModel.getSuperhero(superhero.first().id)

        //Save, get and delete model in superheroes.xml
        //textXml()

        //Save, get and delete list of superheroes in superheroes.xml
        //testListXml()
    }


/*
    private fun textXml() {
        val superheroXmlLocalDataSource = SuperheroXmlLocalDataSource(this)
        val superhero = viewModel.getSuperhero("1")
        superhero?.let {
            superheroXmlLocalDataSource.save(it) //Guardar el superhéroe en el archivo xml
        }
        val superheroSave =
            superheroXmlLocalDataSource.getSuperhero() //Obtener el superhero del xml
        Log.d("@dev", superheroSave.toString())

        //Delete superhero in superheroes.xml
        superheroXmlLocalDataSource.delete()
    }

    private fun testListXml(){
        val superheroXmlLocalDataSource = SuperheroXmlLocalDataSource(this)
        val superheroes = viewModel.getSuperheroes()
        superheroXmlLocalDataSource.saveAll(superheroes)

        // Get list of superheroes in superheroes.xml
        val superheroSave = superheroXmlLocalDataSource.getSuperheroes()
        Log.d("@dev", superheroSave.toString())

    }

 */
}