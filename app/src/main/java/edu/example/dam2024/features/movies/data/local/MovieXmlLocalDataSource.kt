package edu.example.dam2024.features.movies.data.local

import android.content.Context
import edu.example.dam2024.R
import edu.example.dam2024.features.movies.domain.models.Movie

class MovieXmlLocalDataSource(private val context: Context) {
    //Tambien le puedo pasar un MovieActivity y heredar de Context igualmente


    /**
    Context es la clase más importante para acceder a todos lo recuersos (.xml, img, audio...)

    R es la carpeta que contiene todos los recursos de la app.
    ESta es la forma para acceder a un archivo .xml
     */

    private val sharedPreferences =
        context.getSharedPreferences(
            context.getString(R.string.name_file_xml), // Clave
            Context.MODE_PRIVATE // Valor
        )

    fun save(movie: Movie) {
        val editor = sharedPreferences.edit()
        editor.putString("id", movie.id)
        editor.putString("title", movie.title)
        editor.putString("poster", movie.poster)
        editor.apply() //Guardar los cambios, también se puede hacer con editor.commit() (Esto es sincrono)
    }

    fun getMovie(): Movie{
        val id = sharedPreferences.getString("id","")
        val title = sharedPreferences.getString("id", "")
        val poster = sharedPreferences.getString("poster", "")
        return Movie(id!!, title!!, poster!!) //Esto no es muy recomendable, porque sabemos que no es nulo. Estamos haciendo un test
    }
}