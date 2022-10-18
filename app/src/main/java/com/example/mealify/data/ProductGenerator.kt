package com.example.mealify.data

import org.jsoup.Jsoup
import java.net.URL
import javax.net.ssl.HttpsURLConnection


object ProductGenerator {
    private fun webPageReader(input: String): String {
        val url = URL(input)
        val urlConnection = url.openConnection() as HttpsURLConnection

        Jsoup.parse(htmlString).title()
        try {
            return urlConnection.inputStream.bufferedReader().readText()
        } finally {
            urlConnection.disconnect()
        }
    }

     fun generateProductsArray(input: String): Array<String> {
        return webPageReader(input).split(",").toTypedArray()
    }

    fun generateImageArray(input: String): Array<String> {
        val productsArray = generateProductsArray(input)
        val amountProducts = productsArray.size

        val imageArray: Array<String> = emptyArray()
        for (i in 1..amountProducts){
            imageArray.plusElement("R.drawable."+productsArray[i])
        }
        return imageArray
    }
}