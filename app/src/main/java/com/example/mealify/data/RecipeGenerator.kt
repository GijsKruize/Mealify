package com.example.mealify.data


import com.example.mealify.R
import com.example.mealify.data.ProductGenerator.genProductKeys
import com.example.mealify.data.ProductGenerator.generateProductsArray as generateProductsArray1

object RecipeGenerator {
    val readurl: String = "test"
    val Salad = RecipeData(
        "Fruit Salad",
        arrayOf("apple", "banana", "orange"),
        "Ingredients:  Apple, Banana, Orange, 2tbs of sugar",
        "5 minutes",
        R.drawable.fruit_salad,
        "Remove the core from the apple, and cut it up in to cubes of around 2 cm." + " Peal the orange and cut the wedges in 3 pieces." + " Peal the banana and cut it into 1.5 cm slices." + " Add everything into a bowl, optionally you can add 2 tbs of sugar to make it sweeter"
    )
    val Salad1 = RecipeData(
        "Pear and lettuce Salad",
        arrayOf("carrot", "apple"),
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

    fun genRecipeTime(input: String): Array<String> {
        val possibleRecipeData = checkPossible(input)
        var recipeTime : Array<String> = emptyArray()
        for(item in possibleRecipeData){
            recipeTime += item.time
        }
        return recipeTime
    }

    fun genRecipeIngredients(input: String): Array<String> {
        val possibleRecipeData = checkPossible(input)
        var recipeIngredients : Array<String> = emptyArray()
        for(item in possibleRecipeData){
            recipeIngredients += item.actIngredients
        }
        return recipeIngredients
    }
}