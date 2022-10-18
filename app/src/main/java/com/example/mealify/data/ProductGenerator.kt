package com.example.mealify.data

import org.jsoup.Jsoup
import org.jsoup.nodes.Document




object ProductGenerator {
    private fun webPageReader(input: String): String {

        val doc : Document = Jsoup.connect(input).get()
        return doc.select("p").text()
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
        return  imageArray
    }
}