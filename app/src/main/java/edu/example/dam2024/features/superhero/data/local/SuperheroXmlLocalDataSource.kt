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

    fun delete() {
        sharedPreferences.edit().clear().apply()
    }
}
