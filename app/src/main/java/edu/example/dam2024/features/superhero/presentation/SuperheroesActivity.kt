package edu.example.dam2024.features.superhero.presentation

import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import edu.example.dam2024.R
import edu.example.dam2024.app.domain.ErrorApp
import edu.example.dam2024.features.superhero.domain.models.Superhero

class SuperheroesActivity : AppCompatActivity() {

    //Inicialización
    private lateinit var superheroFactory : SuperheroFactory
    private lateinit var viewModel : SuperheroesViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_superheroes)

        superheroFactory = SuperheroFactory(this)
        viewModel = superheroFactory.buildViewModel()

        // Show all superheroes in the logcat
        //val superhero: List<Superhero> = viewModel.getSuperheroes()
       // Log.d("@dev", superhero.toString())
        setupObserver()
        viewModel.viewCreated()
        // Call one superhero with clicker in the emulator
        //bindData(superhero)
        //viewModel.getSuperhero(superhero.first().id)

        //Save, get and delete model in superheroes.xml
        //textXml()

        //Save, get and delete list of superheroes in superheroes.xml
        //testListXml()
    }

    fun setupObserver(){
        val superheroObserver = Observer<SuperheroesViewModel.UiState> { uiState ->
            uiState.superheroes?.let{
                bindData(it)
            }
            uiState.errorApp?.let{
                //pinto el error
            }
            if (uiState.isLoading){
                //muestro el cargando...
                Log.d("@dev", "Cargando...")
            }else{
                //oculto el cargando
                Log.d("@dev","Oculto cargando...")
            }
        }
        //uso la variable superheroObserver para "observar" el ViewModel
        viewModel.uiState.observe(this, superheroObserver)

    }

    private fun bindData(superheroes: List<Superhero>) {
        for (i in superheroes.indices) {
            val superhero = superheroes[i]
            val layoutId = resources.getIdentifier("layout_${i + 1}", "id", packageName)
            val idTextViewId = resources.getIdentifier("superhero_id_${i + 1}", "id", packageName)
            val nameTextViewId =
                resources.getIdentifier("superhero_name_${i + 1}", "id", packageName)

            findViewById<TextView>(idTextViewId).text = superhero.id
            findViewById<TextView>(nameTextViewId).text = superhero.name
            findViewById<LinearLayout>(layoutId).setOnClickListener {
                navigateToSuperheroDetail(superhero.id)
            }
        }
    }

    private fun showError(error: ErrorApp){
        when(error){
            ErrorApp.DataErrorApp -> TODO()
            ErrorApp.InternetErrorApp -> TODO()
            ErrorApp.ServerErrorApp -> TODO()
        }
    }

    private fun navigateToSuperheroDetail(superheroId: String){
        startActivity(SuperheroDetailActivity.getIntent(this, superheroId))
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