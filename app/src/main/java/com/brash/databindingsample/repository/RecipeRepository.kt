package com.brash.databindingsample.repository

import androidx.lifecycle.LiveData
import com.brash.databindingsample.model.Recipes

interface RecipeRepository {
     fun getRecipes(): LiveData<Recipes?>
}