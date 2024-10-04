package edu.example.dam2024.app.domain

sealed class ErrorApp { //Son enum vitaminados (llenos de esteroides)

    object InternetErrorApp : ErrorApp()
    object ServerErrorApp: ErrorApp()
    object DataErrorApp: ErrorApp()
}