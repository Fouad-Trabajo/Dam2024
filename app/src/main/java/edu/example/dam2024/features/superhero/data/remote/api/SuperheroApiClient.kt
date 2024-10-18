package edu.example.dam2024.features.superhero.data.remote.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SuperheroApiClient {


    private val BASE_URL = "https://akabab.github.io/superhero-api/api/"

    private val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()).build()


    val superheroApiService: SuperheroApiService =
        retrofit.create(SuperheroApiService::class.java)

}