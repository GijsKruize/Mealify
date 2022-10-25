package com.example.mealify.data

import com.example.mealify.R


object ProductGenerator {
    val apple = ProductData("apple", "Apple", R.drawable.apple)
    val banana = ProductData("banana", "Banana", R.drawable.banana)
    val beetroot = ProductData("beetroot", "Beetroot", R.drawable.beetroot)
    val bellpepper = ProductData("bellpepper", "Bell pepper", R.drawable.bellpepper)
    val cabbage = ProductData("cabbage", "Cabbage", R.drawable.cabbage)
    val capsicum = ProductData("capsicum", "Capsicum", R.drawable.capsicum)
    val carrot = ProductData("carrot", "Carrot", R.drawable.carrot)
    val cauliflower = ProductData("cauliflower", "Cauliflower", R.drawable.cauliflower)
    val chillipepper = ProductData("chilli pepper", "Chilli pepper", R.drawable.chili)
    val corn = ProductData("corn", "Corn", R.drawable.corn)
    val cucumber = ProductData("cucumber", "Cucumber", R.drawable.cucumber)
    val eggplant = ProductData("eggplant", "Eggplant", R.drawable.aubergine)
    val garlic = ProductData("garlic", "Garlic", R.drawable.garlic)
    val ginger = ProductData("ginger", "Ginger", R.drawable.ginger)
    val grapes = ProductData("grapes", "Grapes", R.drawable.grapes)
    val jalepeno = ProductData("jalepeno", "Jalapeno", R.drawable.jalapeno)
    val kiwi = ProductData("kiwi", "Kiwi", R.drawable.kiwi)
    val lemon = ProductData("lemon", "Lemon", R.drawable.lemon)
    val lettuce = ProductData("lettuce", "Lettuce", R.drawable.lettuce)
    val mango = ProductData("mango", "Mango", R.drawable.mango)
    val onion = ProductData("onion", "Onion", R.drawable.onion)
    val orange = ProductData("orange", "Orange", R.drawable.orange)
    val paprika = ProductData("paprika", "Paprika", R.drawable.paprika)
    val pear = ProductData("pear", "Pear", R.drawable.pear)
    val pineapple = ProductData("pineapple", "Pineapple", R.drawable.pineapple)
    val pomegranate = ProductData("pomegranate", "Pomegranate", R.drawable.pomegranate)
    val potato = ProductData("potato", "Potato", R.drawable.potatoes)
    val raddish = ProductData("raddish", "Radish", R.drawable.radish)
    val soybeans = ProductData("soybeans", "Soybeans", R.drawable.soy)
    val spinach = ProductData("spinach", "Spinach", R.drawable.spinach)
    val sweetcorn = ProductData("sweetcorn", "Sweetcorn", R.drawable.corn)
    val sweetpotato = ProductData("sweetpotato", "Sweet potato", R.drawable.sweetpotato)
    val tomato = ProductData("tomato", "Tomato", R.drawable.tomato)
    val turnip = ProductData("turnip", "Turnip", R.drawable.turnip)
    val watermelon = ProductData("watermelon", "Watermelon", R.drawable.watermelon)

    val allProductData = arrayOf(
        apple,
        banana,
        beetroot,
        bellpepper,
        cabbage,
        capsicum,
        carrot,
        cauliflower,
        chillipepper,
        chillipepper,
        corn,
        cucumber,
        eggplant,
        garlic,
        ginger,
        grapes,
        jalepeno,
        kiwi,
        lemon,
        lettuce,
        mango,
        onion,
        orange,
        paprika,
        pear,
        pineapple,
        pomegranate,
        potato,
        raddish,
        soybeans,
        spinach,
        sweetcorn,
        sweetpotato,
        tomato,
        turnip,
        watermelon
    )

    private fun webPageReader(input: String): String {
        return "banana,carrot,orange,apple"
    }
    fun genProductKeys(input: String): Array<String>{
        return webPageReader(input).split(",").toTypedArray()
    }
    fun generateProductsArray(input: String): Array<ProductData> {
        val keys = genProductKeys(input)
        var products: Array<ProductData> = emptyArray()
        for (item in allProductData) {
            for (item2 in keys) {
                if (item.key == item2) {
                    products += item
                }
            }
        }
        return products
    }

    fun genProductNames(input: String): Array<String> {
        val possibleProductData = generateProductsArray(input)
        var productNames: Array<String> = emptyArray()
        for (item in possibleProductData) {
            productNames += item.name
        }
        return productNames
    }

    fun genProductPics(input: String): Array<Int> {
        val possibleProductData = generateProductsArray(input)
        var productPics: Array<Int> = emptyArray()
        for (item in possibleProductData) {
            productPics += item.icon
        }
        return productPics
    }

}