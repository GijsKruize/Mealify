package com.example.mealify.data

import com.example.mealify.R

data class RecipeData(
    var name: String,
    var ingredients: Array<String>,
    var actIngredients: String,
    var time: String,
    var image: Int,
    var description: String
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as RecipeData

        if (name != other.name) return false
        if (!ingredients.contentEquals(other.ingredients)) return false
        if (time != other.time) return false
        if (image != other.image) return false
        if (description != other.description) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + ingredients.contentHashCode()
        result = 31 * result + time.hashCode()
        result = 31 * result + image
        result = 31 * result + description.hashCode()
        return result
    }
}
