package com.brash.databindingsample.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.brash.databindingsample.R
import com.brash.databindingsample.adapter.RecipeAdapter
import com.brash.databindingsample.model.Recipe
import com.brash.databindingsample.model.Recipes
import com.brash.databindingsample.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var adapter: RecipeAdapter
    private var recipes: ArrayList<Recipe> = ArrayList()
    private lateinit var viewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel =  ViewModelProvider(this).get(MainViewModel::class.java)
        getRecipes()
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        linearLayoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recipesRecycler.layoutManager = linearLayoutManager
        adapter = RecipeAdapter(recipes)
        recipesRecycler.adapter = adapter
    }

    private fun updateList(data: Recipes) {
        progressBar.visibility = View.GONE
        recipes.clear()
        recipes.addAll(data.recipes)
        adapter.notifyItemInserted(recipes.size - 1)
    }

    private fun showError(message: String) {
        progressBar.visibility = View.GONE
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    private fun showLoading() {
        progressBar.visibility = View.VISIBLE
    }

    private fun getRecipes() {
        showLoading()
        viewModel.getRecipes().observe(this, Observer { recipes ->
            progressBar.visibility = View.GONE
            if (recipes == null) {
                showError("Erreur ....")
            } else {
                updateList(recipes)
            }
        })
    }
}