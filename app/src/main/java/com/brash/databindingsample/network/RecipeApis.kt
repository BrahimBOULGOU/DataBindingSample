package com.brash.databindingsample.network

import com.brash.databindingsample.model.Recipes
import retrofit2.http.GET

interface RecipeApis {
    @GET("api/?i=onions,garlic&q=omelet&p=3")
    suspend fun getRecipes(): Recipes
}