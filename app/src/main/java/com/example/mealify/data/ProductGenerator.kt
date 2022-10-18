package com.example.mealify.data

import com.example.mealify.R


object ProductGenerator {
    private fun webPageReader(input: String): String {
        return "apple,banana,aubergine,cabbage,pear,bellpepper"
    }

    fun generateProductsArray(input: String): Array<String> {
        return webPageReader(input).split(",").toTypedArray()
    }

//    fun generateImageArray(input: String): Array<Int> {
//        val productsArray = generateProductsArray(input)
//
//        return  imageArray
//    }
}