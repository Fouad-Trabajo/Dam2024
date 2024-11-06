package edu.example.dam2024.features.superhero.di


import edu.example.dam2024.features.superhero.data.remote.SuperheroService
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single
import retrofit2.Retrofit

@Module
@ComponentScan
class SuperheroModule {


    @Single
    fun provideSuperheroService(retrofit: Retrofit): SuperheroService =
        retrofit.create(SuperheroService::class.java)
}