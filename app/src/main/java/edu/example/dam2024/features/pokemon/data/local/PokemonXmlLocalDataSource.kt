package edu.example.dam2024.features.pokemon.data.local

import android.content.Context
import com.google.gson.Gson
import edu.example.dam2024.R
import edu.example.dam2024.features.pokemon.domain.Pokemon

class PokemonXmlLocalDataSource(private val context: Context) {

    private val gson = Gson()

    private val sharedPreferences = context.getSharedPreferences(
        context.getString(R.string.pokemon_file_xml), Context.MODE_PRIVATE
    )

    fun save(pokemon: Pokemon) {
        val editor = sharedPreferences.edit()
        editor.putString(pokemon.id, gson.toJson(pokemon))
        editor.apply()
    }

    fun findById(pokemon: String): Pokemon? {
        return sharedPreferences.getString(pokemon, null)?.let { pokemon ->
            gson.fromJson(pokemon, Pokemon::class.java)
        }
    }

    fun saveAll(pokemons: List<Pokemon>) {
        val editor = sharedPreferences.edit()
        pokemons.forEach { pokemon ->
            editor.putString(pokemon.id, gson.toJson(pokemon))
        }
        editor.apply()
    }

    fun getPokemons(): List<Pokemon> {
        val pokemons = mutableListOf<Pokemon>()
        val mapPokemons = sharedPreferences.all
        mapPokemons.values.forEach { jsonPokemon ->
            val pokemon = gson.fromJson(jsonPokemon as String, Pokemon::class.java)
            pokemons.add(pokemon)
        }
        return pokemons
    }

    fun delete(){
        sharedPreferences.edit().clear().apply()
    }

    fun deleteById(pokemonId: String){
        sharedPreferences.edit().remove(pokemonId)
    }

}