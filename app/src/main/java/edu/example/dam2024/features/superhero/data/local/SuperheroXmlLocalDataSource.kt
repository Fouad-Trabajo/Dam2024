package edu.example.dam2024.features.superhero.data.local

import android.content.Context
import com.google.gson.Gson
import edu.example.dam2024.R
import edu.example.dam2024.features.superhero.domain.models.Superhero

class SuperheroXmlLocalDataSource(private val context: Context) {

    private val gson = Gson()

    private val sharedPreferences =
        context.getSharedPreferences(
            context.getString(R.string.name_file_xml2),
            Context.MODE_PRIVATE
        )


    fun save(superhero: Superhero) {
        sharedPreferences.edit().apply {
            putString("id", superhero.id)
            putString("name", superhero.name)
            putString("image", superhero.image)
            apply()
        }
    }


    fun getSuperhero(): Superhero {
        sharedPreferences.apply {
            return Superhero(
                getString("id", "")!!,
                getString("name", "")!!,
                getString("image", "")!!
            )
        }
    }

    fun saveAll(superheroes: List<Superhero>){
        val editor = sharedPreferences.edit()
        superheroes.forEach{ superhero ->
            editor.putString(superhero.id, gson.toJson(superhero))
        }
        editor.apply()
    }

    fun getSuperheroes(): List<Superhero> {
        val superheroes = mutableListOf<Superhero>()
        val mapSuperheroes = sharedPreferences.all
        mapSuperheroes.values.forEach{ jsonSuperhero ->
            val superhero =gson.fromJson(jsonSuperhero as String, Superhero::class.java)
            superheroes.add(superhero)
        }
        return superheroes
    }

    fun delete() {
        sharedPreferences.edit().clear().apply()
    }

    fun deleteById(superheroId: String){
        sharedPreferences.edit().remove(superheroId)
    }
}
