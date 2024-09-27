package edu.example.dam2024.features.superhero.data.local

import android.content.Context
import edu.example.dam2024.R
import edu.example.dam2024.features.superhero.domain.models.Superhero

class SuperheroXmlLocalDataSource(private val context: Context) {

    private val sharedPreferences =
        context.getSharedPreferences(
            context.getString(R.string.name_file_xml2),
            Context.MODE_PRIVATE
        )


    fun save(superhero: Superhero) {
        val editor = sharedPreferences.edit()
        editor.putString("id", superhero.id)
        editor.putString("name", superhero.name)
        editor.putString("image", superhero.image)
        editor.apply()
    }


    fun getSuperhero(): Superhero {
        val id = sharedPreferences.getString("id", "")
        val name = sharedPreferences.getString("name", "")
        val image = sharedPreferences.getString("image", "")
        return Superhero(id!!, name!!, image!!)
    }
}