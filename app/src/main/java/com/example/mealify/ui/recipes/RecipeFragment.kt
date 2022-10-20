package com.example.mealify.ui.recipes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mealify.R
import com.example.mealify.data.RecipeGenerator.genRecipeDescription
import com.example.mealify.data.RecipeGenerator.genRecipeNames
import com.example.mealify.data.RecipeGenerator.genRecipePics

@Suppress("DEPRECATION")
class RecipeFragment : Fragment() {

    private lateinit var recipeAdapter: RecipeAdapter
    private lateinit var rv: RecyclerView
    private lateinit var recipeArrayList: ArrayList<Recipes>

    private lateinit var recipeImageID: Array<Int>
    private lateinit var recipeName: Array<String>
    private lateinit var recipeDescription: Array<String>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_recipe, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize the data to be displayed in the cards in the recyclerview
        recipeInitialize()

        // Create a layout manager and assign it (and the adapter made in ProductAdapter) to the recyclerview
        val layoutManager = LinearLayoutManager(context)
        rv = view.findViewById(R.id.idRecipes)
        rv.layoutManager = layoutManager
        rv.setHasFixedSize(true)
        recipeAdapter = RecipeAdapter(recipeArrayList)
        rv.adapter = recipeAdapter
    }

    //Pretty self-explanatory
    private fun recipeInitialize() {
        val input : String = "test"
        recipeArrayList = arrayListOf()

        recipeImageID = genRecipePics(input)
        recipeName = genRecipeNames(input)
        recipeDescription = genRecipeDescription(input)
        // Set the above initialized data to the correct place
        for (i in recipeImageID.indices) {
            val recipes = Recipes(recipeName[i], recipeImageID[i], recipeDescription[i])
            recipeArrayList.add(recipes)
        }
    }
}