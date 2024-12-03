package edu.example.dam2024.app.presentation.views

import android.content.Context
import edu.example.dam2024.app.domain.ErrorApp

class ErrorAppUIFactory(private val context: Context) {

    fun build(errorApp: ErrorApp): ErrorAppUI {
        when (errorApp) {
            ErrorApp.DataErrorApp -> ServerErrorAppUI(context)
            ErrorApp.InternetErrorApp -> ConnectionErrorAppUI(context)
            ErrorApp.ServerErrorApp -> ServerErrorAppUI(context)
            ErrorApp.UnknowErrorApp -> UnknownErrorAppUI(context)
        }
    }
}