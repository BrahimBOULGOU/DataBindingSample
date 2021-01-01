package com.brash.databindingsample.repository

import com.brash.databindingsample.model.Recipes
import com.brash.databindingsample.network.RecipeApis
import com.brash.databindingsample.network.Resource
import com.brash.databindingsample.network.ResponseHandler

class RecipeRepository (
    private val recipeApis: RecipeApis,
    private val responseHandler: ResponseHandler
) {

    suspend fun getRecipes(): Resource<Recipes> {
        return try {
            val response = recipeApis.getRecipes()
            return responseHandler.handleSuccess(response)
        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }
}