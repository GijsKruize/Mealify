package com.example.mealify.data

import android.text.BoringLayout
import com.example.mealify.R
import com.example.mealify.data.ProductGenerator.generateProductsArray

object RecipeGenerator {
    val readurl: String = "test"
    val Salad = RecipeData(
        "Fruit Salad",
        arrayOf("apple", "banana"),
        "20 minutes",
        R.drawable.apple,
        "put everything in a bowl and cut it up"
    )
    val Salad1 = RecipeData(
        "Pear and lettuce Salad",
        arrayOf("pear", "lettuce"),
        "20 minutes",
        R.drawable.pear,
        "put everything in a bowl and cut it up"
    )
    val allRecipeData: Array<RecipeData> = arrayOf(Salad, Salad1)


    fun checkPossible() {
        val currentIngredients = arrayOf("apple", "pear", "lettuce")
        var possibleRecipeData: Array<RecipeData> = emptyArray()
        for (item1 in allRecipeData) {
            var hasAllIngredientsL = emptyArray<Boolean>()
            for (item2 in item1.ingredients) {
                var hasIngredientL = emptyArray<Boolean>()
                for (item3 in currentIngredients)
                    if (item2 == item3)
                        hasIngredientL += true
                hasAllIngredientsL += hasIngredientL.any(it = true)
            }
            if (hasAllIngredientsL.any(it = true)) possibleRecipeData += item1
        }
    }
}


