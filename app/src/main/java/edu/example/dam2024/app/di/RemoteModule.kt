package edu.example.dam2024.app.di

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@ComponentScan //"edu.iesam.dam2024.features.movies.data.remote"
class RemoteModule {


    private val url = "https://akabab.github.io/superhero-api/api/"

    @Single
    fun provideLoggingInterceptor() = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
        /* if aplication is modee debug = Level.BODY
        else = Level.NONE
         */
    }

    @Single
    fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        val okHttpClient = OkHttpClient
            .Builder()
            .addInterceptor(loggingInterceptor)
            .build()
        return okHttpClient
    }

    @Single
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        val retrofit =
            Retrofit.Builder()
                .baseUrl(url)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        return retrofit
    }


    /** ```
     *  fun provideLoggingInterceptor(): HttpLoggingInterceptor {
     *         val loggingInterceptor = HttpLoggingInterceptor()
     *         loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
     *         /* if aplication is modee debug = Level.BODY
     *         else = Level.NONE
     *          */
     *         return loggingInterceptor
     *     }
     *
     *     Esto sería en lenguaje Java
     *```
     */
}