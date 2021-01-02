package com.brash.databindingsample.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.brash.databindingsample.model.Recipes
import com.brash.databindingsample.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RecipeRepositoryImp : RecipeRepository{
    val data = MutableLiveData<Recipes>()
    override fun getRecipes() : LiveData<Recipes?> {
            val recipesRequest = ApiClient.getClient.getRecipes()
        recipesRequest.enqueue(object : Callback<Recipes> {
                    override fun onResponse(call: Call<Recipes>, response: Response<Recipes>) {

                        data.value = response.body()
                    }
                    override fun onFailure(call: Call<Recipes>, t: Throwable) {
                        data.value = null
                    }
                })
     return data
    }
}