package com.brash.databindingsample.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.brash.databindingsample.network.Resource
import com.brash.databindingsample.repository.RecipeRepository
import kotlinx.coroutines.Dispatchers

class MainViewModel (
    private val recipeRepo: RecipeRepository
) : ViewModel() {
    val recipe = liveData(Dispatchers.IO) {
        emit(Resource.loading(null))
        emit(recipeRepo.getRecipes())
    }
}