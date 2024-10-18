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