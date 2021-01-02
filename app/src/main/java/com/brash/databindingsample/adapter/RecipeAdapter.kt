package com.brash.databindingsample.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.brash.databindingsample.R
import com.brash.databindingsample.databinding.ItemLayoutBinding
import com.brash.databindingsample.model.Recipe
import com.brash.databindingsample.model.Recipes
import com.brash.databindingsample.setImageUrl

class RecipeAdapter (private val recipes: ArrayList<Recipe>) :
    RecyclerView.Adapter<RecipeAdapter.ListRecipeViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListRecipeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemLayoutBinding>(layoutInflater, R.layout.item_layout, parent, false)
        return ListRecipeViewHolder(binding)
    }

    override fun getItemCount(): Int = recipes.size

    override fun onBindViewHolder(holder: ListRecipeViewHolder, position: Int) {
        val recipe = recipes.get(position)
        holder.binding.recipe = recipe
        if(recipe.image.isNotEmpty()){
            holder.binding.imageRecipe.setImageUrl(recipe.image)
        }
    }

    inner class ListRecipeViewHolder(val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root)
}

