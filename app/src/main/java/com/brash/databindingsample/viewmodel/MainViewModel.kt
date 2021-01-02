package com.brash.databindingsample.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.brash.databindingsample.model.Recipes
import com.brash.databindingsample.repository.RecipeRepository
import com.brash.databindingsample.repository.RecipeRepositoryImp
import kotlinx.coroutines.Dispatchers

class MainViewModel (
    private val recipeRepo: RecipeRepository = RecipeRepositoryImp()
) : ViewModel() {

    fun getRecipes(): LiveData<Recipes?> {
        return recipeRepo.getRecipes()
    }
}