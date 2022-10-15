package com.example.mealify.data

import java.net.HttpURLConnection
import java.net.URL


public class ProductGenerator {
    private fun webPageReader(input: String): String {
        val url = URL(input)
        val urlConnection = url.openConnection() as HttpURLConnection

        try {
            return urlConnection.inputStream.bufferedReader().readText()
        } finally {
            urlConnection.disconnect()
        }
    }

     public fun generateProductsArray(input: String): Array<String> {
        return webPageReader(input).split(",").toTypedArray()
    }

    public fun generateImageArray(input: String): Array<String> {
        val productsArray = generateProductsArray(input)
        val amountProducts = productsArray.size

        val imageArray: Array<String> = emptyArray<String>()
        for (i in 1..amountProducts){
            imageArray.plusElement("R.drawable."+productsArray[i])
        }
        return  imageArray
    }
}