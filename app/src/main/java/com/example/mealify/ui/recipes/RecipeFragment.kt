package com.example.mealify.ui.recipes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mealify.R

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


    private fun recipeInitialize() {
        recipeArrayList = arrayListOf()

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
            "Recipe 1",
            "Recipe 2",
            "Recipe 3",
            "Recipe 4",
            "Recipe 5",
            "Recipe 6",
            "HOW DOES THE APP HANDLE THE USE OF EXTREMELY LONG RECIPE NAMES LIKE THIS ONE AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
        )
        // Set the above initialized data to the correct place
        for (i in recipeImageID.indices) {
            val recipes = Recipes(recipeName[i], recipeImageID[i])
            recipeArrayList.add(recipes)
        }
    }
}