package edu.example.dam2024.features.superhero.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SuperheroApiClient {

    companion object {
        private const val BASE_URL = "https://akabab.github.io/superhero-api/api/"

        private val retrofit: Retrofit by lazy {
            Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        val SuperheroApiService: SuperheroApiService by lazy {
            retrofit.create(SuperheroApiService::class.java)
        }
    }

}