package edu.example.dam2024.app.presentation.views

import android.content.Context
import edu.example.dam2024.R

interface ErrorAppUI {
    fun getImageError(): Int //Devolver un recurso de drawable devuelve un entero
    fun getTitleError(): String
    fun getDescriptionError(): String
    fun getActionRetry(): Unit
}


class ServerErrorAppUI(val context: Context) : ErrorAppUI {
    override fun getImageError(): Int {
        return R.drawable.cinema_background
    }

    override fun getTitleError(): String {
        return context.getString(R.string.title_error_server)

    }

    override fun getDescriptionError(): String {
        return context.getString(R.string.description_error_server)
    }

    override fun getActionRetry() {
        TODO("Not yet implemented")
    }
}

//Ahora se deben cambiar la foto, el titulo, descripción para cada error
class ConnectionErrorAppUI(val context: Context) : ErrorAppUI {
    override fun getImageError(): Int {
        return R.drawable.cinema_background
    }

    override fun getTitleError(): String {
        return context.getString(R.string.title_error_server)

    }

    override fun getDescriptionError(): String {
        return context.getString(R.string.description_error_server)
    }

    override fun getActionRetry() {
        TODO("Not yet implemented")
    }

}

//Ahora se deben cambiar la foto, el titulo, descripción para cada error
class UnknownErrorAppUI(val context: Context) : ErrorAppUI {
    override fun getImageError(): Int {
        return R.drawable.cinema_background
    }

    override fun getTitleError(): String {
        return context.getString(R.string.title_error_server)

    }

    override fun getDescriptionError(): String {
        return context.getString(R.string.description_error_server)
    }

    override fun getActionRetry() {
        TODO("Not yet implemented")
    }

}