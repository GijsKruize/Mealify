package com.example.mealify.data


import com.example.mealify.R
import com.example.mealify.data.ProductGenerator.genProductKeys
import com.example.mealify.data.ProductGenerator.generateProductsArray as generateProductsArray1

object RecipeGenerator {
    val readurl: String = "test"
    val Salad = RecipeData(
        "Fruit Salad",
        arrayOf("apple", "banana"),
        "Apple, Banana, Salt, Pepper",
        "20 minutes",
        R.drawable.apple,
        "put everything in a bowl and cut it up"
    )
    val Salad1 = RecipeData(
        "Pear and lettuce Salad",
        arrayOf("pear", "lettuce"),
        "Pear, lettuce, Salt, Pepper",
        "20 minutes",
        R.drawable.pear,
        "put everything in a bowl and cut it up"
    )
    val allRecipeData: Array<RecipeData> = arrayOf(Salad, Salad1)


    fun checkPossible(input: String): Array<RecipeData> {
        val currentIngredients = genProductKeys(input)
        var possibleRecipeData: Array<RecipeData> = emptyArray()
        for (item1 in allRecipeData) {
            var hasAllIngredientsL = emptyArray<Boolean>()
            for (item2 in item1.ingredients) {
                var hasIngredientL = emptyArray<Boolean>()
                for (item3 in currentIngredients)
                    if (item2 == item3)
                        hasIngredientL += true
                hasAllIngredientsL += hasIngredientL.contains(true)
            }
            if (!hasAllIngredientsL.contains(false)) possibleRecipeData += item1
        }
        return possibleRecipeData
    }

    fun genRecipeNames(input: String): Array<String> {
        val possibleRecipeData = checkPossible(input)
        var recipeNames : Array<String> = emptyArray()
        for(item in possibleRecipeData){
            recipeNames += item.name
        }
        return recipeNames
    }

    fun genRecipeIngredients(input: String): Array<String> {
        val possibleRecipeData = checkPossible(input)
        var recipeIngredients : Array<String> = emptyArray()
        for(item in possibleRecipeData){
            recipeIngredients += item.actIngredients
        }
        return recipeIngredients
    }

    fun genRecipePics(input: String): Array<Int> {
        val possibleRecipeData = checkPossible(input)
        var recipePics : Array<Int> = emptyArray()
        for(item in possibleRecipeData){
            recipePics += item.image
        }
        return recipePics
    }

    fun genRecipeDescription(input: String): Array<String> {
        val possibleRecipeData = checkPossible(input)
        var recipeDescription : Array<String> = emptyArray()
        for(item in possibleRecipeData){
            recipeDescription += item.description
        }
        return recipeDescription
    }


}