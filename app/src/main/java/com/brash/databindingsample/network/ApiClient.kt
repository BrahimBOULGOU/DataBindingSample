package com.brash.databindingsample.network

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
        private const val BASE_URL = "http://www.recipepuppy.com/"
        val getClient: RecipeApis
            get() {
                val gson = GsonBuilder()
                    .setLenient()
                    .create()
                val logger = HttpLoggingInterceptor()
                logger.level = HttpLoggingInterceptor.Level.BASIC
                val client = OkHttpClient.Builder().addInterceptor(logger).build()

                val retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build()

                return retrofit.create(RecipeApis::class.java)
            }
}