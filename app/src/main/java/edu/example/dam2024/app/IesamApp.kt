package edu.example.dam2024.app

import android.app.Application
import edu.example.dam2024.app.di.AppModule
import edu.example.dam2024.app.di.RemoteModule
import edu.example.dam2024.features.superhero.di.SuperheroModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.ksp.generated.module


class IesamApp : Application() {


    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@IesamApp)
            modules(
                AppModule().module,
                RemoteModule().module,
                SuperheroModule().module
            )
        }
    }

}