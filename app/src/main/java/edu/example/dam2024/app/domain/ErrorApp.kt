package edu.example.dam2024.app.domain

sealed class ErrorApp : Throwable() { //Son enum vitaminados (llenos de esteroides)

    object InternetErrorApp : ErrorApp() //cambiar object por class
    object ServerErrorApp: ErrorApp()
    object DataErrorApp: ErrorApp()
    //object UnknownErrorApp: ErrorApp()
}