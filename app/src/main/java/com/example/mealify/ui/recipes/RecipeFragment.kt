package com.example.mealify.ui.recipes

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mealify.R
import com.example.mealify.ui.detailing.RecipeDetailingActivity
import com.example.mealify.ui.recipes.descriptions.DescriptionsFragment

@Suppress("DEPRECATION")
class RecipeFragment : Fragment() {

    private lateinit var recipeAdapter: RecipeAdapter
    private lateinit var rv: RecyclerView
    private lateinit var recipeArrayList: ArrayList<Recipes>

    private lateinit var recipeImageID: Array<Int>
    private lateinit var recipeName: Array<String>

    // This property is only valid between onCreateView and
    // onDestroyView.

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val v = inflater.inflate(R.layout.fragment_recipe, container, false)
        return v
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

    private fun recipeInitialize() {
        recipeArrayList = arrayListOf<Recipes>()

        recipeImageID = arrayOf(
            R.drawable.banana,
            R.drawable.banana,
            R.drawable.banana,
            R.drawable.banana,
            R.drawable.banana,
            R.drawable.banana,
            R.drawable.banana
        )
        recipeName = arrayOf(
            "name1",
            "name2",
            "name3",
            "name4",
            "name5",
            "name6",
            "name7"
        )
        // Set the above initialized data to the correct place
        for (i in recipeImageID.indices) {
            val recipes = Recipes(recipeName[i], recipeImageID[i])
            recipeArrayList.add(recipes)
        }
    }
}