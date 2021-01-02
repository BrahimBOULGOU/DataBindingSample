package com.brash.databindingsample.network

import com.brash.databindingsample.model.Recipes
import retrofit2.Call
import retrofit2.http.GET

interface RecipeApis {
    @GET("api/?i=onions,garlic&q=omelet&p=3")
     fun getRecipes(): Call<Recipes>
}