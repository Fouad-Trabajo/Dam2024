package edu.example.dam2024.features.movies.data.local

import android.content.Context
import com.google.gson.Gson
import edu.example.dam2024.R
import edu.example.dam2024.features.movies.domain.models.Movie

class MovieXmlLocalDataSource(private val context: Context) {
    //Tambien le puedo pasar un MovieActivity y heredar de Context igualmente


    /**
    Context es la clase más importante para acceder a todos lo recuersos (.xml, img, audio...)

    R es la carpeta que contiene todos los recursos de la app.
    ESta es la forma para acceder a un archivo .xml
     */

    private val gson = Gson() //Para serializar y deserializar objetos

    private val sharedPreferences =
        context.getSharedPreferences(
            context.getString(R.string.name_file_xml), // Clave
            Context.MODE_PRIVATE // Valor
        )

    fun save(movie: Movie) {
        sharedPreferences.edit().apply {
            putString("id", movie.id)
            putString("title", movie.title)
            putString("poster", movie.poster)
            apply() //Guardar los cambios, también se puede hacer con editor.commit() (Esto es sincrono)
        }
    }


    fun getMovie(): Movie { //De esta forma se haría en Kotlin y no en Java
        sharedPreferences.apply {
            return Movie(
                getString("id", "")!!,
                getString("title", "")!!,
                getString("poster", "")!!
            )
        }

        //Esto no es muy recomendable, porque sabemos que no es nulo. Estamos haciendo un test
    }


    fun saveAll(movies: List<Movie>) {
        val editor = sharedPreferences.edit()
        movies.forEach { movie ->  //Renombrar la variable movie a it
            editor.putString(movie.id,
                gson.toJson(movie)
            ) //Serializar la película (persistir sus estados)
        }
        editor.apply()
    }

    fun getMovies(): List<Movie> { // "as" es un casting en Kotlin
        val movies = mutableListOf<Movie>() //Es una nueva colección de Kotlin
        val mapMovies =
            sharedPreferences.all  // as Map<String, String> Esto es un mapa de clave-valor
        mapMovies.values.forEach { jsonMovie ->
            val movie = gson.fromJson(jsonMovie as String, Movie::class.java) //Deseriazliar la lista
            movies.add(movie)
        }
        return movies
    }


    fun delete() {
        sharedPreferences.edit().clear().apply()
    }

}